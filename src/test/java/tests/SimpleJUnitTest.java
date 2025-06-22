package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SimpleJUnitTest {

    int result;

    @BeforeEach
    void beforeEach() {
        System.out.println("### beforeEach()");
        result = getResult();
    }

    @AfterEach
    void afterEach() {
        System.out.println("###  afterEach()");
        result = 0;
    }

    @Test
    void firstTest() {
        int result = getResult();
        System.out.println("###   firstTest()");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void secondTest() {
        int result = getResult();
        System.out.println("###   secondTest()");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void thirdTest() {
        int result = getResult();
        System.out.println("###   thirdTest()");
        Assertions.assertTrue(result > 2);
    }

    private int getResult() {
        return 3;
    }
}
