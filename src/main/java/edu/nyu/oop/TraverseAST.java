package edu.nyu.oop;

import org.slf4j.Logger;

import xtc.tree.GNode;
import xtc.tree.Node;
import xtc.tree.Visitor;

import java.util.List;
import java.util.ArrayList;

/**
 * This class demostrates a trivial usage of Xtc's Visitor class.
 * You may use this as a base for your ScopeVisitor.
 */
public class TraverseAST extends Visitor {
    private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    //IntermediateDataStructure astData = new IntermediateDataStructure();
    // CustomClassObject
    // private MethodSummary summary = new MethodSummary();

    private ClassSummary classSummary = new ClassSummary();

    public static final int DEBUGGING = 1;
    //Global var to keep track of the current class in AST
    public CustomClassObject currentClass;

    public void visitCompilationUnit(GNode n) {
        visit(n);
    }

    private void visitClassBody(GNode n){


        //System.out.print("in class body " + n.getName());
        visit(n);


    }

    // this function is used to get class Vars
    public CustomVariablesClass TraverseFieldDeclaration(Node n){

        // System.out.println(n.getName());
        CustomVariablesClass varToReturn = new CustomVariablesClass();
        if (n.getNode(0).getName().equals("Modifiers") && n.getNode(0).size() > 0){
            String varModifiers = "";
            int amountOfModifers = n.getNode(0).size();
            for (int i = 0; i < amountOfModifers; i++){
                //System.out.println("get mods " + n.getNode(0).getNode(0).getString(i));
                varModifiers += n.getNode(0).getNode(0).getString(i) + " ";

            }
            varToReturn.modifier = varModifiers;
        }

        // Get Qualified Identifier
        String qualifiedIdentifier = n.getNode(1).getNode(0).getString(0);
        //System.out.println(qualifiedIdentifier);
        varToReturn.type = qualifiedIdentifier;

        // Get Declarator Identifier
        // System.out.println("Get Dec");
        String declarator;
        if (n.getNode(2) != null) {
            // then this is a declarator
            declarator = n.getNode(2).getNode(0).getString(0);
        } else {
            // then this is a formalparameter
            declarator = n.getString(2);
        }

        // System.out.println(declarator);
        varToReturn.name = declarator;

        String theVariable = qualifiedIdentifier + " " + declarator;
        //System.out.println("var to return " + varToReturn.name);

        return varToReturn;
    }


    public void traverseMethodsInClass(Node n, CustomClassObject customClassObj){

        // getting methods in the class

        // if ()
        //System.out.println("in method " + n.getNode(5));


        int classBodySize = n.getNode(5).size();
        System.out.println("hello");

        // for (int i = 0; i < classBodySize; i++){

        //     if (n.getNode(5).getNode(i).getName().equals("MethodDeclaration")){

        //         Node theMethod = n.getNode(5).getNode(i);

        //         if (theMethod.getNode(0).getName().equals("Modifiers")){



        //             int modifierSize = theMethod.getNode(0).getNode(0).size();
        //            //System.out.println("mod size " + modifierSize);
        //           //  for (int x = 0; x < modifierSize; x++){


        //                 System.out.println("the mod " + theMethod.getNode(0).getNode(0).getString(x) + " at index " + x);



        //             //}


        //         }



        //     }


        // }



    }


    public boolean checkMethodVisibility(String check){

        switch (check){


            case "public":
                return true;
            // break;

            case "private":
                return true;
            // break;

            case "protected":
                return true;
            // break;

            default:
                return false;




        }

        // return false;



    }

    private CustomConstructorClass traverseConstructorDeclaration(Node n) {
        // name is 2nd
        String name = n.getString(2);
        // modifiers node
        Node modifiers = n.getNode(0);
        CustomConstructorClass currentConstructor = new CustomConstructorClass(name);
        // only possible modifiers for constructor is visibility
        if (modifiers.size() == 0) {
            currentConstructor.setVisibility("");
        } else {
            System.out.println(modifiers.getNode(0).getString(0));
            currentConstructor.setVisibility(modifiers.getNode(0).getString(0));
        }

        Node params = n.getNode(3);
        if (params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                // need to refactor, uses feilddeclaraion instead
                // of formalparamater. They're basically the same,
                // except for the difference outlined int the above
                // code
                currentConstructor.addParameter(TraverseFieldDeclaration(params.getNode(i)));
            }
        }


        return currentConstructor;
    }


    public void visitClassDeclaration(GNode n) {

        //Entering the class scope & create a new class object
        currentClass = new CustomClassObject();
        //Get the class name
        currentClass.className = n.getString(1);

        // Get all modifiers of the class and add them to the class object
        Node modifiers  = n.getNode(0);
        for (int i = 0; i < modifiers.size(); i++) {
            Node curNode = modifiers.getNode(i);
            String modifierName = curNode.getString(0);
            currentClass.modifiers.add(modifierName);

        }
        System.out.println("Class's modifiers " + currentClass.modifiers.toString());

        //Get the field decleration node
        Node classBody = n.getNode(5);
        //Get the size of the field
        int classBodySize = n.getNode(5).size();
        // check all field declarations
        for (int i = 0; i < classBodySize; i++){
            Node curNode = classBody.getNode(i);
            // if a field Declaration is found get the class variable contained within it
            if (curNode.getName().equals("FieldDeclaration")){
                // calls a custom method TraverseFieldDeclaration to collect variable info
                CustomVariablesClass aVar = TraverseFieldDeclaration(curNode);
                currentClass.classVariables.add(aVar);
                //For DEBUG
                if (DEBUGGING == 1){
                    for (CustomVariablesClass v : currentClass.classVariables){
                        System.out.println("Class vars " + v.name);
                    }
                }
            }
        }

        visit(n);
        //Class scope exists. Hence, end of the class
        //Save the class object to the array of class objects
        classSummary.classes.add(currentClass);
        //Make the pointer point to NULL
        System.out.println("End of class: " + currentClass.className);
        currentClass = null;
    }



    public void visitMethodDeclaration(GNode n) {


        CustomMethodClass methodObj = new CustomMethodClass();

        Node currMethod = n;


        Node methodModifers = currMethod.getNode(0);

        //System .out.println(methodModifers);

        int methodModifersSize = methodModifers.getNode(0).size();

        String wholeModifier = "";

        for (int j = 0; j < methodModifersSize; j++) {


            if (checkMethodVisibility(methodModifers.getNode(0).getString(j)) == true) {
                // System.out.println("vis");
                methodObj.visibility = methodModifers.getNode(0).getString(j);


            } else {
                wholeModifier += methodModifers.getNode(0).getString(j) + " ";
            }

            //System.out.println(methodModifers.getNode(0).getString(j));

        }

        methodObj.modifier = wholeModifier;

        Node params = currMethod;
        //System.out.println("params " + params.getNode(4).size());

        if (params.getNode(4).getName().equals("FormalParameters") && params.getNode(4).size() > 0) {

            Node formalParams = params.getNode(4);

           // System.out.println("here " + params.getNode(4).getNode(0));

//           for (int i = 0; i < params.getNode(4).getNode(0).size();i++){
//              // System.out.println("name " + params.getNode(4).getNode(0).size());
//               System.out.println("name " + params.getNode(4).getNode(0).getNode(i));
//
//
//
//
//
//           }

            //TraverseFieldDeclaration(params.getNode(4));
            //System.out.println("params " + params.getNode(4).getNode(0));
            //methodObj.parameters.add(TraverseFieldDeclaration(params.getNode(4)));
            // CustomVariablesClass myVars =


        }


        visit(n);
        //currentClass.

    }


    public void visitConstructorDeclaration(GNode n){
        CustomConstructorClass constructor = traverseConstructorDeclaration(n);
        currentClass.addConstructor(constructor);
    }


//    public void visitMethodDeclaration(GNode n) {
//        summary.nodes += n.getName() + " ";
//        summary.names += n.getString(3) + " ";
//
//        Node modifiers  = n.getNode(0);
//        for (int i = 0; i < modifiers.size(); i++) {
//            Node curNode = modifiers.getNode(i);
//            String modifierName = curNode.getString(0);
//            System.out.println("method " + curNode.getString(0));
//        }
//        summary.count++;
//        visit(n);
//    }

    public void visit(Node n) {
        for (Object o : n) if (o instanceof Node) dispatch((Node) o);
    }

//    public MethodSummary getSummary(Node n) {
//        super.dispatch(n);
//        return summary;
//    }

//    // An instance of this class will be mutated as the AST is traversed.
//    static class MethodSummary {
//        int count = 0;
//        String names = "";
//        String nodes = "";
//
//        public String toString() {
//            return "Method count: " + count + System.lineSeparator() +
//                    "Method names: " + names + System.lineSeparator() +
//                    "Node names: " + nodes + System.lineSeparator();
//        }
//    }

    public ClassSummary getClassSummary(Node n) {
        super.dispatch(n);
        return classSummary;
    }


    static class ClassSummary{


        ArrayList<CustomClassObject> classes = new ArrayList<CustomClassObject>();
//        public String toString() {
////            return "Method count: " + count + System.lineSeparator() +
////                    "Method names: " + names + System.lineSeparator() +
////                    "Node names: " + nodes + System.lineSeparator();
//
//
//       }


    }
}