package edu.nyu.oop;
import java.io.File;
import java.util.*;

import scala.collection.immutable.Stream;
import xtc.tree.Node;


// this file outlines the intermediate sdata strucutre

// an array list of classes

public class IntermediateDataStructure {

    ArrayList<FileClass> files;

    public IntermediateDataStructure(FileClass fileName) {

        files.add(fileName);


    }
}


//
//class FileClass {
//
//        ArrayList<LocalVariable> globalVariables;
//
//        ArrayList<ClassObject> classes;
//
//        ArrayList<FileClass> packageNames;
//
//
//
//
//    }
//
//
//
//
//    }
//
//
//    class Method {
//
//        String visibility;
//        String modifier;
//        ArrayList<Object> parameters;
//        String returnType;
//
//
//    }
//
//    class Constructor {
//
//        String visibility;
//        ArrayList<Object> parameters;
//
//
//    }
//
//    class LocalVariable {
//
//
//        String visibility;
//        String name;
//        String type;
//
//    }
