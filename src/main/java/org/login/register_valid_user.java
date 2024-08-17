package org.login;

import org.testng.annotations.*;

public class register_valid_user {

    @BeforeTest
    void setup(){
        System.out.println("i am a setup");
    }

    @Test
    void register_valid(){
        System.out.println("i am valid reg user");
    }

    @AfterTest
    void teardown(){
        System.out.println("i am tear down");
    }


}
