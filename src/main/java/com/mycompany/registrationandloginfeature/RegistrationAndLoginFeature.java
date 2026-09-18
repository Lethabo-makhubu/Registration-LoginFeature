/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registrationandloginfeature;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class RegistrationAndLoginFeature {

       public static void main(String[] args) {
        
        Scanner input = new Scanner (System.in);
    
        
        System.out.println("Please enter your username");
        String username = input.nextLine();
        
        Login obj = new Login("", username, "");
            //checking if the username meets the requirements
        if (obj.checkUsername()){
            
            System.out.println("Username is successfully captured.");
        
        }else{
            System.out.println("Username is not successfully captured! "
                    + "please ensure that the username contains an underscore "
                    + "and is no more than five characters");
            return;
        } 
        
        System.out.println("Please enter your cellphone number");
        String cellphoneNumber = input.nextLine();
        
        obj = new Login(cellphoneNumber, "", "");
        
        if (obj.checkcellphoneNumber()){
            
            System.out.println("Cellphone number successfully added.");
        }else{
            System.out.println("Cellphone number incorrectly formatted or does not contain international code");
            return;
        }
   
        System.out.println("Please enter your password");
        String password = input.nextLine();
        
        obj = new Login("", "", password);
        if (obj.checkPasswordComplexity()){
            
            System.out.println("Password successfully captured.");
        }else{
            System.out.println("Password is not correctly formatted, "
                    + "please ensure that the password contains at least eight characters, "
                    + "a capital letter, a number, and a special character");
            return;
        }
         
        //Register user
           System.out.println("Registration successful!");
           
           //login
           System.out.println("Please enter your username to login:");
           String loginUsername = input.nextLine();
           
           System.out.println("Please enter your password to login:");
           String loginPassword = input.nextLine();
           
           //Check login status
           boolean loginSuccessful = obj.loginUser(loginUsername, loginPassword);
           
           //Display login status
           System.out.println(obj.returnLoginStatus(loginSuccessful));
    }
}
