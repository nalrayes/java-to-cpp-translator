package edu.nyu.oop;

import java.io.*;
import java.util.*;

import edu.nyu.oop.util.XtcProps;
import org.slf4j.Logger;
import xtc.lang.CPrinter;
import xtc.tree.Node;
import xtc.tree.GNode;
import xtc.tree.Printer;
import xtc.tree.Visitor;
import edu.nyu.oop.util.*;


public class CppMainPrinter  extends Visitor {
    private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    private Printer printer;

    private String outputLocation = XtcProps.get("output.location");

    public CppMainPrinter() {
        Writer w = null;
        try {
            FileOutputStream fos = new FileOutputStream(outputLocation + "/main.cpp");
            OutputStreamWriter ows = new OutputStreamWriter(fos, "utf-8");
            w = new BufferedWriter(ows);
            this.printer = new Printer(w);
        } catch (Exception e) {
            throw new RuntimeException("Output location not found. Create the /output directory.");
        }

        // Register the visitor as being associated with this printer.
        // We do this so we get some nice convenience methods on the printer,
        // such as "dispatch", You should read the code for Printer to learn more.
        printer.register(this);
    }

    public void print(Node n) {
        dispatch(n);
        printer.flush(); // important!
    }

    // Print all the node names in an Ast
    public void visit(Node n) {
        for (Object o : n) if (o instanceof Node) dispatch((Node) o);
    }

    //Custom VisitMethods
    public void visitDependencies(GNode n) throws IOException {
        for (int i = 0; i < n.size(); i++) {
            printer.pln( n.getString(i));
        }
        printer.pln("");
        visit(n);
    }

    public void visitUsingNamespace(GNode n) throws IOException {
        for (int i = 0; i < n.size(); i ++){
            printer.pln("using namespace " + n.getString(i) + ";");
        }
        visit(n);
        printer.pln("");
    }


    public void visitNamespace(GNode n) throws IOException {
        visit(n);
    }

    public void visitImplementationMain(GNode n) throws IOException {
        printer.indent().pln(n.getString(0) + " {");

        visit(n);

        printer.decr();
        printer.indent().pln("}");

    }

    public void visitMainMethodBlockImplementation(GNode n) throws IOException{

        visit(n);

    }

}
