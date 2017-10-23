package edu.nyu.oop.util;

import xtc.tree.GNode;
import edu.nyu.oop.simpleCPPDataNode;

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

    public static GNode addDataToNode(GNode node, String value){
        //Create new simpleCPPDataNode
        node.set(0,value);
        //Add the data node to node
        return node;
    }

    //Add data to node for multiple varaibles

    public static GNode addDataToNodeWithArray(GNode node, String type ,ArrayList<String> listOfData){
        if(listOfData == null && listOfData.size() == 0){
            return null;
        }
        for (String value : listOfData){
            addDataToNode(node,value);
        }
        return node;
    }

}
