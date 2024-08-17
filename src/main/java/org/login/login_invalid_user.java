package org.login;

import org.testng.annotations.*;

public class login_invalid_user {
    @Test
    void somke_invalidone(){
        System.out.println("in valid one");
    }
    @Test(groups = {"smoke"})
    void invalidone_two(){
        System.out.println("in valid two");
    }


    @BeforeMethod
    void before_method(){
        System.out.println("hi i am a before method=========================");
    }

    @AfterMethod
    void after_method(){
        System.out.println("hi i am a after method=========================");
    }

    @AfterTest
    void teardown(){
        System.out.println("hi i am teardow");
    }

    @BeforeSuite
    void setup_suite(){
        System.out.println("hi i am setup suite");
    }
}
