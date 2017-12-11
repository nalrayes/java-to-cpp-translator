package edu.nyu.oop;

import edu.nyu.oop.util.CppDataLayout;
import edu.nyu.oop.util.cppNodeActions;
import xtc.tree.GNode;
import java.util.ArrayList;
import java.util.List;
import xtc.tree.Node;



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

        //ERROR CHECK PRINTING STUFF
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


        //XtcPrettyPrintCustom.prettyPrintAst(cppast.getRoot());
        //XtcPrettyPrintCustom.prettyPrintAst(cppast.getLinkToNamespaceNode());

        //Add to the cpp AST Tree
        //Get the root node of the CPPAST tree
        GNode rootNodeCppAST = cppast.getRoot();
        //We add new dependencies so first get the dependency node
        Node dependNode = rootNodeCppAST.getNode(0);
        addNewDep(dependNode);

        //We add new namespaces for the mainMethod
        Node usingNamespaceNode = rootNodeCppAST.getNode(1);
        addNewNameSpaces(usingNamespaceNode);

        //Add the node for implementation classes
        GNode impClassNode = cppNodeActions.createNewASTNode("ImplementationClassses");
        cppNodeActions.addNodeAsChildToParent((GNode) cppast.getLinkToNamespaceNode(), impClassNode);


        //First add the class level information
        for (CppDataLayoutM.cppImplementationClass theClassLevel: listOfCppImpClassesDatalayout){
            //Get the namespace node
            Node theClassesImplementationNode = impClassNode;
            //Add the class level nodes
            Node ImplementationClassNode = addClassLevelImpNode(theClassesImplementationNode, theClassLevel);

            //Create a new MethodsImplementationNode
            GNode impMethodsNode = cppNodeActions.createNewASTNode("ImplementationMethods");
            cppNodeActions.addNodeAsChildToParent((GNode) ImplementationClassNode, impMethodsNode);

            //First check if there exists the default int
            if (theClassLevel.defaultInIt != null){
                impMethodsNode =  (GNode) addImplementationMethodNode (impMethodsNode, theClassLevel.defaultInIt);
            }

            //Add the method implementations to XTC tree
            for (CppDataLayoutM.cppMethodImplementation method : theClassLevel.cppMethodImplementations) {
                GNode ImplementationMethodsNode = impMethodsNode;
                addImplementationMethodNode(ImplementationMethodsNode,method);
            }

            XtcPrettyPrintCustom.prettyPrintAst(ImplementationClassNode);

        }//End of class for loop


        //TODO Handle the main method last


        return cppast;
    }


    //Helper method to add new dependencies
    private static void addNewDep (Node depNode){
        cppNodeActions.addDataToNode((GNode)depNode, "#include \"output.h\"");
        cppNodeActions.addDataToNode((GNode)depNode, "#include <iostream>");
    }

    private static void addNewNameSpaces (Node usingNamespaceNode){
        cppNodeActions.addDataToNode((GNode) usingNamespaceNode,"inputs::constructors");
        cppNodeActions.addDataToNode((GNode) usingNamespaceNode,"namespace std");
    }

    private static Node addClassLevelImpNode (Node theClassesImplementationNode, CppDataLayoutM.cppImplementationClass classData){
        //Create new impl classNode
        GNode impClassNode = cppNodeActions.createNewASTNode("ImplementationClass");
        //Add the node to the namespace
        cppNodeActions.addNodeAsChildToParent((GNode) theClassesImplementationNode, impClassNode);

        //Add the class level data
        //First - Data layout constructor default initializes all instance fields
        cppNodeActions.addDataToNode((GNode) impClassNode, classData.deafultConstructorImplementation);

        //Second - Internal accessor for the objects class
        cppNodeActions.addDataToNode((GNode) impClassNode, classData.classMethodInit);

        //Third - // The vtable for the class
        cppNodeActions.addDataToNode((GNode) impClassNode, classData.vTableDecl);

        return impClassNode;
    }

    private static Node addImplementationMethodNode (Node ImplementationMethodsNode, CppDataLayoutM.cppMethodImplementation methodData){
        //Create new method implementation Node
        GNode impMethodNode = cppNodeActions.createNewASTNode("MethodImplementation");
        //Add to ImplementationMethods Node
        cppNodeActions.addNodeAsChildToParent((GNode) ImplementationMethodsNode, impMethodNode);

        //First add the method name to the node
        String methodFullNameCall = methodData.name + methodData.params;
        if(methodData.params == null){
            methodFullNameCall = methodData.name;
        }
        cppNodeActions.addDataToNode((GNode) impMethodNode, methodFullNameCall);

        //Next add the return type to the methodNode
        //First add the method name to the node
        cppNodeActions.addDataToNode((GNode) impMethodNode, methodData.returnType);

        //Next add the block Node to the method and process the block
        GNode blockImplementationNode = cppNodeActions.createNewASTNode("BlockImplementation");
        cppNodeActions.addNodeAsChildToParent((GNode) impMethodNode, blockImplementationNode);

        //Handle the block level implementation here
        //TODO Handle THE BLOCK
        



        return  ImplementationMethodsNode;
    }




}
