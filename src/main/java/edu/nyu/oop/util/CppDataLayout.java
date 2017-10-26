package edu.nyu.oop.util;

import java.util.ArrayList;

import edu.nyu.oop.*;
import xtc.tree.GNode;

public class CppDataLayout {

    ArrayList<CppDataLayout.CppStruct> structs;
    ArrayList<CppDataLayout.CppVar> globalVariables;

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

    public static class CppStruct {

        ArrayList<CppVar> variables;
        ArrayList<CppMethod> methods;
        //ArrayList<VTables>
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


    public static class CppVTable {

        String type;

        ArrayList<VTMethod> VTMethods;


    }


    public static class VTable{
        String is_a;
        ArrayList<VTMethod> VTMethods;
        //ArrayList<VTConstructor> VTConstructors;


    }

    public static class VTConstructor{

        String returnType;
        String pointer;
        String className;
        String constructorName;
        String objectReference;

        // non overridden methods
        public VTConstructor(CustomMethodClass m, CustomClassObject s){


            this.constructorName = m.getName();
            this.returnType = m.getReturnType();
            this.className = s.getClassName();
            this.objectReference = "&__Object::" + m.getName();


        }





    }




    public static class VTMethod{

        String returnType;
        String pointer;
        String className;

        public VTMethod(CustomMethodClass m, CustomClassObject s){

            typeTranslate translateType = new typeTranslate();
            this.returnType = translateType.translateType(m.getReturnType());
            this.pointer = "*" + m.getName();
            this.className = s.getClassName();


        }

        public VTMethod(String rt, String pt, String cname){

            this.returnType = rt;
            this.pointer = rt;
            this.className = cname;
        }






    }

}




