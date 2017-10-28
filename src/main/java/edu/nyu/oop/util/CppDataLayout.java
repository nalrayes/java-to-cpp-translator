package edu.nyu.oop.util;

import java.util.ArrayList;

import edu.nyu.oop.*;
import xtc.tree.GNode;
import java.util.Map;

import java.util.HashMap;

public class CppDataLayout {
    public static ArrayList<CppStruct> structs;
    public static ArrayList<VTable> VTables;

    public static HashMap<String, ArrayList<CustomMethodClass>> structsMap;



    public static final int DEBUGGING = 1;

    public CppDataLayout(){
        //Use this default constructor to create the deafult __Object data layout

        structsMap = new HashMap<>();
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




        structsMap = new HashMap<>();


    }

    @Override
    public String toString() {
        return super.toString();
    }

    // Helper method to translate java types to C++ types
    // TODO: add differing types
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


        ArrayList<CppConstructor> constructors;

        public CppStruct(CustomClassObject c) {
            this.variables = new ArrayList<CppVar>();
            this.methods = new ArrayList<CppMethod>();

            this.name = "__" + c.getClassName();
            this.classDeclarator = "static Class __class()";
            this.VTableDeclarator = "__" + name + "_" +"VT" + " __vtable";


            this.constructors = new ArrayList<CppConstructor>();

            // instantiates all data
            for (CustomMethodClass javaMethod : c.getMethods()) {

                CppMethod cMethod = new CppMethod(javaMethod);
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
            structsMap.put(c.getClassName(), c.getMethods());




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
        boolean hasBeenOverriden;


    }





    public static class VTInstantiator {

        String randoCurls;
        String isA;

        String declarationName;

        ArrayList<VTInstantiatorMethod> inheritedMethods;


        ArrayList<VTInstantiatorMethod> VTInstantiatorMethods;

        // non overridden methods
        public VTInstantiator(CustomClassObject currClass) {
            VTInstantiatorMethods = new ArrayList<VTInstantiatorMethod>();
            inheritedMethods = new ArrayList<VTInstantiatorMethod>();

            this.isA = " : __is_a(__" + currClass.getClassName() + "::__class()),";
            this.declarationName = "__" + currClass.getClassName() + "_VT()";
            this.randoCurls = "{\n}";




            // set defaults

            //pre-made methods
            String hashCodeRTCN = "((int32_t (*)(" + currClass.getClassName() + ")) &__Object::hashCode),";
            String equalsRTCN = "((bool (*)(" + currClass.getClassName() + ", Object" +  ")) &__Object::equals),";
            String classRTCN = "((Class (*)(" + currClass.getClass() + ")) &__Object::getClass),";
            String stringRTCN = "((String (*)(" + currClass.getClass() + ")) &__Object::toString),";

            VTInstantiatorMethod hashCodeInst = new VTInstantiatorMethod(hashCodeRTCN);
            //VTInstantiatorMethod equalsInst = new VTInstantiatorMethod(equalsRTCN);
            VTInstantiatorMethod classInst = new VTInstantiatorMethod(classRTCN);
            VTInstantiatorMethod stringInst = new VTInstantiatorMethod(stringRTCN);

            VTInstantiatorMethods.add(hashCodeInst);
          //  VTInstantiatorMethods.add(equalsInst);
            VTInstantiatorMethods.add(classInst);
            VTInstantiatorMethods.add(stringInst);




            // gets custom methods


            // currstruct get parent
            // find parent in the map and get its methods
            // then compare those methods to the current class's methods

            ArrayList<CustomMethodClass> inheritedMethods = new ArrayList<CustomMethodClass>();
            //CustomClassObject presentStruct = new CustomClassObject();

            String currClassParent = currClass.getParentClass();

            ArrayList <CustomMethodClass> parentMethods = structsMap.get(currClass.getClassName());



            int index = 0;



            for (CustomMethodClass currMethod : currClass.getMethods()){
                boolean isLastMethod = false;
                if (index == currClass.getMethods().size()) {
                    isLastMethod = true;
                }
                for (CustomMethodClass parentMethod : parentMethods){
                    boolean isOverridden = false;
                    // if the method is overriden
                    if (currMethod.getName().equals(parentMethod.getName())){
                        isOverridden = true;


                    }
                    VTInstantiatorMethod currVTInst = new VTInstantiatorMethod(currMethod, currClass.getClassName(), isLastMethod, isOverridden);

                    // else the method is not overriden

                    if (DEBUGGING == 1) {

                        String instantName = "";

                        //instantName += (this.returnType + " " + pointer + "" + className);
                        System.out.println(this.declarationName);
                        System.out.println(this.isA);
                        System.out.println(currVTInst.getReturnTypeClassName());
                        System.out.println(this.randoCurls);
                        System.out.println("________________");
                        // System.out.println("return type " + this.returnType);

                        System.out.println("________________");
                    }



                }

            }












        }






        }



        private void checkForOverriddenMethods(CustomClassObject javaClass, JavaFileObject javaFile){



        }





        public static class VTInstantiatorMethod{

            String objectReference;
            String returnTypeClassName;



            // for overriden methods
            public VTInstantiatorMethod(CustomMethodClass method, String className, boolean isLastMethod, boolean isOverridden){

                typeTranslate translateType = new typeTranslate();
              String returnT = translateType.translateType(method.getReturnType());

                if (isOverridden) {
                    this.objectReference = "&__" + className + "::" + method.getName();
                    this.returnTypeClassName = "((" + returnT + " (*)(" + className + "))" + "__" + className + "::" + method.getName() + ")";
                }
                else {
                    this.objectReference = "&__Object" + "::" + method.getName();
                    this.returnTypeClassName = "((" + returnT + " (*)(" + className + "))" + "__" + className + "::" + method.getName() + ")";
                }
                if (!isLastMethod) {
                    this.returnTypeClassName += ",";
                }


            }


            // for default methods
            public VTInstantiatorMethod (String rTCN) {
                this.returnTypeClassName = rTCN;
            }

            // TODO: add constructor for custom non overidden methods


            public String getObjectReference() {
                return objectReference;
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






            public VTable(CustomClassObject currClass) {

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

                // add custom vtmethods
                for (CustomMethodClass m : currClass.getMethods()){

                    VTMethod vtmethod = new VTMethod(m, currClass);
                    VTInstantiator vtInstantiator = new VTInstantiator(currClass);

                    VTMethods.add(vtmethod);
                    VTInstantiators.add(vtInstantiator);


                }



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




