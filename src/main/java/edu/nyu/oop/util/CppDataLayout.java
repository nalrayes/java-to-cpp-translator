package edu.nyu.oop.util;

import java.util.ArrayList;

import edu.nyu.oop.*;
import xtc.tree.GNode;
import java.util.Map;

import java.util.HashMap;

public class CppDataLayout {
    public static ArrayList<CppStruct> structs;
    public static ArrayList<VTable> VTables;

   // public static HashMap<String, CustomClassObject> structsMap;



    public static final int DEBUGGING = 1;

    public CppDataLayout(){
        //Use this default constructor to create the deafult __Object data layout

       // structsMap = new HashMap<>();
        structs = new ArrayList<CppStruct>();
        VTables = new ArrayList<VTable>();
    }

    public CppDataLayout(CppDataLayout parentDataLayout, CustomClassObject childJavaClassObject){
        //Use this constructor to take in a parentDataLayout and the javaCustomClass
        //Check javaCustomClassObj against the parentDataLayout for overidden methods

        structs = new ArrayList<CppStruct>();
        VTables = new ArrayList<VTable>();
        ArrayList<VTMethod> parentMethods;

        parentDataLayout.getStructs();


    }

    @Override
    public String toString() {
        return super.toString();
    }

    // Helper method to translate java types to C++ types
    public static class typeTranslate {

        // TODO: make static
        public String translateType(String javaType) {

            String cType = "";

            switch (javaType) {

                case "int":
                    cType = "int32_t";
                    break;


                case "VoidType":
                    cType = "void";
                    break;

                default:
                    cType = javaType;
                    break;


            }

            return cType;
        }

    }

    // used for checking overriden methods only
    public static class CppFileObject{

        JavaFileObject javaFile;


        public CppFileObject(JavaFileObject javaFile){

            this.javaFile = javaFile;



        }


    }


    public static class CppFile{


        ArrayList<CppStruct> structs;

        public CppFile(CppStruct cppStruct){

            structs.add(cppStruct);




        }



    }





    public static class CppStruct {

        ArrayList<CppVar> variables;
        ArrayList<CppMethod> methods;


        String name;
        String classDeclarator;
        String VTableDeclarator;
        String parentName;
        String custTypedef;
        String VTPointer;



        ArrayList<CppConstructor> constructors;

        public CppStruct(CustomClassObject c) {
            this.variables = new ArrayList<CppVar>();
            this.methods = new ArrayList<CppMethod>();
            this.parentName = c.getParentClass();
            this.VTPointer = "__" + c.getClassName() + "_VT* __vptr";

            this.name = "__" + c.getClassName();
            this.classDeclarator = "static Class __class()";
            this.VTableDeclarator = "static __" + c.getClassName() + "_" +"VT" + " __vtable";
            this.custTypedef = "__" + c.getClassName() +"* " + c.getClassName();


            this.constructors = new ArrayList<CppConstructor>();

            // instantiates all data
            for (CustomMethodClass javaMethod : c.getMethods()) {

                CppMethod cMethod = new CppMethod(javaMethod, c);
                methods.add(cMethod);

            }
            if (c.getConstructors().size() > 0) {
                for (CustomConstructorClass javaConstructor : c.getConstructors()) {


                    CppMethod cppConstructor = new CppMethod(javaConstructor);
                    this.methods.add(cppConstructor);

                }
            } else {
                // make default constructor
                CppMethod defaultConstructor = new CppMethod("__init", c.getClassName());

                this.methods.add(defaultConstructor);

                System.out.println(defaultConstructor);
            }


            for (CustomVariablesClass javaVar : c.getClassVariables()) {

                CppVar cVar = new CppVar(javaVar);
                this.variables.add(cVar);


            }

            structs.add(this);
           // structsMap.put(c.getClassName(), c);




        }

        public CppStruct(){}

        public String getName() {
            return name;
        }

        public String getParentName() {
            return parentName;
        }

        public ArrayList<CppMethod> getMethods() {
            return methods;
        }
    }

    public static class CppConstructor {
        ArrayList<CustomVariablesClass> parameters;
        String name;
        String visibility;


        public CppConstructor(CustomConstructorClass c) {


            this.name = "__" + c.getName();
            this.parameters = c.getParameters();
            this.visibility = c.getVisibility();


        }


    }

    public static class CppMethod {

        String name;

        String modifier;
        String visibility;
        String returnType;
        ArrayList<CppParameter> parameters;
        String methodOwner;
        String fullLine;

        public CppMethod(CustomMethodClass m, CustomClassObject c) {
            parameters = new ArrayList<CppParameter>();

            this.name =  m.getName();
            this.modifier = m.getModifier();
            this.visibility = m.getVisibility();
            this.methodOwner = m.getOwnerClass();
            typeTranslate translateType = new typeTranslate();
            this.returnType = translateType.translateType(m.getReturnType());
            //this.fullLine = "static " + this.returnType +" " + m.getName()  + "(**" +"**)";



           // this.parameters.add(c.getClassName());
            // translates and add java method params to cpp method params
            CppParameter classParam = new CppParameter(c.getClassName(), c.getClassName());
            CppParameter objectParam = new CppParameter("Object", "Object");
            if (m.getName().equals("equals")){
                this.parameters.add(classParam);
                this.parameters.add(objectParam);

            }
            else{
                this.parameters.add(classParam);

            }


            for (CustomVariablesClass javaParam : m.getParameters()) {


                CppParameter cParam = new CppParameter(javaParam);
                this.parameters.add(cParam);

            }



        }

        public CppMethod(CustomConstructorClass c) {
            parameters = new ArrayList<CppParameter>();

            this.name = "__init";
            this.returnType = c.getName();

            for (CustomVariablesClass javaParam :c.getParameters()) {
                CppParameter cParam = new CppParameter(javaParam);
                this.parameters.add(cParam);
            }

        }

        // used for creating default constructor object
        public CppMethod(String name, String returnType) {
            parameters = new ArrayList<CppParameter>();

            this.name = name;
            this.returnType = returnType;
        }


    }


    public static class Field {
        public String name;
        public String type;
        public ArrayList<String> modifiers;

        public Field() {
        }
    }


    public static class CppParameter {
        String name;
        String type;


        public CppParameter(CustomVariablesClass v) {

            typeTranslate translateType = new typeTranslate();
            this.name = v.getName();
            this.type = translateType.translateType(v.getType());


        }

        public CppParameter(String name, String type){
            this.name = name;
            this.type = type;
        }

    }


    public static class CppVar {
        String name;
        String type;
        String modifier;


        public CppVar(CustomVariablesClass v) {

            typeTranslate translateType = new typeTranslate();
            this.name = v.getName();
            this.type = translateType.translateType(v.getType());
            this.modifier = v.getModifier();

        }


    }


    public static class InheritedMethodChecker{

        String methodName;



        public InheritedMethodChecker(String m, boolean isOverride){




        }


    }

    public static ArrayList<CustomMethodClass> createDefaultMethods() {
        ArrayList<CustomMethodClass> methods = new ArrayList<CustomMethodClass>();

        // hashCode
        CustomMethodClass hashCode = new CustomMethodClass();
        hashCode.setName("hashCode");
        hashCode.setOwnerClass("None");
        hashCode.setReturnType("int");

        // getClass
        CustomMethodClass getClass = new CustomMethodClass();
        getClass.setName("getClass");
        getClass.setReturnType("Class");
        getClass.setOwnerClass("None");

        // toString
        CustomMethodClass toString = new CustomMethodClass();
        toString.setName("toString");
        toString.setReturnType("String");
        toString.setOwnerClass("None");

        // equals
        CustomMethodClass equals = new CustomMethodClass();
        equals.setName("equals");
        equals.setReturnType("boolean");
        equals.setOwnerClass("None");

        methods.add(hashCode);
        methods.add(getClass);
        methods.add(toString);
        methods.add(equals);

        return methods;

    }

    public static ArrayList<String> getMethodNames(ArrayList<CustomMethodClass> methods) {
        ArrayList<String> methodNames = new ArrayList<String>();
        for (CustomMethodClass m : methods) {
            methodNames.add(m.getName());
        }
        return methodNames;
    }




    public static class VTInstantiator {

        String randoCurls;
        String isA;

        String declarationName;

        ArrayList<CustomMethodClass> inheritedMethods;


        ArrayList<VTInstantiatorMethod> VTInstantiatorMethods;

        public String getIsA() {
            return isA;
        }

        // non overridden methods
        public VTInstantiator(CustomClassObject currStruct, HashMap<String, CustomClassObject> classMap) {
            this.VTInstantiatorMethods = new ArrayList<VTInstantiatorMethod>();
            this.inheritedMethods = new ArrayList<CustomMethodClass>();

            this.isA = " : __is_a(__" + currStruct.getClassName() + "::__class()),";
            this.declarationName = "__" + currStruct.getClassName() + "_VT()";
            this.randoCurls = "{\n}";

            CustomClassObject tempStruct = currStruct;


           // tempStruct = currStruct;

            // Get all methods that the current class inherits
            System.out.println("*****************CLASS NAME");

            System.out.println(currStruct.getClassName());
            System.out.println("*****************");

            System.out.println("!!!");
            System.out.println(inheritedMethods);
            System.out.println(tempStruct.getParentClass());


            // gets inherited methods of a class
            while (tempStruct.getParentClass() != "None") {

                String getParentStructName = tempStruct.getParentClass();

                // get all methods of parent class
                CustomClassObject parentClass = classMap.get(getParentStructName);

                for (CustomMethodClass method : parentClass.getMethods()) {

                    ArrayList<String> inheritedMethodNames = getMethodNames(inheritedMethods);
                    // checking if method is overwritten
                    if ((!inheritedMethodNames.contains(method.getName()))) {

                        method.setOwnerClass(parentClass.getClassName());
                        inheritedMethods.add(method);


                    }

                }

                tempStruct = parentClass;
            }

            // adding default methods to inheritedMethods to check for overriding
            ArrayList<CustomMethodClass> defaultMethods = createDefaultMethods();

            ArrayList<String> names = getMethodNames(inheritedMethods);
            for (CustomMethodClass m : defaultMethods) {
                String name = m.getName();

                if (!(names.contains(name))) {
                    inheritedMethods.add(m);
                }
            }

//            inheritedMethods.addAll(overwriddenMethods);

            ArrayList<VTInstantiatorMethod> overwrittenMethods = new ArrayList<VTInstantiatorMethod>();
            // check if current class overrides any of these methods
            int index = 0;
            ArrayList<String> inheritedMethodNames = getMethodNames(inheritedMethods);
            int k = 0;
            boolean isLastMethod = false;


            for (CustomMethodClass m1 : currStruct.getMethods()) {
                if (k == currStruct.getMethods().size() -1 ){

                    isLastMethod = true;

                }
                m1.setOwnerClass(currStruct.getClassName());
                // if m isnt in overwritten methods, add it to vtinstantiator
                if (!(inheritedMethodNames.contains(m1.getName()))) {
                    VTInstantiatorMethod vtiMethod = new VTInstantiatorMethod(m1, currStruct.getClassName(), isLastMethod, true);
                    overwrittenMethods.add(vtiMethod);
                }
            }


            for (CustomMethodClass m : inheritedMethods){
                 isLastMethod = false;

                if (index == currStruct.getMethods().size() -1 ){

                    isLastMethod = true;

                }




                boolean isOverriden = false;
                // if contains override

                if (!currStruct.getMethodNames().contains(m.getName())){
                    isOverriden = false;
                    m.setOwnerClass(currStruct.getClassName());

                String className = currStruct.getClassName();

                    // create overridden instantiator

                    VTInstantiatorMethod vtiMethod = new VTInstantiatorMethod(m, className, isLastMethod, isOverriden);
                    VTInstantiatorMethods.add(vtiMethod);

                   // add to list of vt instantiatior methods


                }
                else {
                    String className = currStruct.getClassName();
                    isOverriden = true;
                    VTInstantiatorMethod vtiMethod = new VTInstantiatorMethod(m, className, isLastMethod, isOverriden);
                    overwrittenMethods.add(vtiMethod);


                }

                index++;
                // add instantiator to methodlist


            }





            VTInstantiatorMethods.addAll(overwrittenMethods);






        }
            // set defaults

//            //pre-made methods



            // gets custom methods


            // currstruct get parent
            // find parent in the map and get its methods
            // then compare those methods to the current class's methods

            //ArrayList<CustomMethodClass> inheritedMethods = new ArrayList<CustomMethodClass>();
            //CustomClassObject presentStruct = new CustomClassObject();

//            String currClassParent = currClass.getParentClass();
//
//            ArrayList <CustomMethodClass> parentMethods = structsMap.get(currClass.getClassName());
//
//
//            int index = 0;











//
//
//            for (CustomMethodClass currMethod : currClass.getMethods()){
//
//                // just for commas
//                boolean isLastMethod = false;
//                if (index == currClass.getMethods().size()) {
//                    isLastMethod = true;
//                }
//                for (CustomMethodClass parentMethod : parentMethods){
//                    boolean isOverridden = false;
//                    // if the method is overriden
//                    if (currMethod.getName().equals(parentMethod.getName())){
//                        isOverridden = true;
//
//
//                    }
//                    VTInstantiatorMethod currVTInst = new VTInstantiatorMethod(currMethod, currClass.getClassName(), isLastMethod, isOverridden);
//
//                    // else the method is not overriden
//
//                    if (DEBUGGING == 1) {
//
//                        String instantName = "";
//
//                        //instantName += (this.returnType + " " + pointer + "" + className);
//                        System.out.println(this.declarationName);
//                        System.out.println(this.isA);
//                        System.out.println(currVTInst.getReturnTypeClassName());
//                        System.out.println(this.randoCurls);
//                        System.out.println("________________");
//                        // System.out.println("return type " + this.returnType);
//
//                        System.out.println("________________");
//                    }
//
//
//
//                }
//
//            }


        public String getDeclarationName() {
            return declarationName;
        }


        public ArrayList<VTInstantiatorMethod> getVTInstantiatorMethods() {
            return VTInstantiatorMethods;
        }
    }






        public static class VTInstantiatorMethod{

            String objectReference;
            String returnTypeClassName;
            String fullLine;





            public VTInstantiatorMethod(CustomClassObject current){}






            // for overriden methods
            public VTInstantiatorMethod(CustomMethodClass method, String className, boolean isLastMethod, boolean isOverridden){

                typeTranslate translateType = new typeTranslate();
                String returnT = translateType.translateType(method.getReturnType());
                fullLine = "";

                if (isOverridden) {;
                    this.objectReference = method.getName() + "(&__" + className + "::" + method.getName() + ")";
                    this.fullLine = this.objectReference;
                }
                else {
                    this.objectReference = method.getName();

                    // get parent class
                    if (method.getOwnerClass() != "None") {
                        if (!method.getName().equals("equals")) {
                            this.returnTypeClassName = "((" + returnT + " (*)(" + className + "))" + " &__" + method.getOwnerClass() + "::" + method.getName() + ")";
                        }
                        else{
                            this.returnTypeClassName = "((" + returnT + " (*)(" + className + ", Object" +"))" + " &_" + method.getOwnerClass() + "::" + method.getName() + ")";

                        }

                    }
                    else {
                        if (!method.getName().equals("equals")) {
                            this.returnTypeClassName = "((" + returnT + " (*)(" + className + "))" + " &__Object::" + method.getName() + ")";
                        }
                        else{
                            this.returnTypeClassName = "((" + returnT + " (*)(" + className + ", Object" +"))" + " &__Object::" + method.getName() + ")";

                        }
                    }
                    this.fullLine = this.objectReference + this.returnTypeClassName;
                }
                if (!isLastMethod) {
                    this.returnTypeClassName += ",";
                }




            }


            // for default methods
            public VTInstantiatorMethod (String rTCN) {
                this.returnTypeClassName = rTCN;
                fullLine = this.returnTypeClassName;
            }

            // TODO: add constructor for custom non overidden methods


            public String getObjectReference() {
                return objectReference;
            }

            public String getFullLine() {
                return fullLine;
            }

            public String getReturnTypeClassName() {
                return returnTypeClassName;
            }
        }




        public static class VTable {
            String is_a;
            ArrayList<VTMethod> VTMethods;

            ArrayList<VTInstantiator> VTInstantiators;
            String name;


            // gets factory methods






            public VTable(CustomClassObject currClass, HashMap<String, CustomClassObject> classMap) {

                this.name = currClass.getClassName();

                this.VTInstantiators = new ArrayList<VTInstantiator>();
                this.VTMethods = new ArrayList<VTMethod>();
                this.is_a = "Class __is_a";
                ArrayList<CustomMethodClass> VTInheritedmethods = new ArrayList<CustomMethodClass>();

                CustomClassObject tempStruct = currClass;

                // Get all methods that the current class inherits
                while (tempStruct.getParentClass() != "None") {

                    String getParentStructName = tempStruct.getParentClass();

                    System.out.println("ASDASDASDASD");
                    System.out.println(getParentStructName);
                    // get all methods of parent class
                    CustomClassObject parentClass = classMap.get(getParentStructName);

                    for (CustomMethodClass method : parentClass.getMethods()) {
                        System.out.println("!!!!!!!");
                        System.out.println(method.getName());
                        ArrayList<String> inheritedMethodNames = getMethodNames(VTInheritedmethods);
                        // checking if method is overwritten
                        if ((!inheritedMethodNames.contains(method.getName()))) {

                            method.setOwnerClass(parentClass.getClassName());
                            VTInheritedmethods.add(method);


                        }

                    }

                    tempStruct = parentClass;
                }

                // adding default methods to inheritedMethods to check for overriding
                ArrayList<CustomMethodClass> defaultMethods = createDefaultMethods();

                ArrayList<String> names = getMethodNames(VTInheritedmethods);
                for (CustomMethodClass m : defaultMethods) {
                    String name = m.getName();

                    if (!(names.contains(name))) {
                        VTInheritedmethods.add(m);
                    }
                }

                ArrayList<VTMethod> overwrittenVTMethods = new ArrayList<VTMethod>();
                // check if current class overrides any of these methods
                int index = 0;

                for (CustomMethodClass m : VTInheritedmethods){
                    boolean isLastMethod = false;

                    if (index == currClass.getMethods().size() -1 ){

                        isLastMethod = true;

                    }




                    boolean isOverriden = false;
                    // if contains override


                    System.out.println("OVERWRITTEN1111111111111111111111111111");
                    System.out.println(currClass.getClassName());
                    System.out.println(m.getName());
                    System.out.println(currClass.getMethods());

                    if (currClass.getMethodNames().contains(m.getName())){
                        isOverriden = true;
                        m.setOwnerClass(currClass.getClassName());

                        String className = currClass.getClassName();

                        // create overridden instantiator

                        VTMethod vtiMethod = new VTMethod(m, className, isLastMethod, isOverriden);
                        overwrittenVTMethods.add(vtiMethod);

                        // add to list of vt instantiatior methods


                    }
                    else {
                        String className = currClass.getClassName();
                        VTMethod vtiMethod = new VTMethod(m, className, isLastMethod, isOverriden);
                        VTMethods.add(vtiMethod);


                    }

                    index++;
                    // add instantiator to methodlist


                }

                ArrayList<String> inheritedMethodNames = getMethodNames(VTInheritedmethods);
                int k = 0;
                boolean isLastMethod = false;
                for (CustomMethodClass m : currClass.getMethods()) {
                    if (k == currClass.getMethods().size() -1 ){

                        isLastMethod = true;

                    }
                    m.setOwnerClass(currClass.getClassName());
                    // if m isnt in overwritten methods, add it to vtinstantiator
                    if (!(inheritedMethodNames.contains(m.getName()))) {
                        VTMethod vtiMethod = new VTMethod(m, currClass.getClassName(), isLastMethod, false);
                        VTMethods.add(vtiMethod);
                    }
                }

                VTMethods.addAll(overwrittenVTMethods);










                VTInstantiator vtInstantiator = new VTInstantiator(currClass, classMap);

                VTInstantiators.add(vtInstantiator);




                System.out.println("SIZE " + VTInstantiators.size() + " OF " + this.name);

                VTables.add(this);


            }

//            @Override
//            public String toString() {
//                for (VTMethod method : VTMethods){
//
//                    method.getClassName();
//
//                }
//
//
//            }
        }


        public static class VTMethod {

            String returnType;
            String pointer;
            String className;
            String returnTypeAndClassName;
            String entireMethod;
            String methodName;
            ArrayList<String> params;



            String objectReference;
            String returnTypeClassName;
            String fullLine;




            // for overriden methods
                public VTMethod(CustomMethodClass method, String className, boolean isLastMethod, boolean isOverridden){

                    typeTranslate translateType = new typeTranslate();
                    String returnT = translateType.translateType(method.getReturnType());
                    if (!method.getName().equals("equals")) {

                        this.fullLine = returnT + " (*" + method.getName() + ") (" + className + ")";
                    }
                    else{
                        this.fullLine = returnT + " (*" + method.getName() + ") (" + className + "," + " Object"+ ")";


                    }



                }



                // default methods
            public VTMethod(String rt, String pt, String className) {
                params = new ArrayList<String>();
                this.pointer = "(*"+pt +")";

                this.returnType = rt;
                this.className = "("+className +")";
                params.add(this.className);
                if (className.equals("hashCode")) {
                    params.add("Object");
                }
//


                    methodName = "";

                    methodName += (this.returnType + " " + this.pointer + "(" + this.className+")" +";");

                if (DEBUGGING == 1) {
                    System.out.println("________________");
                    // System.out.println("return type " + this.returnType);
                    System.out.println(methodName);
                    System.out.println("________________");
                }

            }

            public String getClassName() {
                return className;
            }

        }

    public static ArrayList<CppStruct> getStructs() {
        return structs;
    }
}




