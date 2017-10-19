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

        // Get Modifier if one exists 
        if (n.getNode(0).getName().equals("Modifiers") && n.getNode(0).getNode(0).size() > 0){

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
        String declarator = n.getNode(2).getNode(0).getString(0);
       // System.out.println(declarator);
        varToReturn.name = declarator;




        String theVariable = qualifiedIdentifier + " " + declarator;
        System.out.println("var to return " + varToReturn.name);

        return varToReturn;

      //  theV


        //Get Class var declarators

      // return n.getString(1);

   }


    public void visitClassDeclaration(GNode n) {
       // summary.nodes += n.getName() + " ";
        //summary.names += n.getString(3) + " ";
        CustomClassObject aClass = new CustomClassObject();
        aClass.className = n.getString(1);
      //  System.out.println("printing " + aClass.className);
        Node modifiers  = n.getNode(0);
        for (int i = 0; i < modifiers.size(); i++) {
            Node curNode = modifiers.getNode(i);
            String modifierName = curNode.getString(0);
            aClass.modifiers.add(modifierName);

        }

  //  visitClassBody(n);
      //  System.out.println("class body " + n.getNode(5));

        Node classBody = n.getNode(5);


        int classBodySize = n.getNode(5).size();

        for (int i = 0; i < classBodySize; i++){
             Node curNode = classBody.getNode(i);


            if (curNode.getName().equals("FieldDeclaration")){

                    System.out.println("found field dec");
                    //System.out.println(curNode.getName());
                   

                   CustomVariablesClass aVar = TraverseFieldDeclaration(curNode);

                   aClass.classVariables.add(aVar);

                   for (CustomVariablesClass v : aClass.classVariables){

                    System.out.println("the vars " + v.name);
                   }

                  // System.out.println("the var " + aVar.name);



                   //System.out.println("class var " + getClassVar);


            }



        }


           
            //isit(n)

        


        //get class vars
      //  System.out.println("class body " + n.getNode(5));



        classSummary.classes.add(aClass);

        System.out.println("class's modifiers " + aClass.modifiers.toString());



       // summary.count++;
        visit(n);
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