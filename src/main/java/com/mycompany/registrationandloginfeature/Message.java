/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrationandloginfeature;

import java.util.Random;
/**
 *
 * @author Student
 */
public class Message {

    private String messageID;
    private String recipient;
    private String message;
    private String messageHash;
    private int messageNumber;

    // Constructor

    public Message(int messageNumber, String recipient, String message) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;

        // Generate a random 10-digit message ID

        Random random = new Random();

        long id = 1000000000L
        + (long) (random.nextDouble() * 9000000000L);

                

        this.messageID = String.valueOf(id);

        this.messageHash = createMessageHash();

    }

    // Check that the message ID is no more than 10 characters

    public boolean checkMessageID() {

        return messageID != null && messageID.length() <= 10;

    }

    // Check recipient number format

    public String checkRecipientCell() {

        if (recipient != null

                && recipient.matches("^\\+\\d{1,3}\\d{1,10}$")

                && recipient.length() <= 13) {

            return "Cell phone number successfully captured.";

        }

        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";

    }

    // Create the message hash

    public String createMessageHash() {

        if (messageID == null || message == null || message.trim().isEmpty()) {

            return "";

        }

        String[] words = message.trim().split("\\s+");

        String firstWord = words[0];

        String lastWord = words[words.length - 1];

        String firstTwoIDDigits = messageID.substring(0, 2);

        return (firstTwoIDDigits + ":"

                + messageNumber + ":"

                + firstWord + lastWord).toUpperCase();

    }

    // Check message length

    public String checkMessageLength() {

        if (message != null && message.length() <= 250) {

            return "Message ready to send.";

        }

        int length = message == null ? 0 : message.length();

        int excess = Math.max(0, length - 250);

        return "Message exceeds 250 characters by "
                + excess + "; please reduce the size.";

    }

    // Return message ID

    public String getMessageID() {

        return messageID;

    }

    // Return recipient

    public String getRecipient() {

        return recipient;

    }

    // Return message

    public String getMessage() {

        return message;

    }

    // Return message hash

    public String getMessageHash() {

        return messageHash;
    }

    // Return message number

    public int getMessageNumber() {

        return messageNumber;

    }
    
}
