package edu.nyu.oop;

import java.util.*;
import xtc.tree.GNode;
import static edu.nyu.oop.util.cppASTNodeActions.*;

//The C++ AST created from going through our ClassSummary data structure taken from JavaAST
public class CPPAST {

    //Root of the AST
    private GNode root;
    //Track the most recent link in the tree
    private GNode mostRecentLink;
    //All the diff classes
    private List <CppClassObject> cppClassObjectslist;
    //The main class
    private CppClassObject mainClass;


    //Constructor
    public CPPAST(String nameOfNode){
        //Set the root of the tree to a new GNode
        this.root = createNewCppASTNode(nameOfNode);

        this.cppClassObjectslist = new ArrayList<CppClassObject>();


    }


    //Add to the list of classes
    public void addClass(CppClassObject classobj){
        if(classobj != null){
            //not null so add
            this.cppClassObjectslist.add(classobj);
        }
    }


    //Setters and getters
    public void setRoot(GNode root) {
        this.root = root;
    }
    public GNode getRoot() {
        return root;
    }

    public void setMostRecentLink(GNode mostRecentLink) {
        this.mostRecentLink = mostRecentLink;
    }
    public GNode getMostRecentLink() {
        return mostRecentLink;
    }

    public void setCppClassObjectslist(List<CppClassObject> cppClassObjectslist) {
        this.cppClassObjectslist = cppClassObjectslist;
    }
    public List<CppClassObject> getCppClassObjectslist() {
        return cppClassObjectslist;
    }

    public void setMainClass(CppClassObject mainClass) {
        this.mainClass = mainClass;
    }

    public CppClassObject getMainClass() {
        return mainClass;
    }
}
