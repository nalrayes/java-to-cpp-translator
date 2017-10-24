package edu.nyu.oop.util;

import java.util.ArrayList;

import edu.nyu.oop.CustomClassObject;
import edu.nyu.oop.CustomConstructorClass;
import edu.nyu.oop.CustomMethodClass;
import edu.nyu.oop.CustomVariablesClass;
import xtc.tree.GNode;

public class CppDataLayout {

    public CppDataLayout(){}

    public static class CppStruct {

        ArrayList<CppVar> variables;
        ArrayList<CppMethod> methods;
       //ArrayList<VTables>
        String name;
        ArrayList<CppConstructor> constructors;






        public CppStruct(CustomClassObject c) {

            this.variables = new ArrayList<CppVar>();
            this.methods = new ArrayList<CppMethod>();
            this.name = c.getClassName();


        }

        public static class CppConstructor{
            ArrayList<CustomVariablesClass> parameters;
            String name;
            String visibility;


            public CppConstructor(CustomConstructorClass c){


                this.name = "__"+ c.getName();
                this.parameters = c.getParameters();
                this.visibility = c.getVisibility();





            }






        }


        public static class CppMethod {


            String name;
            String modifier;
            String returnType;
            ArrayList<CustomVariablesClass> parameters;

            public CppMethod(CustomMethodClass m) {
                
                this.name = "__" + m.getName();
                this.modifier = m.getModifier();

                this.returnType = m.getReturnType();
                this.parameters = m.getParameters();



            }


        }


        public static class Parameter {
            String name;
            String type;


            public Parameter(CustomVariablesClass v){
                this.name = v.getName();
                this.type = v.getType();


            }



        }


        public static class CppVar {
            String name;
            String type;
            String modifier;



            public CppVar(CustomVariablesClass v){

                this.name = v.getName();
                this.type = v.getType();
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












//    String name;
//    String type;
//    ArrayList<String> modifiers;
//    GNode methods;


}
