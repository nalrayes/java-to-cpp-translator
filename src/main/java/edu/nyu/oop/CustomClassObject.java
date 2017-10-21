package edu.nyu.oop;

import java.util.ArrayList;


//import edu.nyu.oop.CustomClassObject;
import edu.nyu.oop.CustomVariablesClass;
import edu.nyu.oop.CustomConstructorClass;


public class CustomClassObject {

        private ArrayList<CustomConstructorClass> constructors;

      	ArrayList<CustomVariablesClass> classVariables;

        ArrayList<String> modifiers;

        //Keep track of this class parent class
        CustomClassObject parentClass;
        //keep track of this class child class
        ArrayList<CustomClassObject> childClasses;

        //Keep track of the classes methods
        ArrayList<CustomMethodClass> methods;

        String className;

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
