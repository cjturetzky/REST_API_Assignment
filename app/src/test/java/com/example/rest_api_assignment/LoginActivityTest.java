package com.example.rest_api_assignment;


import org.junit.Test;
import static org.junit.Assert.*;

public class LoginActivityTest{

    @Test
    public void invalidUsernameTest(){ assertEquals(-1, LoginActivity.checkUsername("invalidUser")); }

    @Test
    public void invalidPasswordTest(){
        assertEquals(false, LoginActivity.checkPassword(1, "invalidPass"));
    }

    @Test
    public void validLoginTest(){
        assertEquals(1, LoginActivity.checkUsername("cturetzky@csumb.edu"));
        assertEquals(true, LoginActivity.checkPassword(1, "testPass"));
    }
}