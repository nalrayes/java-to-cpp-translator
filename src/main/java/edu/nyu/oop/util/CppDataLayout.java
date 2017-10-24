package edu.nyu.oop.util;

import java.util.ArrayList;

import edu.nyu.oop.CustomClassObject;
import edu.nyu.oop.CustomMethodClass;
import xtc.tree.GNode;

public class CppDataLayout {

    public CppDataLayout(){}

    public static class CppStruct {

        ArrayList<CppVar> variables;
        ArrayList<CppMethod> methods;
       // ArrayList<VTables>
        String name;


        public CppStruct(CustomClassObject c) {

            this.variables = new ArrayList<CppVar>();
            this.methods = new ArrayList<CppMethod>();
            this.name = c.getClassName();


        }


        public static class CppMethod {


            String name;
            ArrayList<String> modifiers;
            String returnType;
            ArrayList<Parameter> parameters;

            public CppMethod(CustomMethodClass m) {





            }


        }


        public static class Parameter {
            String name;
            String type;

        }


        public static class CppVar {
            String name;
            String type;
            ArrayList<String> modifers;

        }


        public static class CppVTable{




        }

    }












//    String name;
//    String type;
//    ArrayList<String> modifiers;
//    GNode methods;


}
