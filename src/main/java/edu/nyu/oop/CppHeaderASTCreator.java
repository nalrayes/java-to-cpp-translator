package edu.nyu.oop;

import edu.nyu.oop.util.*;
import xtc.tree.GNode;
import xtc.tree.Node;
import java.util.*;



//This class generates the C++ Header AST from the classSummary object
public class CppHeaderASTCreator {

    private CppHeaderASTCreator(){};

    public static CPPAST createNewCPPHeaderAstFrom(List <GNode> javaASTNodes){
        //Create new CPPAST
        CPPAST cppHeaderAST = new CPPAST("CppASTRoot");

        //Create all the class summaries using JavaAST
        //for (GNode javaASTNode: )

        //Add the C++ starting dep e.g #Pragma, #Include etc.. to the CPP Datastructure
        //Create new node to of the c++ dep
        GNode dep = cppNodeActions.createNewASTNode("Dependencies");
        //Add the node to the root of tree
        cppNodeActions.addNodeAsChildToParent(cppHeaderAST.getRoot(),dep);
        //Add the data to the child node
        cppNodeActions.addDataToNodeWithArray(dep,"Dependencies",new ArrayList<String>(Arrays.asList("#pragma once",
                "#include \"java_lang.h\"", "#include <string>")));

        //Name space for javalang
        GNode namespace = cppNodeActions.createNewASTNode("UsingNamespace");
        cppNodeActions.addNodeAsChildToParent(cppHeaderAST.getRoot(),namespace);
        cppNodeActions.addDataToNode(namespace, "UsingNamespace","java::lang");

        //With the summary's create the namespaces





        //cppHeaderAST.addCppDepWithList(new ArrayList<String>(Arrays.asList("#pragma once",
          //      "#include \"java_lang.h\"", "#include <string>")));
        //System.out.println(cppHeaderAST.getCppDepList());




        //Get the file summaries


        return cppHeaderAST;
    }





}
