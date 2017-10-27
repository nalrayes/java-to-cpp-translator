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






    public CppDataLayout(){
        structsMap = new HashMap<>();


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

    public static class CppVTable{

        String name;




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

            for (CustomConstructorClass javaConstructor : c.getConstructors()) {


                CppConstructor cppConstructor = new CppConstructor(javaConstructor);
                this.constructors.add(cppConstructor);

            }

            for (CustomVariablesClass javaVar : c.getClassVariables()) {

                CppVar cVar = new CppVar(javaVar);
                this.variables.add(cVar);


            }

            // add current struct to array list of structs
           // structs.add(this);


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
//
//            public String getModifier() {
//                return modifier;
//            }
//
//            public String getName() {
//                return name;
//            }
//
//            public String getType() {
//                return type;
//            }





    public static class VTInstantiator {

        String returnType;
        String isA;
        String pointer;

        String declarationName;
        String objectReference;
        String returnTypeClassName;
        String randoCurls;

        // non overridden methods
        public VTInstantiator(CustomClassObject javaClass) {

            this.isA = " : __is_a(__" + javaClass.getClassName() + "::__class()),";
            this.declarationName = "__" + javaClass.getClassName() + "_VT()";
            this.randoCurls = "{\n}";


        // check for overidden methods



        }

            // for default instantiators
            public VTInstantiator (String rTCN) {
                this.returnTypeClassName = rTCN;
        }

            // for custom instantiators
        public VTInstantiator(CustomMethodClass method, boolean isLastMethod){
            this.objectReference = "&__" + method.getClass() + "::" + method.getName();
            this.returnTypeClassName = "((" + method.getReturnType() + " (*)(" + method.getClass() + "))" + "__" + method.getClass() + "::" + method.getReturnType() + ")";

            if (!isLastMethod) {
                this.returnTypeClassName += ",";
            }

        }




        }



        private void checkForOverriddenMethods(CustomClassObject javaClass, JavaFileObject javaFile){



        }







        public static class VTable {
            String is_a;
            ArrayList<VTMethod> VTMethods;

            ArrayList<VTInstantiator> VTInstantiators;



            // gets factory methods



            public VTable(CustomClassObject currClass) {

                VTInstantiators = new ArrayList<VTInstantiator>();
                VTMethods = new ArrayList<VTMethod>();
                VTMethod hashCodeMethod = new VTMethod("int32_t", "hashCode", currClass.getClassName());
                VTMethod equalsMethod = new VTMethod("bool", "equals", currClass.getClassName());
                VTMethod classMethod = new VTMethod("Class", "getClass", currClass.getClassName());
                VTMethod stringMethod = new VTMethod("String","toString", currClass.getClassName());






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

                        
                        if (currMethod.getName().equals(parentMethod.getName())){
                            VTInstantiator currVTInst = new VTInstantiator(currMethod, isLastMethod);



                        }
                        else {

                        }



                    }

                }








//                for (CustomMethodClass m : javaData.getMethods()) {
//
//                    VTMethod vtMeth = new VTMethod(m, javaData);
//                    VTMethods.add(vtMeth);
//
//                }
//                for (CustomMethodClass m : cur.getMethods()) {
//                    VTMethod vtMeth = new VTMethod(m, javaData);
//                    VTMethods.add(vtMeth);
//                }



                //pre-made methods
                String hashCodeRTCN = "((int32_t (*)(" + currClass.getClassName() + ")) &__Object::hashCode),";
                String equalsRTCN = "((bool (*)(" + currClass.getClass() + ")) &__Object::equals),";
                String classRTCN = "((Class (*)(" + currClass.getClass() + ")) &__Object::getClass),";
                String stringRTCN = "((String (*)(" + currClass.getClass() + ")) &__Object::toString),";

                VTInstantiator hashCodeInst = new VTInstantiator(hashCodeRTCN);
                VTInstantiator equalsInst = new VTInstantiator(equalsRTCN);
                VTInstantiator classInst = new VTInstantiator(classRTCN);
                VTInstantiator stringInst = new VTInstantiator(stringRTCN);

                VTInstantiators.add(hashCodeInst);
                VTInstantiators.add(equalsInst);
                VTInstantiators.add(classInst);
                VTInstantiators.add(stringInst);

            }

        }


        public static class VTMethod {

            String returnType;
            String pointer;
            String className;
            String returnTypeAndClassName;
            ArrayList<String> params;

            public VTMethod(CustomMethodClass m, CustomClassObject s) {
                params = new ArrayList<String>();

                typeTranslate translateType = new typeTranslate();
                this.returnType = translateType.translateType(m.getReturnType());
                this.pointer = "(*" + m.getName() + ")";
                this.className = s.getClassName();
                params.add(this.className);


            }

            public VTMethod(String rt, String pt, String className) {
                params = new ArrayList<String>();
                this.pointer = rt;
                this.className = className;
                params.add(this.className);
                if (className.equals("hashCode")) {
                    params.add("Object");
                }

            }


        }

}




