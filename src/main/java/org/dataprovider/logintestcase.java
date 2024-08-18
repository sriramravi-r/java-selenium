package org.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class logintestcase {

    @Test(dataProvider = "logindata") // logindata is method name
    void test_login(String name,int age){
        System.out.println("my name is "+name+", my age is "+age+".");

    }

    @DataProvider
    public Object[][] logindata(){
        return new Object[][]{
                {"sriram",18},
                {"ram",19},
                {"sri",20}
        };
    }
}
