package edu.nyu.oop.util;

import xtc.tree.GNode;

public abstract class cppASTNodeActions {
    private cppASTNodeActions() {}


    //Methods to handle CppAst node actions e.g. create new nodes, add child to parent, add data etc..

    public static GNode createNewCppASTNode(String nameOfNode){
      //Create a new CPP AST Node
      GNode newCppASTNode = GNode.create(nameOfNode);

        return newCppASTNode;
    }




}
