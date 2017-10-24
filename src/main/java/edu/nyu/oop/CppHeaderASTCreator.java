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
        GNode pointer = cppHeaderAST.getRoot(); // The last node that we added new GNodes too
        for(TraverseAST.ClassSummary javaData: javaClassSummaries){
            //Add the nameSpaces to our C++ AST Tree

            addNameSpacesToCppAST(javaData,cppHeaderAST);
            addStructNodes(javaData, cppHeaderAST);
        }

        //Check to print out the recent parent mutated of the ASTTree
        System.out.println(cppHeaderAST.getRecentParentNodeMutated());

        //TODO create the classObjects and heirechy strucutre






        return cppHeaderAST;
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

    public static void addStructNodes(TraverseAST.ClassSummary javaData, CPPAST cppAst){
        //Get the root of our cppAST

        CppDataLayout dataLayout = new CppDataLayout();
       // CppDataLayout.CppStruct = new CppDataLayout.()

        GNode rootOfCppAST = cppAst.getRoot();

        ArrayList<CppDataLayout.CppStruct> structs = new ArrayList<CppDataLayout.CppStruct>();

        for (CustomClassObject c: javaData.classes){

            CppDataLayout.CppStruct aStruct = new  CppDataLayout.CppStruct(c);

            structs.add(aStruct);

        }

        GNode pointer = rootOfCppAST;
        GNode newStructNode = cppNodeActions.createNewASTNode("Struct");
        cppNodeActions.addNodeAsChildToParent(pointer,newStructNode);
        cppNodeActions.addStructToNodeWithArray(newStructNode, structs);
        cppAst.setRecentParentNodeMutated(newStructNode);







        //Get the javaPackages, which are C++ Namespaces
//        ArrayList<String> packages = javaData.packages;
//        //For the javaPackages create its NameSpace
//        //Keep track of which node to add the name space to
//        GNode pointer = rootOfCppAST;
//        //Create a new node for the name space
//        GNode newNamespaceNode = cppNodeActions.createNewASTNode("Namespace");
//        //Add the node to the root
//        cppNodeActions.addNodeAsChildToParent(pointer,newNamespaceNode);
//        //Add the data node
//        cppNodeActions.addDataToNodeWithArray(newNamespaceNode,packages);
//        //Update the recent node pointer
//        cppAst.setRecentParentNodeMutated(newNamespaceNode);
    }









}
