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
           
// Login
    System.out.println("Please enter your username to login:");

    String loginUsername = input.nextLine().trim();

    System.out.println("Please enter your password to login:");

    String loginPassword = input.nextLine().trim();

    // Check the login details

    boolean loginSuccessful =

            loginUsername.equals(username.trim())

            && loginPassword.equals(password.trim());

    if (loginSuccessful) {
        
        System.out.println("Login successful!");
        
    } else {
        System.out.println("Username or password incorrect, please try again.");
        
    }

        if (loginSuccessful) {
        
            System.out.println("Welcome to QuickChat.");

    int option = 0;

    while (option != 3) {
        System.out.println("\n1) Send Messages");
        System.out.println("2) Show recently sent messages");
        System.out.println("3) Quit");
        System.out.print("Please select an option: ");

        if (!input.hasNextInt()) {
            System.out.println("Please enter a number.");
            input.nextLine();
            continue;
        }

        option = input.nextInt();
        input.nextLine(); // Clear the input line

        switch (option) {
            case 1:
                System.out.print("How many messages would you like to enter? ");

                if (!input.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    input.nextLine();
                    break;
                }

                int numberOfMessages = input.nextInt();
                input.nextLine();

                if (numberOfMessages <= 0) {
                    System.out.println("Please enter a number greater than zero.");
                } else {
                    System.out.println("You have selected "
                            + numberOfMessages + " message(s).");
                    // We will add the message-sending loop here next.
                }
                break;

            case 2:
                System.out.println("Coming Soon.");
                break;

            case 3:
                System.out.println("Goodbye!");
                break;

            default:
                System.out.println("Invalid option. Please choose 1, 2, or 3.");
        }
    }
}
       }
       
       //Store messages that have been sent
       static Message[] sentMessages = new Message[100];
       
       //Stores message save for later
       static Message[] storeMessages = new Message[100];
       
       //counts how many messages are in each array
       static int sentCount = 0;
       static int storedCount = 0;
}