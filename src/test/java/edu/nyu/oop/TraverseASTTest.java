package edu.nyu.oop;

import org.junit.*;
import org.slf4j.Logger;
import xtc.tree.GNode;

import static org.junit.Assert.*;

public class TraverseASTTest {
    private static Logger logger = org.slf4j.LoggerFactory.getLogger(TraverseASTTest.class);

    private static GNode node = null;

   // private TraverseAST.MethodSummary summary;

    private TraverseAST.ClassSummary classSummary;


    @BeforeClass
    public static void beforeClass() {
        logger.debug("Executing TraverseASTTest");
        node = (GNode) XtcTestUtils.loadTestFile("src/test/java/inputs/test001/Test001.java");
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
       assertEquals(2, classSummary.classes.size());
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
