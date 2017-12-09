package edu.nyu.oop;

import edu.nyu.oop.util.CppDataLayout;
import xtc.tree.GNode;

import java.util.ArrayList;
import java.util.List;

public class CppMASTCreator {


    public static CPPAST createNewCPPMAstFrom(List<GNode> javaASTNodes, CPPAST cppast, TraverseASTM visitor) {

        //Holds the ImplementationClassSummary from JavaASTs
        //Get all the data from JavaAst using Visitor
        List<TraverseASTM.ImplementationSummary> javaImplementationClassSummaries = new ArrayList<TraverseASTM.ImplementationSummary>();
        for (GNode javaAST : javaASTNodes) {
            javaImplementationClassSummaries.add(visitor.getImplementationSummary(javaAST));
        }

        //Create a new CppDataMLayout
        CppDataLayoutM layoutM = new CppDataLayoutM();

        //ArrayList to hold the implemented dataLayouts
        ArrayList<CppDataLayoutM.cppImplementationClass> listOfCppImpClassesDatalayout = new ArrayList<CppDataLayoutM.cppImplementationClass>();
        //Single data property to hold the main class
        CppDataLayoutM.cppImplementationMainMethodClass mainMethodClassm = null;


        //With the Class Summary Implementation populate the CppAST Tree
        for (TraverseASTM.ImplementationSummary implementationData : javaImplementationClassSummaries) {
            for (CustomClassObject classObj : implementationData.implementationClassObjects) {

                //Handle main class check
                //Get the list of methods that exist in the class
                ArrayList<CustomMethodClass> listOfMethods = classObj.getMethods();
                //Set flag to false
                boolean ismain = false;
                CustomMethodClass mainMethod = null;
                for (CustomMethodClass methodInClass : listOfMethods){
                    if (methodInClass.getName().contains("main")){
                        ismain = true;
                        mainMethod = methodInClass;
                    }
                }
               if (ismain){
                    //Handle for main method
                    mainMethodClassm = new CppDataLayoutM.cppImplementationMainMethodClass(mainMethod);
                }
              else{
                    //This is for normal methods
                    listOfCppImpClassesDatalayout.add(new CppDataLayoutM.cppImplementationClass(classObj));
                }
            }
        }

        //Print
        for (CppDataLayoutM.cppImplementationClass class1: listOfCppImpClassesDatalayout){
//            System.out.println("$imple size " + class1.cppMethodImplementations.size());

            for (CppDataLayoutM.cppMethodImplementation method : class1.cppMethodImplementations){

//                System.out.println("$ello123 " + method.name + " " + method.translatedBlock.getFieldDeclarations().size());


                for (CppDataLayoutM.CustomFieldDeclaration cfd : method.translatedBlock.getFieldDeclarations()){
//                    System.out.println("herez "+ cfd.fieldDeclarationLine);
                }



            }
        }
//        System.out.println("$mainmethod " + mainMethodClassm.transLatedBlockForImpMainMethod.getFieldDeclarations().size());


        for (CppDataLayoutM.CustomFieldDeclaration cfd : mainMethodClassm.transLatedBlockForImpMainMethod.getFieldDeclarations()){
//            System.out.println("herez1 "+ cfd.fieldDeclarationLine);
        }


        //TODO ADD DATA FROM listOfCppImpClassesDatalayout and mainMethodClassm to cppast tree
        //TODO First add the class level information from cppImplementationClass
        //TODO. Second Handle the defauly init method. When adding to the tree. First check if deafultConstructorImplementation in cppImplementationClass is null.
        //TODO. If not null add the data from deafultConstructorImplementation to the tree before moving to add the arrayList
        //TODO of cppMethodImplementations





        return cppast;
    }
}
