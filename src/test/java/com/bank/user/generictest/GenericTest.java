package com.bank.user.generictest;

import com.bank.user.util.Generic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenericTest {

    @Test
    public void generateUUIDOK(){
        String uuidTest;
        uuidTest= Generic.generateUUID();
        assertNotNull(uuidTest);
    }

    @Test
    public void getCurrentDateOk(){
        String dateNow = Generic.getCurrentDate();
        assertNotNull(dateNow);
    }

    @Test
    public void isEmailOk(){
        String email="jllozano.100@gmail.com";
        String regPattern = "^(.+)@(\\S+)$";
        boolean okEmail = Generic.patternMatches(email,regPattern);
        assertTrue (okEmail);
    }

}
