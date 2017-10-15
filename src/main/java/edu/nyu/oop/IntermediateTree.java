package edu.nyu.oop;
import java.util.*;

import scala.collection.immutable.Stream;
import xtc.tree.Node;

// this file outlines the intermediate sdata strucutre

// an array list of classes

class File{

    ArrayList<LocalVariable> globalVariables;

    ArrayList<ClassObject> classes;

}


class ClassObject{

    // an arraylist of methods
    ArrayList<Method> methods;

    ArrayList<Stream.Cons> constructors;


    ArrayList<LocalVariable> localVariables;

    ArrayList<String> modifiers;



 }


 class Method{

        String visibility;
        String modifier;
        ArrayList<Object> parameters;
        String returnType;



 }

class Constructor{

    String visibility;
    ArrayList<Object> parameters;




}

class LocalVariable{


    String visibility;
    String name;
    String type;

}