/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrationandloginfeature;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class MessageTests {
    @Test
public void testSentMessageArrayPopulation() {

    // Reset the message arrays
    RegistrationAndLoginFeature.sentMessages = new Message[100];
    RegistrationAndLoginFeature.sentCount = 0;

    // Create a test message
    Message testMessage = new Message(
            1, "+27834557896", "Hello tonight");

    // Send the message
    String result = testMessage.SentMessage(1);

    // Check the results
    assertEquals("Message successfully sent.", result);

    assertEquals(1, RegistrationAndLoginFeature.sentCount);

    assertEquals(testMessage,
            RegistrationAndLoginFeature.sentMessages[0]);

    assertEquals(testMessage.getMessageID(),
            RegistrationAndLoginFeature.messageIDs[0]);

    assertEquals(testMessage.getMessageHash(),
            RegistrationAndLoginFeature.messageHashes[0]);
}

@Test
public void testLongestMessage() {

    // Reset stored messages
    RegistrationAndLoginFeature.storeMessages = new Message[100];
    RegistrationAndLoginFeature.storedCount = 0;

    // Create three messages
    Message message1 = new Message(
            1, "+27834557896", "Hi");

    Message message2 = new Message(
            2, "+27834557896", "This is the longest message");

    Message message3 = new Message(
            3, "+27834557896", "Hello");

    // Store the messages
    message1.SentMessage(3);
    message2.SentMessage(3);
    message3.SentMessage(3);

    // Find the longest message
    Message longest = RegistrationAndLoginFeature.storeMessages[0];

    for (int i = 1; i < RegistrationAndLoginFeature.storedCount; i++) {

        if (RegistrationAndLoginFeature.storeMessages[i].getMessage().length()
                > longest.getMessage().length()) {

            longest = RegistrationAndLoginFeature.storeMessages[i];
        }
    }

    assertEquals("This is the longest message", longest.getMessage());
}
    @Test
public void testSearchMessageByID() {

    // Reset sent messages
    RegistrationAndLoginFeature.sentMessages = new Message[100];
    RegistrationAndLoginFeature.sentCount = 0;

    // Create and send a message
    Message testMessage = new Message(
            1, "+27834557896", "Hello tonight");

    testMessage.SentMessage(1);

    // Check that the message can be found
    assertEquals(
            testMessage,
            RegistrationAndLoginFeature.sentMessages[0]);

    assertEquals(
            testMessage.getMessageID(),
            RegistrationAndLoginFeature.sentMessages[0].getMessageID());
}

@Test
public void testSearchMessagesByRecipient() {

    // Reset sent messages
    RegistrationAndLoginFeature.sentMessages = new Message[100];
    RegistrationAndLoginFeature.sentCount = 0;

    // Create and send a message
    Message testMessage = new Message(
            1, "+27834557896", "Hello tonight");

    testMessage.SentMessage(1);

    // Check the recipient
    assertEquals(
            "+27834557896",
            RegistrationAndLoginFeature.sentMessages[0].getRecipient());
}

@Test
public void testDeleteMessageByHash() {

    // Reset sent messages
    RegistrationAndLoginFeature.sentMessages = new Message[100];
    RegistrationAndLoginFeature.sentCount = 0;

    // Create and send a message
    Message testMessage = new Message(
            1, "+27834557896", "Hello tonight");

    testMessage.SentMessage(1);

    // Get the message hash
    String hash = testMessage.getMessageHash();

    // Delete the message
    RegistrationAndLoginFeature.deleteMessageByHash(hash);

    // Check that the message was deleted
    assertEquals(0, RegistrationAndLoginFeature.sentCount);

    assertNull(RegistrationAndLoginFeature.sentMessages[0]);
}

@Test
public void testDisplayMessageReport() {

    // Reset sent messages
    RegistrationAndLoginFeature.sentMessages = new Message[100];
    RegistrationAndLoginFeature.sentCount = 0;

    // Create and send a message
    Message testMessage = new Message(
            1, "+27834557896", "Hello tonight");

    testMessage.SentMessage(1);

    // Check that the report displays without errors
    assertDoesNotThrow(() ->
            RegistrationAndLoginFeature.displayMessageReport());
}
}
