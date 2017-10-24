package edu.nyu.oop;

import java.util.ArrayList;


//import edu.nyu.oop.CustomClassObject;


public class CustomClassObject {

        private ArrayList<CustomConstructorClass> constructors;

      	ArrayList<CustomVariablesClass> classVariables;

        ArrayList<String> modifiers;

        //Keep track of this class parent class
        String parentClass;

        //Keep track of the classes methods
        ArrayList<CustomMethodClass> methods;

        String className;


    public CustomClassObject() {
        this.constructors = new ArrayList<CustomConstructorClass>();
        this.modifiers = new ArrayList<String>();
        this.classVariables = new ArrayList<CustomVariablesClass>();
        //this.className = className;
        this.methods = new ArrayList<CustomMethodClass>();

    }


    public String getClassName() {
        return this.className;
    }

    public ArrayList<CustomMethodClass> getMethods() {
        return methods;
    }

    public ArrayList<CustomConstructorClass> getConstructors() {
        return constructors;
    }
    public void addConstructor(CustomConstructorClass constructor) {
        this.constructors.add(constructor);
    }

    public  ArrayList<CustomVariablesClass> getClassVariables(){
     return this.classVariables;
    }
    public void addClassVariable(CustomVariablesClass var) {
        this.classVariables.add(var);
    }

    public void setParentClass(String parentClass) {
        this.parentClass = parentClass;
    }
    public String getParentClass(){
        return this.parentClass;
    }
}
