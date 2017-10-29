package edu.nyu.oop;

import java.util.ArrayList;

public class CustomMethodClass {

    String visibility;
    String modifier;
    String name;
    ArrayList<CustomVariablesClass> parameters;
    String returnType;
    String methodOwner;

    public CustomMethodClass(){
        parameters = new ArrayList<CustomVariablesClass>();
    }


    public CustomMethodClass(String name, String visibility, String returnType, String methodOwner){
        this.name = name;
        this.visibility = visibility;
        this.returnType = returnType;
        this.methodOwner = methodOwner;


    }

    public String getMethodOwner() {
        return methodOwner;
    }

    public void setMethodOwner(String methodOwner) {
        this.methodOwner = methodOwner;
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
