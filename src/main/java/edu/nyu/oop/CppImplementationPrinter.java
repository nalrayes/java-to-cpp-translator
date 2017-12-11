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

public class CppImplementationPrinter extends Visitor {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    private Printer printer;

    private String outputLocation = XtcProps.get("output.location");

    public CppImplementationPrinter() {
        Writer w = null;
        try {
            FileOutputStream fos = new FileOutputStream(outputLocation + "/output.cpp");
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

    int nameSpaceCount = 0;
    public void visitNamespace(GNode n) throws IOException {
        if(nameSpaceCount == 0){
            printer.pln("namespace " + n.getString(0) + " {");
        }
        else{
            printer.incr().indent().pln("namespace " + n.getString(0) + " {");
        }
        nameSpaceCount++;
        visit(n);
        nameSpaceCount = 0;
        //Decrement the printer for final brace
        printer.decr();
        printer.indent().pln("}");
    }

    public void visitImplementationClassses(GNode n) throws IOException {
        printer.pln("");
        visit(n);
    }


    public void visitImplementationClass(GNode n) throws IOException {
        printer.incr().indent().pln(n.getString(0));
        printer.pln("");
        printer.indent().pln(n.getString(1));
        printer.pln("");
        printer.indent().pln(n.getString(2));
        printer.pln("");

        visit(n);
    }



    public void visitMethodImplementation(GNode n) throws IOException {
        //Print default constructor
        printer.indent().pln(n.getString(0) + " {");
        printer.pln("");
        visit(n);
        printer.pln("");
    }

    public void visitBlockImplementation(GNode n) throws IOException {
        //Print default constructor
        //printer.incr().indent().pln(n.getString(0));

        //Use a for loop to go through the block stuff
        for (int i = 0; i < n.size(); i ++){
            //Check if the node is a string or not
            if(n.getString(i) != null){
                //If it is a string then print it
                //TODO
            }

        }
        visit(n);
        printer.indent().pln("}");

    }

    public void visitForLoopImplementation(GNode n) throws IOException{



        visit(n);
    }














    //Helper methods
    private void headOfFile() {
        printer.pln("#include <iostream>");
        printer.pln("#include \"java_lang.h\"");
        printer.pln();
        printer.pln("using namespace java::lang;");
        printer.pln("using namespace std;");
        printer.pln();
        printer.pln("int main(void) {");
    }

    private void cout(String line) {
        printer.incr().indent().pln("cout << \"" + line + "\" << endl;").decr();
    }

    private void tailOfFile() {
        printer.incr().indent().pln("return 0;");
        printer.decr(); // not really necessary, but for demonstration.
        printer.pln("}");
    }

}
