package edu.nyu.oop;

import java.util.*;

import edu.nyu.oop.util.CppDataLayout;
import xtc.tree.GNode;
import java.util.HashMap;

public class CppClassObject {

    //Refer to the parent of this class
    private CppClassObject parentClass;

    //Name of the class
    private String cppClassName;

    //ArrayListWhichHoldsAll the CppClassObjects that exists e.g Class A, Class B etc..
    private static ArrayList <CppClassObject> arrayListOfCppClassObjectsInTheCppAST;

    //Pointer to the cppClassObjectFor "Main"
    private static CppClassObject main;

    //Simple class to keep track of the inheritance
    private static classHierarchy classHierarchyObj;

    //Link to the cppDataLayout -> its constuctor takes a JavaClassSummary object and translate the JavaCode into the C++
    //representation e.g adding __ or (*) to method names, fields etc. cpp
    private CppDataLayout cppDataLayout;

    //Link to the AST for easy excess
    private CPPAST cppast;

    //Set where in the AST the class will be added to i.e as a child of namespace
    private GNode linkToNameSpaceGNodeInCppAST;

    //Constructor for the CppClassObject
    public CppClassObject(String cppClassName, CustomClassObject javaClass) {
        this.cppClassName = cppClassName;
        this.cppDataLayout = new CppDataLayout();
        this.arrayListOfCppClassObjectsInTheCppAST = new ArrayList<CppClassObject>();
    }



    //Setters and getters
    public void setCppast(CPPAST cppast) {
        this.cppast = cppast;
    }

    public CPPAST getCppast() {
        return cppast;
    }

    public void setLinkToNameSpaceGNodeInCppAST(GNode linkToNameSpaceGNodeInCppAST) {
        this.linkToNameSpaceGNodeInCppAST = linkToNameSpaceGNodeInCppAST;
    }

    public GNode getLinkToNameSpaceGNodeInCppAST() {
        return linkToNameSpaceGNodeInCppAST;
    }

    //Custom object to keep track of inheritance
    public static class classHierarchy {
        private HashMap<String, CppClassObject> nameOfClassForCppClassObjectHashMap;
        private HashMap<String, String> childForParentHashMap;
        private HashMap<String, ArrayList<String>> parentForChildHashMap;

        //Constructor for the class Hirarchy object
        public classHierarchy(){
            this.nameOfClassForCppClassObjectHashMap = new HashMap<String, CppClassObject>();
            this.childForParentHashMap = new HashMap<String, String>();
            this.parentForChildHashMap = new HashMap<String, ArrayList<String>>();
        }

        //Helper methods
        //Add the class name for classObject in the HashMap
        public void addClassNameForCppClassObject (String className, CppClassObject classObject){
            this.nameOfClassForCppClassObjectHashMap.put(className,classObject);
        }
        //Get the CppClassObjectFor a class name given
        public CppClassObject getCppClassObjectFromName (String className){
            return this.nameOfClassForCppClassObjectHashMap.get(className);
        }
        //Add childName for its respective parent to HashMap
        public void addChildNameForParent (String childClassName, String parentClassName){
            this.childForParentHashMap.put(childClassName, parentClassName);
        }
        //Get parentClassName when given a childClass Name
        public String getParentNameForChild (String childClassName){
            return this.childForParentHashMap.get(childClassName);
        }

        //Add the children for a given parent
        public void addChildClassToParent(String childClass, String parentClass){
            //Get the array list inside the hashmap
            ArrayList<String> listOfChildren = this.parentForChildHashMap.get(parentClass);
            //Add the the list of children
            //check if the childrens list is null
            if(listOfChildren == null){
                //create a new list
                listOfChildren = new ArrayList<String>();
                listOfChildren.add(childClass);
                this.parentForChildHashMap.put(parentClass, listOfChildren);
            }
            else{
                //list exist we just add
                listOfChildren.add(childClass);
            }
        }
    }

    //Setter and getter for classHierarchy
    public static void setClassHierarchy(CppClassObject.classHierarchy classHierarchy) {
        CppClassObject.classHierarchyObj = classHierarchy;
    }
    public static CppClassObject.classHierarchy getClassHierarchy() {
        return classHierarchyObj;
    }

}