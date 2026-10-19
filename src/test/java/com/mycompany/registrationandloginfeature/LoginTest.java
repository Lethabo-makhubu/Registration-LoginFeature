/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.registrationandloginfeature;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class LoginTest {
    
    Login obj = new Login("+27672729603", "Lee_M", "Nkosinathi#12");
    
    @Test
    //test if username is correctly formatted
 public void testUsernameCorrectlyFormatted(){
     
          assertTrue (obj.checkUsername());
 }
 
    @Test
    //test if username is incorrectly formatted
    public void testUsernameIncorrectlyFormatted(){
        Login obj = new Login("+27672729603", "Kyle!!!!!!!", "Nkosinathi#12");       
        assertFalse(obj.checkUsername());
    }
    
    @Test
    //test if password meets the requirements
    public void testPasswordMeetsRequirements(){
        
        assertTrue(obj.checkPasswordComplexity());
    }
    
    @Test
    //test if password does not meet the requirements
    public void testPasswordDoesBotMeetRequirements(){
        Login obj = new Login("+27672729603", "Kyl_1", "password");
        
        assertFalse(obj.checkPasswordComplexity());
    }
    
    @Test
    //test if cellphone number is correctly formatted
    public void testValidCellphoneNumber(){
        assertTrue(obj.checkcellphoneNumber());
    }
    
    @Test
    //test if cellphone number is incorrectly formatted\
    public void testInvalidCellphoneNumber(){
        Login obj = new Login("0672729603", "Kyl_1", "Nkosinathi#12");
        
        assertFalse(obj.checkcellphoneNumber());
    }
    
    @Test
    //test login successful
    public void testLoginSuccessful(){
        assertTrue(obj.loginUser("Lee_M", "Nkosinathi#12"));
    }
    
    @Test
    //test login failed
    public void testLoginFailed(){
        Login obj = new Login("+27672729603", "Lee_M", "Nkosinathi#12");
        assertFalse(obj.loginUser("LeeMajor", "Password"));
    }
}
