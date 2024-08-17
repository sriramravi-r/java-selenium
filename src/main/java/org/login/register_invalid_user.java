package org.login;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class register_invalid_user {
    @Test
    void register_invalid(){
        System.out.println("i am invalid user");
    }

    @AfterSuite
    void teardown_suite(){
        System.out.println("i am teardown suit");
    }
}
