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

public class CppHeaderPrinter extends Visitor {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    private Printer printer;

    private String outputLocation = XtcProps.get("output.location");

    public CppHeaderPrinter() {
        Writer w = null;
        try {
            FileOutputStream fos = new FileOutputStream(outputLocation + "/output.h");
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

    public void visitDependencies(GNode n) throws IOException {
        for (int i = 0; i < n.size(); i++) {
            printer.pln( n.getString(i));
        }
        printer.pln("");
        visit(n);
    }

    public void visitUsingNamespace(GNode n) throws IOException {
        printer.pln("using namespace " + n.getString(0) + ";");
        visit(n);
        printer.pln("");
    }

    public void visitNamespace(GNode n) throws IOException {
        printer.incr().indent().pln("namespace " + n.getString(0) + "{");
        visit(n);
        printer.pln("}");
    }
    public void visitStructs(GNode n) throws IOException {
        printer.pln("");
        visit(n);
    }
    public void visitStruct(GNode n) throws IOException {
        printer.pln("struct " + n.getString(0) + ";");
        printer.pln("");
        printer.pln("struct " + n.getString(0) + "{ ");
        visit(n);
        printer.pln("};");
    }
    public void visitMethods(GNode n) throws IOException {
        visit(n);
    }

    public void visitVisability(GNode n) throws IOException {

    }
    public void visitParameters(GNode n) {
        printer.p('(');
        visit(n);
        // TODO: remove comma at the end of the line
        // before closing parentheses
        if (n.size() > 0) {
        }
        printer.p(')');
    }
    public void visitParameter(GNode n) {
        printer.p(n.getString(0));
        printer.p(',');
        visit(n);
    }
    public void visitMethod(GNode n) throws IOException {
        // all public for now
        // TODO: add static modifiers

        printer.p(n.getString(1) + " " + n.getString(0));
        visit(n);
        printer.pln(";");
    }
    public void visitFields(GNode n) throws IOException {

    }
    public void visitField(GNode n) throws IOException {

    }



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
