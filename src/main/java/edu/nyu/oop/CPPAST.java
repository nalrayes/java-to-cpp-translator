package edu.nyu.oop;

import java.util.*;
import xtc.tree.GNode;

import edu.nyu.oop.util.cppNodeActions;

//The C++ AST created from going through our ClassSummary data structure taken from JavaAST
public class CPPAST {

    //Private the root node of the tree
    private GNode root;

    //Keep track of the namespace
    private List<simpleCPPDataNode> nameSpaceNames;

    //All the diff classes
    private List <CppClassObject> cppClassObjectslist;

    //Simple data node to hold all c++ starting dep
    private List <simpleCPPDataNode> cppDepList;

    //The main class
    private CppClassObject mainClass;


    //Constructor
    public CPPAST (String name){
        this.nameSpaceNames = new ArrayList<simpleCPPDataNode>();
        this.cppClassObjectslist = new ArrayList<CppClassObject>();
        this.cppDepList = new ArrayList<simpleCPPDataNode>();
        //create new gnode as root
        this.root = cppNodeActions.createNewASTNode(name);
    }

    //Add to the list of classes
    public void addClass(CppClassObject classobj){
        if(classobj != null){
            //not null so add
            this.cppClassObjectslist.add(classobj);
        }
    }

    public void addCppDepWithList(List<String> cppDepList){
        if (cppDepList != null && cppDepList.size() >0) {
         //Values exit we add it to the dep list
         for (String dep: cppDepList){
           //  this.cppDepList.add(new simpleCPPDataNode("dependencies",dep));
         }
        }
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

    public void setNameSpaceNames(List<simpleCPPDataNode> nameSpaceNames) {
        this.nameSpaceNames = nameSpaceNames;
    }

    public List<simpleCPPDataNode> getNameSpaceNames() {
        return nameSpaceNames;
    }

    public void setCppDepList(List<simpleCPPDataNode> cppDepList) {
        this.cppDepList = cppDepList;
    }

    public List<simpleCPPDataNode> getCppDepList() {
        return cppDepList;
    }

    public void setRoot(GNode root) {
        this.root = root;
    }

    public GNode getRoot() {
        return root;
    }
}
