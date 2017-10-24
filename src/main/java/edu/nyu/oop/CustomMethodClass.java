package edu.nyu.oop;

import java.util.ArrayList;

public class CustomMethodClass {

    String visibility;
    String modifier;
    String name;
    ArrayList<CustomVariablesClass> parameters;
    String returnType;

    public CustomMethodClass(){
        parameters = new ArrayList<CustomVariablesClass>();
    }

    public ArrayList<CustomVariablesClass> getParameters() {
        return parameters;
    }

    public String getName() {
        return name;
    }

    public String getModifier() {
        return modifier;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getReturnType() {
        return returnType;
    }


}
