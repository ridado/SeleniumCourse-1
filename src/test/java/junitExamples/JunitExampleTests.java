package junitExamples;

import org.junit.jupiter.api.*;

public class JunitExampleTests {

    @BeforeAll
    public static void classSetUp() {
        System.out.println("classSetUp()");
    }

    @AfterAll
    public static void classTearDown() {
        System.out.println("classTearDown()");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("setUp()");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("tearDown()");
    }

    @Test
    public void testA() {
        System.out.println("testA()");

        Assertions.assertTrue(1 == 1);
        Assertions.assertEquals(1, 1, "Wlasny komunikat bledu");
        Assertions.assertNotEquals(1, 2);
    }

    //@Disabled("Wylaczony z jakiegos powodu.")
    @Test
    public void testB() {
        int a = 5 / 0;
        System.out.println("testB()");
    }
}
