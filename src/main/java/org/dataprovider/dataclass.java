package org.dataprovider;

import org.testng.annotations.DataProvider;

public class dataclass {
    @DataProvider
    public static Object[][] logindata(){
        return new Object[][]{
                {"sriram",18},
                {"ram",19},
                {"sri",20}
        };
    }
}
