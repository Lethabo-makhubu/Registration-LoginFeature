/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registrationandloginfeature;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class RegistrationAndLoginFeature {
    
              //Store messages that have been sent
       static Message[] sentMessages = new Message[100];
       
       //Stores message save for later
       static Message[] storeMessages = new Message[100];
       
       //counts how many messages are in each array
       static int sentCount = 0;
       static int storedCount = 0;

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
        System.out.println("Total messages sent: " + sentCount);
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
} else if (sentCount + numberOfMessages > sentMessages.length) {
    System.out.println("You cannot store that many messages.");
} else {

    for (int i = 0; i < numberOfMessages; i++) {

        System.out.println("\nMessage " + (i + 1));

String recipient;
String recipientResult;
String messageText;
Message newMessage;

do {
    System.out.print("Enter recipient cellphone number: ");
    recipient = input.nextLine();

    // Create a temporary message object to validate the number
    newMessage = new Message(sentCount + 1, recipient, "");

    // Check the recipient number
    recipientResult = newMessage.checkRecipientCell();

    System.out.println("Validation result: " + recipientResult);

    if (!recipientResult.equals("Cell phone number successfully captured.")) {
        System.out.println("Invalid recipient number. Please try again.");
    }

} while (!recipientResult.equals("Cell phone number successfully captured."));

System.out.print("Enter your message: ");
messageText = input.nextLine();

// Create the final message object
newMessage = new Message(sentCount + 1, recipient, messageText);


        // Check the message length
String lengthResult = newMessage.checkMessageLength();
System.out.println(lengthResult);

if (!lengthResult.equals("Message ready to send.")) {
    continue;
}

        // Ask what the user wants to do with the message

        System.out.println("\nChoose an action:");

        System.out.println("1. Send message");

        System.out.println("2. Disregard message");

        System.out.println("3. Store message for later");

        System.out.print("Enter your choice: ");

        if (!input.hasNextInt()) {

            System.out.println("Please enter a valid number.");

            input.nextLine();

            continue;

        }

        int action = input.nextInt();

        input.nextLine();

       
String result = newMessage.SentMessage(action);

System.out.println(result);


if (action == 1 && result.equals("Message successfully sent.")) {

    System.out.println("Message ID: " + newMessage.getMessageID());

    System.out.println("Message Hash: " + newMessage.getMessageHash());

    System.out.println("Recipient: " + newMessage.getRecipient());

    System.out.println("Message: " + newMessage.getMessage());

}

    } // Ends the for loop

} // Ends the else block

break;

case 2:

    printMessages();

    break;

} // Ends switch(option)
    }
        }
       }
       
public static void printMessages() {

    if (sentCount == 0) {
        System.out.println("No messages have been sent yet.");
        return;
    }

    System.out.println("\n========== SENT MESSAGES ==========");

    for (int i = 0; i < sentCount; i++) {

        Message msg = sentMessages[i];

        System.out.println("\nMessage " + (i + 1));
        System.out.println("Message ID: " + msg.getMessageID());
        System.out.println("Message Hash: " + msg.getMessageHash());
        System.out.println("Recipient: " + msg.getRecipient());
        System.out.println("Message: " + msg.getMessage());
    }

Message messageCounter = new Message(0, "", "");

System.out.println("Total messages sent: "
        + messageCounter.returnTotalMessages());
}

       public static void saveStoredMessagesToJson() {

    try (FileWriter writer = new FileWriter("messages.json")) {

        writer.write("[\n");

        for (int i = 0; i < storedCount; i++) {

            Message msg = storeMessages[i];

            writer.write("  {\n");
            writer.write("    \"messageID\": \"" 
                    + escapeJson(msg.getMessageID()) + "\",\n");
            writer.write("    \"recipient\": \"" 
                    + escapeJson(msg.getRecipient()) + "\",\n");
            writer.write("    \"message\": \"" 
                    + escapeJson(msg.getMessage()) + "\",\n");
            writer.write("    \"messageHash\": \"" 
                    + escapeJson(msg.getMessageHash()) + "\",\n");
            writer.write("    \"messageNumber\": " 
                    + msg.getMessageNumber() + "\n");
            writer.write("  }");

            if (i < storedCount - 1) {
                writer.write(",");
            }

            writer.write("\n");
        }

        writer.write("]\n");

        System.out.println("Messages saved to messages.json.");

    } catch (IOException e) {
        System.out.println("Error saving JSON: " + e.getMessage());
    }
}

public static String escapeJson(String text) {

    if (text == null) {
        return "";
    }

    return text.replace("\\", "\\\\")
               .replace("\"", "\\\"")
               .replace("\n", "\\n")
               .replace("\r", "\\r")
               .replace("\t", "\\t");
}
}
