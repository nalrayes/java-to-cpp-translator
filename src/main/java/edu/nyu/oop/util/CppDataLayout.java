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




       // structsMap = new HashMap<>();


    }

    @Override
    public String toString() {
        return super.toString();
    }

    // Helper method to translate java types to C++ types
    // TODO: add differing types
    public static class typeTranslate {

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


        ArrayList<CppConstructor> constructors;

        public CppStruct(CustomClassObject c) {
            this.variables = new ArrayList<CppVar>();
            this.methods = new ArrayList<CppMethod>();
            this.parentName = c.getParentClass();

            this.name = "__" + c.getClassName();
            this.classDeclarator = "static Class __class()";
            this.VTableDeclarator = "__" + name + "_" +"VT" + " __vtable";


            this.constructors = new ArrayList<CppConstructor>();

            // instantiates all data
            for (CustomMethodClass javaMethod : c.getMethods()) {

                CppMethod cMethod = new CppMethod(javaMethod);
                methods.add(cMethod);

            }

            for (CustomConstructorClass javaConstructor : c.getConstructors()) {


                CppConstructor cppConstructor = new CppConstructor(javaConstructor);
                this.constructors.add(cppConstructor);

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

        public CppMethod(CustomMethodClass m) {
            parameters = new ArrayList<CppParameter>();

            this.name = "__" + m.getName();
            this.modifier = m.getModifier();
            this.visibility = m.getVisibility();

            typeTranslate translateType = new typeTranslate();
            this.returnType = translateType.translateType(m.getReturnType());

            // translates and add java method params to cpp method params
            for (CustomVariablesClass javaParam : m.getParameters()) {


                CppParameter cParam = new CppParameter(javaParam);
                this.parameters.add(cParam);

            }


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

            while (tempStruct.getParentClass() != "None") {

                String getParentStructName = tempStruct.getParentClass();

                System.out.println("ASDASDASDASD");
                System.out.println(getParentStructName);
                // get all methods of parent class
                CustomClassObject parentClass = classMap.get(getParentStructName);

                for (CustomMethodClass method : parentClass.getMethods()) {
                    System.out.println("!!!!!!!");
                    System.out.println(method.getName());

                    // checking if method is overwritten
                    if ((!inheritedMethods.contains(method.getName()))) {

                        method.setOwnerClass(parentClass.getClassName());
                        inheritedMethods.add(method);


                    }

                }

                tempStruct = parentClass;
            }

            // adding default methods to inheritedMethods to check for overriding
            ArrayList<CustomMethodClass> defaultMethods = createDefaultMethods();

            ArrayList<String> inheritedMethodNames = getMethodNames(inheritedMethods);
            for (CustomMethodClass m : defaultMethods) {
                String name = m.getName();

                if (!(inheritedMethodNames.contains(name))) {
                    inheritedMethods.add(m);
                }
            }





            // check if current class overrides any of these methods
            int index = 0;

            for (CustomMethodClass m : inheritedMethods){
                boolean isLastMethod = false;

                if (index == currStruct.getMethods().size() -1 ){

                    isLastMethod = true;

                }




                boolean isOverriden = false;
                // if contains override


                System.out.println("OVERWRITTEN1111111111111111111111111111");
                System.out.println(currStruct.getClassName());
                System.out.println(m.getName());
                System.out.println(currStruct.getMethods());

                if (currStruct.getMethodNames().contains(m.getName())){
                    isOverriden = true;
                    m.setOwnerClass(currStruct.getClassName());

                String className = currStruct.getClassName();

                    // create overridden instantiator

                VTInstantiatorMethod vtiMethod = new VTInstantiatorMethod(m, className, isLastMethod, isOverriden);
                    VTInstantiatorMethods.add(vtiMethod);

                   // add to list of vt instantiatior methods


                }
                else{
                    String className = currStruct.getClassName();
                    VTInstantiatorMethod vtiMethod = new VTInstantiatorMethod(m, className, isLastMethod, isOverriden);
                    VTInstantiatorMethods.add(vtiMethod);


                }


                index++;
                // add instantiator to methodlist


            }






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


                    this.objectReference = "&__" + className + "::" + method.getName();
                }
                else {
                    // get parent class
                    if (method.getOwnerClass() != "None") {
                        this.objectReference = "&__" + method.getOwnerClass() + "::" + method.getName();
                    }
                    else {
                        this.objectReference = "&__Object" + "::" + method.getName();
                        this.returnTypeClassName = "((" + returnT + " (*)(" + className + "))";
                    }
                }
                this.returnTypeClassName = "((" + returnT + " (*)(" + className + "))";
                if (!isLastMethod) {
                    this.returnTypeClassName += ",";
                }
                fullLine = this.returnTypeClassName + this.objectReference ;



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
                VTMethod hashCodeMethod = new VTMethod("int32_t", "hashCode", currClass.getClassName());
                VTMethod equalsMethod = new VTMethod("bool", "equals", currClass.getClassName());
                VTMethod classMethod = new VTMethod("Class", "getClass", currClass.getClassName());
                VTMethod stringMethod = new VTMethod("String","toString", currClass.getClassName());

                // add default methods
                VTMethods.add(hashCodeMethod);
                VTMethods.add(equalsMethod);
                VTMethods.add(classMethod);
                VTMethods.add(stringMethod);

                System.out.println("asdhasd");
                System.out.println(currClass.getMethods().size());
                // add custom vtmethods
                for (CustomMethodClass m : currClass.getMethods()){

                    VTMethod vtmethod = new VTMethod(m, currClass);

                    VTMethods.add(vtmethod);

//                    if (DEBUGGING == 1) {
//
//                        System.out.println("*****************");
//                        for (VTInstantiatorMethod vtim : vtInstantiator.getVTInstantiatorMethods()) {
//
//                            System.out.println(vtim.getFullLine());
//
//
//                        }
//                        System.out.println("IM HERE " + currClass.getParentClass());
//                        System.out.println("*****************");
//                    }

                }

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

            public VTMethod(CustomMethodClass m, CustomClassObject s) {

                params = new ArrayList<String>();


                typeTranslate translateType = new typeTranslate();
                this.returnType = translateType.translateType(m.getReturnType());
                this.pointer = "(*" + m.getName() + ")";
                this.className = "(" + s.getClassName() +")";
               // System.out.println("");
              //  methodName += this.returnType + " " + this.pointer + this.className + ";";




                    methodName = "";

                    methodName += (this.returnType + " " + this.pointer + "" + this.className +";");
                    //methodName += (this.returnType + " " + pointer + "" + className);
                if (DEBUGGING == 1) {
                    System.out.println("________________");
                   // System.out.println("return type " + this.returnType);
                    System.out.println(methodName);
                    System.out.println("________________");
                }

                params.add(this.className);


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




