package edu.nyu.oop.util;

import java.util.ArrayList;

import edu.nyu.oop.*;
import xtc.tree.GNode;

public class CppDataLayout {

    ArrayList<CppDataLayout.CppStruct> structs;
    ArrayList<CppDataLayout.CppVar> globalVariables;





//    public CppDataLayout(TraverseAST javaData){
//
//
//
//
//
//
//
//    }

    // Translate java types to C++ types
    // TODO: add differing types



    public static class typeTranslate {

        public String translateType (String javaType){

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
        ArrayList<CppConstructor> constructors;

        public CppStruct(CustomClassObject c) {

            this.variables = new ArrayList<CppVar>();
            this.methods = new ArrayList<CppMethod>();
            this.name = "__" + c.getClassName();
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


            //constructors.add();


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
    }

        public static class CppMethod {


            String name;
            String modifier;
            String returnType;
            ArrayList<CppParameter> parameters;

            public CppMethod(CustomMethodClass m) {
                parameters = new ArrayList<CppParameter>();

                this.name = "__" + m.getName();
                this.modifier = m.getModifier();

                typeTranslate translateType = new typeTranslate();
                this.returnType =  translateType.translateType(m.getReturnType());

                // translates and add java method params to cpp method params
                for (CustomVariablesClass javaParam : m.getParameters()){


                    CppParameter cParam = new CppParameter(javaParam);
                    this.parameters.add(cParam);

                }


            }


        }


        public static class CppParameter {
            String name;
            String type;


            public CppParameter(CustomVariablesClass v){

                typeTranslate translateType = new typeTranslate();
                this.name = v.getName();
                this.type = translateType.translateType(v.getType());


            }



        }


        public static class CppVar {
            String name;
            String type;
            String modifier;



            public CppVar(CustomVariablesClass v){

                typeTranslate translateType = new typeTranslate();
                this.name = v.getName();
                this.type = translateType.translateType(v.getType());
                this.modifier = v.getModifier();


            }

            public String getModifier() {
                return modifier;
            }

            public String getName() {
                return name;
            }

            public String getType() {
                return type;
            }

        }


        public static class CppVTable{




        }

    }



