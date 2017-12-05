package edu.nyu.oop;

import edu.nyu.oop.util.CppDataLayout;
import xtc.tree.GNode;

import java.util.ArrayList;
import java.util.List;

public class CppMASTCreator {


    public static CPPAST createNewCPPMAstFrom(List<GNode> javaASTNodes, CPPAST cppast, TraverseASTM visitor) {

        //Holds the ImplementationClassSummary from JavaASTs
        List<TraverseASTM.ImplementationSummary> javaImplementationClassSummaries = new ArrayList<TraverseASTM.ImplementationSummary>();
        for (GNode javaAST : javaASTNodes) {
            javaImplementationClassSummaries.add(visitor.getImplementationSummary(javaAST));
        }

        CppDataLayoutM layoutM = new CppDataLayoutM();

        //With the Class Summary Implementation populate the CppAST Tree
        for (TraverseASTM.ImplementationSummary implementationData : javaImplementationClassSummaries) {
            //Add the nameSpaces to our C++ AST Tree
           // addStructNodes(javaData, currentNamespace, cppHeaderAST);
            //TODO
            for (CustomClassObject classObj : implementationData.implementationClassObjects) {
                /*
                    if classObj.getMethodNames includes main :
                        get main function
                        handle that shit
                            possibilities:
                            - new main struct
                            - just take the block object and store that somewhere
                 */
                layoutM.implementationClasses.add(new CppDataLayoutM.cppImplementationClass(classObj));
            }



        }












        return cppast;
    }


}
