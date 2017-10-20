package edu.nyu.oop;

import org.junit.*;
import org.slf4j.Logger;
import xtc.tree.GNode;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TraverseASTTest {
    private static Logger logger = org.slf4j.LoggerFactory.getLogger(TraverseASTTest.class);

    private static GNode node = null;

   // private TraverseAST.MethodSummary summary;

    private TraverseAST.ClassSummary classSummary;


    @BeforeClass
    public static void beforeClass() {
        logger.debug("Executing TraverseASTTest");
        node = (GNode) XtcTestUtils.loadTestFile("src/test/java/inputs/test017/Test017.java");

        // XtcTestUtils.prettyPrintAst(node);
    }

    @Before
    public void before() {
        TraverseAST visitor = new TraverseAST();
        //summary = visitor.getSummary(node);
        classSummary = visitor.getClassSummary(node);
    }

    @Test
    public void testMethodSummary1() {
        // Assert that the correct number of methods were counted by our visitor
        System.out.println(classSummary.classes.toString());
        System.out.println("hellooooo");
//        assertEquals(2, classSummary.classes.size());
//        assretEquals(1, classSummary.classes.get(1).getConstructors().size());
        // to see constructor details of the first class in the file
        ArrayList<CustomConstructorClass> constructors = classSummary.classes.get(0).getConstructors();
        for (int i = 0; i < constructors.size(); i++) {
            CustomConstructorClass c = constructors.get(i);
            System.out.println(c.getVisibility());
            System.out.println(c.getName());
            ArrayList<CustomVariablesClass> vars = c.getParameters();
            for (int j = 0; j < vars.size(); j++) {
                CustomVariablesClass v = vars.get(j);
                System.out.println(v.visibility);
                System.out.println(v.modifier);
                System.out.println(v.name);
                System.out.println(v.type);
            }
        }
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
