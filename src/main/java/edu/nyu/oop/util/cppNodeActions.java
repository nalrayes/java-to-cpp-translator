package edu.nyu.oop.util;

import xtc.tree.GNode;
import xtc.tree.Node;

import java.util.ArrayList;


public abstract class cppNodeActions {

    //Create a new node
    public static GNode createNewASTNode(String type){
        GNode newNode = GNode.create(type);

        return newNode;
    }

    public static GNode addNodeAsChildToParent(GNode parent, GNode child){
        parent.add(child);
        return parent;
    }

    public static GNode addDataToNode(GNode node ,Object value){
        //Add as a child
        node.add(value);
        //Add the data node to node
        return node;
    }

    //Add data to node for multiple varaibles

    public static GNode addDataToNodeWithArray(GNode node ,ArrayList<String> listOfData){
        if(listOfData == null && listOfData.size() == 0){
            return null;
        }
        for (String value : listOfData){
            //Add to the parent
            node.add(value);
        }
        return node;
    }

    public static GNode addStructToNodeWithArray(GNode node ,ArrayList<CppDataLayout.CppStruct> listOfData){
        if(listOfData == null && listOfData.size() == 0){
            return null;
        }
        for (CppDataLayout.CppStruct value : listOfData){
            //Add to the parent
            GNode newNode = createNewASTNode("Struct");
            newNode.add(value.name);
            addMethodsToNodeWithArray(newNode, value.methods);
            addFieldsToNodeWithArray(newNode, value.variables);
            node.add(newNode);
        }
        return node;
    }

    public static void addMethodsToNodeWithArray(GNode node, ArrayList<CppDataLayout.CppMethod> methods) {
        methods.add(new CppDataLayout.CppMethod("ThisMethod"));
        methods.add(new CppDataLayout.CppMethod("Metojd2"));
        GNode newNode = createNewASTNode("Methods");
        for (CppDataLayout.CppMethod method : methods) {
            GNode methodNode = createNewASTNode("Method");

            methodNode.add(method.name);
            methodNode.add(method.returnType);
            methodNode.add(createModifiersNode(method.modifiers));
            methodNode.add(createParametersNode(method.parameters));
            newNode.add(methodNode);
        }
        node.add(newNode);

    }

    public static GNode createModifiersNode(ArrayList<String> mods) {
        GNode newNode = createNewASTNode("Modifiers");
        for (String mod: mods) {
            newNode.add(mod);
        }
        return newNode;
    }

    public static GNode createParametersNode(ArrayList<CppDataLayout.Parameter> params) {
        GNode newNode = createNewASTNode("Parameters");
        for (CppDataLayout.Parameter p: params) {
            newNode.add(p.name);
            newNode.add(p.type);
        }
        return newNode;
    }

    public static void addFieldsToNodeWithArray(GNode node, ArrayList<CppDataLayout.CppVar> vars) {
        vars.add(new CppDataLayout.CppVar());
        GNode newNode = createNewASTNode("Fields");
        for (CppDataLayout.CppVar v : vars) {
            GNode fieldNode = createNewASTNode("Field");

            fieldNode.add(v.name);
            fieldNode.add(v.type);
            fieldNode.add(createModifiersNode(v.modifiers));

            newNode.add(fieldNode);
        }
        node.add(newNode);
    }

    //Custom object to hold key values for the Gnode
//    public static class simpleCPPDataNode extends cppNodeActions{
//
//        private String type;
//        private String value;
//
//        public simpleCPPDataNode(String type, String value){
//            this.type = type;
//            this.value = value;
//        }
//
//        public void setType(String type) {
//            this.type = type;
//        }
//
//        public String getType() {
//            return type;
//        }
//
//        public void setValue(String value) {
//            this.value = value;
//        }
//
//        public String getValue() {
//            return value;
//        }
//
//        @Override
//        public String toString() {
//            return this.type + " = " + this.value;
//        }
//    }

}




