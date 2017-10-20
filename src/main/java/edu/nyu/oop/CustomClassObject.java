package edu.nyu.oop;

import java.util.ArrayList;

public class CustomClassObject {


        // an arraylist of methods
//        ArrayList<Method> methods;
//
        private ArrayList<CustomConstructorClass> constructors;
//
      	ArrayList<CustomVariablesClass> classVariables;

        ArrayList<String> modifiers;

        CustomClassObject parentClass;

        String className;
//
//        ArrayList<IntermediateDataStructure.FileClass> implementors;


    public CustomClassObject()
        this.constructors = new ArrayList<CustomConstructorClass>();
        this.modifiers = new ArrayList<String>();

        //this.className = className;


    }

    public void addConstructor(CustomConstructorClass constructor) {
        this.constructors.add(constructor);
    }
}
