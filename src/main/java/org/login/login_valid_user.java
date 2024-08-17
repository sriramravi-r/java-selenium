package org.login;

import org.testng.annotations.*;

public class login_valid_user {

    @BeforeTest
    void setup(){
        System.out.println("hi i am setup");
    }

    @Test
    void somke_validone(){
        System.out.println("valid one");
    }

    @BeforeClass
    void beforeclass(){
        System.out.println("__________________i am before class");
    }

    @AfterClass
    void Afterclass(){
        System.out.println("__________________i am after class");
    }
}
