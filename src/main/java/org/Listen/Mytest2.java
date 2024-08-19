package org.Listen;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Mytest2 {
    @Test(testName = "failing test case")
    void myTest2_myame(){
        SoftAssert sa=new SoftAssert();
        sa.assertTrue(false);
        sa.assertAll();
    }

    @Test
    void myTest3(){
        System.out.println("after from failed method");
    }
}
