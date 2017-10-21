package edu.nyu.oop;

import org.junit.*;
import org.slf4j.Logger;
import xtc.tree.GNode;
import java.util.ArrayList;
import edu.nyu.oop.util.JavaFiveImportParser;
import java.util.List;
import xtc.tree.Location;

import static org.junit.Assert.*;

public class TraverseASTTest {
    private static Logger logger = org.slf4j.LoggerFactory.getLogger(TraverseASTTest.class);

    private static GNode node = null;

   // private TraverseAST.MethodSummary summary;

    private TraverseAST.ClassSummary classSummary;


    @BeforeClass
    public static void beforeClass() {
        logger.debug("Executing TraverseASTTest");


        node = (GNode) XtcTestUtils.loadTestFile("src/test/java/inputs/CustomTests/CustomTest1.java");


        // XtcTestUtils.prettyPrintAst(node);
    }

    @Before
    public void before() {
        TraverseAST visitor = new TraverseAST();
        //summary = visitor.getSummary(node);

        //Test Phase one
        System.out.println("Start Phase One");
        List <GNode> javaASTNodes = PrimarySourceAndDep.getSourceAndDep(node);
        //System.out.println("Total Number of AST's found: " + javaASTNodes.size());
        GNode firstNode = javaASTNodes.get(0); //Get the first node
        //System.out.println(firstNode.getLocation().file);
        //System.out.println(firstNode);
        System.out.println("END Phase One");

        //Phase two
        classSummary = visitor.getClassSummary(node);

        //Print packages
        System.out.println("Packages: " + classSummary.packages);
    }

    @Test
    public void testMethodSummary1() {
        // Assert that the correct number of methods were counted by our visitor
        System.out.println(classSummary.classes.toString());
        System.out.println("Print classes");
        for (int i =0; i < classSummary.classes.size(); i++){

        //    System.out.println(classSummary.classes.get(i).methods.size());


            for (int j = 0; j < classSummary.classes.get(i).methods.size(); j++){

                System.out.println("m vis " + classSummary.classes.get(i).methods.get(j).visibility);
                System.out.println("m mod " + classSummary.classes.get(i).methods.get(j).modifier);
                System.out.println("m name " + classSummary.classes.get(i).methods.get(j).name);



            }

            //classSummary.classes.get(i).metho
        }




        assertEquals(3, classSummary.classes.size());
        //assertEquals(3, classSummary.classes);

//        assretEquals(1, classSummary.classes.get(1).getConstructors().size());
        // to see constructor details of the first class in the file
//        ArrayList<CustomConstructorClass> constructors = classSummary.classes.get(0).getConstructors();
//        for (int i = 0; i < constructors.size(); i++) {
//            CustomConstructorClass c = constructors.get(i);
//            System.out.println(c.getVisibility());
//            System.out.println(c.getName());
//            ArrayList<CustomVariablesClass> vars = c.getParameters();
//            for (int j = 0; j < vars.size(); j++) {
//                CustomVariablesClass v = vars.get(j);
//                System.out.println(v.visibility);
//                System.out.println(v.modifier);
//                System.out.println(v.name);
//                System.out.println(v.type);
//            }
//        }
    }

//    @Test
//    public void testMethodSummary2() {
//        // Assert that the toString method name was collected
//        assertTrue(summary.names.contains("toString"));
//    }
////
//    @Test
//    public void testMethodSummary3() {
//        // Assert that the main method name was collected
//        assertTrue(summary.names.contains("main"));
//    }

}
