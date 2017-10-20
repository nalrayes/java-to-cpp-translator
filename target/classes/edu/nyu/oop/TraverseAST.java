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
        String declarator = n.getNode(2).getNode(0).getString(0);
       // System.out.println(declarator);
        varToReturn.name = declarator;




        String theVariable = qualifiedIdentifier + " " + declarator;
        System.out.println("var to return " + varToReturn.name);


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


    public void visitClassDeclaration(GNode n) {
       // summary.nodes += n.getName() + " ";
        //summary.names += n.getString(3) + " ";
        CustomClassObject aClass = new CustomClassObject();
        aClass.className = n.getString(1);
      
        // Get all modifiers of the class and add them to the class object
        Node modifiers  = n.getNode(0);
        for (int i = 0; i < modifiers.size(); i++) {
            Node curNode = modifiers.getNode(i);
            String modifierName = curNode.getString(0);
            aClass.modifiers.add(modifierName);

        }



        Node classBody = n.getNode(5);


        int classBodySize = n.getNode(5).size();

        // check all field declarations
        for (int i = 0; i < classBodySize; i++){
             Node curNode = classBody.getNode(i);

             // if a field Declaration is found get the class variable contained within it
            if (curNode.getName().equals("FieldDeclaration")){

                    
                    // calls a custom method TraverseFieldDeclaration to collect variable info
                   CustomVariablesClass aVar = TraverseFieldDeclaration(curNode);

                   aClass.classVariables.add(aVar);

                   if (DEBUGGING == 1){

                       for (CustomVariablesClass v : aClass.classVariables){

                        System.out.println("the vars " + v.name);
                       }
                    }

                  // System.out.println("the var " + aVar.name);



                   //System.out.println("class var " + getClassVar);


            }



        }



        // GET METHODS - WILL TURN THIS INTO A METHOD LATER 

        classBody = n.getNode(5);

        for (int i = 0; i < classBody.size(); i++){


            if (classBody.getNode(i).getName().equals("MethodDeclaration")){
               // System.out.println(classBody.getNode(i));

                CustomMethodClass methodObj = new CustomMethodClass();

                Node currMethod = classBody.getNode(i);


                Node methodModifers = currMethod.getNode(0);

                //System .out.println(methodModifers);

                int methodModifersSize = methodModifers.getNode(0).size();

                String wholeModifier = "";

                for (int j = 0; j < methodModifersSize; j++){



                   if (checkMethodVisibility(methodModifers.getNode(0).getString(j)) == true){
                       // System.out.println("vis");
                        methodObj.visibility = methodModifers.getNode(0).getString(j);


                   }
                   else{
                        wholeModifier += methodModifers.getNode(0).getString(j) + " ";
                    }
                        
                        //System.out.println(methodModifers.getNode(0).getString(j));

                }

                methodObj.modifier = wholeModifier;




                // GET PARAMETERS OF METHOD
                // Identifier
                System.out.println("iden " + n.getNode(5).getNode(0).getNode(1));

                //Declarator
                System.out.println("declarator " + n.getNode(5).getNode(0).getNode(2));



                //methodObj.modifiers = wholeModifier;



                
            }
        }

            //     //System.out.println("helloi");

            // }
        //}


                //System.out.println("hello");



        


           
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