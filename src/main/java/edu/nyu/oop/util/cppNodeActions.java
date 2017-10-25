package edu.nyu.oop.util;

import xtc.tree.GNode;

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
            node.add(value.name);
        }
        return node;
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



