package edu.nyu.oop;

import org.slf4j.Logger;

import xtc.tree.GNode;
import xtc.tree.Node;
import xtc.tree.Visitor;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

/**
 * This class demostrates a trivial usage of Xtc's Visitor class.
 * You may use this as a base for your ScopeVisitor.
 */
public class CppHeaderVisitor extends xtc.tree.Visitor {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());



    public void visitDependencies(GNode n) throws IOException {
//        summary.nodes += n.getName() + " ";
//        summary.names += n.getString(3) + " ";

        Node modifiers  = n.getNode(0);
        for (int i = 0; i < modifiers.size(); i++) {
            Node curNode = modifiers.getNode(i);
            String modifierName = curNode.toString();
            System.out.println(modifierName);
        }
       // summary.count++;
        visit(n);
    }

    public void visit(Node n) {
        for (Object o : n) if (o instanceof Node) dispatch((Node) o);
    }


}