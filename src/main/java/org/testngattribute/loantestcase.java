package org.testngattribute;

import org.testng.annotations.Test;

public class loantestcase {
    @Test(dependsOnMethods = {"loan_three"})
    void loan_one(){
        System.out.println("loan one");
    }
    @Test(timeOut = 4000)
    void loan_two(){
        System.out.println("loan two");
    }
}
