package org.testngattribute;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class loantestcase {
    @Test(dependsOnMethods = {"loan_three"})
    void loan_one(){
        System.out.println("loan one");
    }
    @Parameters({"chrome","edge"})
    @Test
    void loan_two(String chrome,String edge){
        System.out.println("loan two");
        System.out.println(chrome);
        System.out.println(edge);
    }
}
