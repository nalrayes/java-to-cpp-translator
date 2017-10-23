package edu.nyu.oop;

import org.junit.*;
import org.slf4j.Logger;
import xtc.tree.GNode;



import static org.junit.Assert.*;

public class CppHVisitorTest {
    private static Logger logger = org.slf4j.LoggerFactory.getLogger(CppHVisitorTest.class);

    private static GNode node = null;

    private CppHeaderVisitor.MethodSummary summary;



    CppHeaderVisitor visitor = new CppHeaderVisitor();




    @BeforeClass
    public static void beforeClass() {
        logger.debug("Executing MethodVisitorTest");
        node = (GNode) XtcTestUtils.loadTestFile("src/test/java/inputs/test001/Test001.java");
        XtcTestUtils.prettyPrintAst(node);
    }

    @Before
    public void before() {
        CppHeaderVisitor visitor = new CppHeaderVisitor();
        System.out.println(summary);
        summary = visitor.getSummary(node);
    }

    @Test
    public void testMethodSummary1() {
        // Assert that the correct number of methods were counted by our visitor
        System.out.println(summary);
        assertEquals(summary.count, 2);
    }

    @Test
    public void testMethodSummary2() {
        // Assert that the toString method name was collected
        assertTrue(summary.names.contains("toString"));
    }

    @Test
    public void testMethodSummary3() {
        // Assert that the main method name was collected
        assertTrue(summary.names.contains("main"));
    }

}
