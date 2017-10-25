package edu.nyu.oop;

import edu.nyu.oop.util.*;
import xtc.tree.GNode;
import xtc.tree.Node;
import java.util.*;
import java.util.ArrayList;




//This class generates the C++ Header AST from the classSummary object
public class CppHeaderASTCreator {




    private CppHeaderASTCreator(){};


    public static CPPAST createNewCPPHeaderAstFrom(List <GNode> javaASTNodes){

        //Create new CPPAST
        CPPAST cppHeaderAST = new CPPAST("CppASTRoot");

        //Add the C++ starting dep e.g #Pragma, #Include etc.. to the CPP Datastructure
        //Create new node to of the c++ dep
        GNode dep = cppNodeActions.createNewASTNode("Dependencies");
        //Add the node to the root of tree
        cppNodeActions.addNodeAsChildToParent(cppHeaderAST.getRoot(),dep);
        //Add the data to the child node
        cppNodeActions.addDataToNodeWithArray(dep,new ArrayList<String>(Arrays.asList("#pragma once",
                "#include \"java_lang.h\"", "#include <string>")));

        //Add Using Namespace for javalang to CPP AST
        GNode namespace = cppNodeActions.createNewASTNode("UsingNamespace");
        cppNodeActions.addNodeAsChildToParent(cppHeaderAST.getRoot(),namespace);
        cppNodeActions.addDataToNode(namespace,"java::lang");

        //Create all the JavaClassSummary's from the JavaAST
        //Holds the classSummary from JavaASTs
        List <TraverseAST.ClassSummary> javaClassSummaries = new ArrayList<TraverseAST.ClassSummary>();
        //Traverse AST traverses the JAVAAST and converts it into objects saved in ClassSummary
        TraverseAST jASTvisitor = new TraverseAST();
        for (GNode javaAST: javaASTNodes){
            javaClassSummaries.add(jASTvisitor.getClassSummary(javaAST));
        }

        //With the Class Summary create the namespaces
        for(TraverseAST.ClassSummary javaData: javaClassSummaries){
            //Add the nameSpaces to our C++ AST Tree
            addNameSpacesToCppAST(javaData,cppHeaderAST);
        }

        //Check to print out the recent parent mutated of the ASTTree
        System.out.println(cppHeaderAST.getRecentParentNodeMutated());

        //TODO create the classObjects and heirechy strucutre

        //Create the cppClassObjects
        createCppClassObject(javaClassSummaries, cppHeaderAST);






        return cppHeaderAST;
    }


    //Helper method that creates the CPP classes Objects
    public static void createCppClassObject(List<TraverseAST.ClassSummary> jClassSummaryList, CPPAST cppAst){

        //Empty list of cppClassObject
        List<CppClassObject> listOfCppClassObjects = new ArrayList<CppClassObject>();

        //Create a new cpp classHigh for all instances of cppClassObject
        CppClassObject.classHierarchy classHigh = new CppClassObject.classHierarchy();

        //Get the point in the AST where we want to add that data from the CPPASTObjects
        //This point will remain constant so we always know where to add the class structs for the cp //e.g at the end of name space
        GNode pointToAddClassesToNamespaceGnode = cppAst.getRecentParentNodeMutated();
        //System.out.println(pointToAddClassesToNamespaceGnode);

        //We also need to take into account the "main" class (main method) as it does not show up in the Cpp header
        boolean mainFound = false;
        CppClassObject mainClass = null;

        //Go through the class summary and create the respective CppClassObject
        int index = 0;
        for (TraverseAST.ClassSummary javaClassSum: jClassSummaryList){
            //Go through the javaClassSum and check all methods to see if the "main" method exists - if so set the mainFound flag to true
            //check if the  classses array in the java object is empty
            if(javaClassSum.classes.size() > 0){
                for (CustomClassObject customJavaClass: javaClassSum.classes) {
                    //Createa a new cppClassObject for its JavaClassObject counter part
                    CppClassObject newCppClassObject = new CppClassObject("__"+customJavaClass.className);
                    newCppClassObject.setCppast(cppAst);
                    newCppClassObject.setLinkToNameSpaceGNodeInCppAST(pointToAddClassesToNamespaceGnode);

                    //Now check if the current class created is a main
                    for (CustomMethodClass javaMethod: customJavaClass.methods){
                        if(javaMethod.name.equalsIgnoreCase("main")){
                            //Main method found
                            mainFound = true;
                            mainClass = newCppClassObject;
                        }
                    }
                    //If the class is not a main class,we check its High structure
                    if(mainFound != true){
                        //TODO
                    }
                    //Add the main class to JavaAST
                    cppAst.setMainClass(mainClass);
                }
            }//End of if -> size check
        }//End of outer for loop









        //Set the classHigh for all CPPObjects at the end
        CppClassObject.setClassHierarchy(classHigh);
    }



    //Helper method to addJavaPackages as Namespaces to the the CPPAST
    public static void addNameSpacesToCppAST(TraverseAST.ClassSummary javaData, CPPAST cppAst){
        //Get the root of our cppAST
        GNode rootOfCppAST = cppAst.getRoot();
        //Get the javaPackages, which are C++ Namespaces
        ArrayList<String> packages = javaData.packages;
        //For the javaPackages create its NameSpace
        //Keep track of which node to add the name space to
        GNode pointer = rootOfCppAST;
        //Create a new node for the name space
        GNode newNamespaceNode = cppNodeActions.createNewASTNode("Namespace");
        //Add the node to the root
        cppNodeActions.addNodeAsChildToParent(pointer,newNamespaceNode);
        //Add the data node
        cppNodeActions.addDataToNodeWithArray(newNamespaceNode,packages);
        //Update the recent node pointer
        cppAst.setRecentParentNodeMutated(newNamespaceNode);

    }






//    public static void addStructNodes(TraverseAST.ClassSummary javaData, CPPAST cppAst){
//        //Get the root of our cppAST
//
//        CppDataLayout dataLayout = new CppDataLayout();
//       // CppDataLayout.CppStruct = new CppDataLayout.()
//
//        GNode rootOfCppAST = cppAst.getRoot();
//
//        ArrayList<CppDataLayout.CppStruct> structs = new ArrayList<CppDataLayout.CppStruct>();
//
//        for (CustomClassObject c: javaData.classes){
//
//            CppDataLayout.CppStruct aStruct = new  CppDataLayout.CppStruct(c);
//
//            structs.add(aStruct);
//
//        }
//
//        GNode pointer = rootOfCppAST;
//        GNode newStructNode = cppNodeActions.createNewASTNode("Struct");
//        cppNodeActions.addNodeAsChildToParent(pointer,newStructNode);
//        cppNodeActions.addStructToNodeWithArray(newStructNode, structs);
//        cppAst.setRecentParentNodeMutated(newStructNode);


    }











