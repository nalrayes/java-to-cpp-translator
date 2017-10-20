package edu.nyu.oop;

import java.util.ArrayList;


//import edu.nyu.oop.CustomClassObject;
import edu.nyu.oop.CustomVariablesClass;
import edu.nyu.oop.CustomConstructorClass;


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


    public CustomClassObject() {
        this.constructors = new ArrayList<CustomConstructorClass>();
        this.modifiers = new ArrayList<String>();
        this.classVariables = new ArrayList<CustomVariablesClass>();
        //this.className = className;


    }

    public ArrayList<CustomConstructorClass> getConstructors() {
        return constructors;
    }

    public void addConstructor(CustomConstructorClass constructor) {
        this.constructors.add(constructor);
    }
}
