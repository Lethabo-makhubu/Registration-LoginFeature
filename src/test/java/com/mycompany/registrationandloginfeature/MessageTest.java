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
public class MessageTest {
    
    // Test 1: Message ID is not longer than 10 characters
    @Test
    public void testCheckMessageID() {
        Message msg = new Message(1, "+27829649254", "Hello mom.");
        assertTrue(msg.checkMessageID());
    }

    // Test 2: Message ID is generated
    @Test
    public void testMessageIDNotEmpty() {
        Message msg = new Message(1, "+27829649254", "Hello mom.");
        assertNotNull(msg.getMessageID());
        assertFalse(msg.getMessageID().isEmpty());
    }

    // Test 3: Valid recipient number is accepted
    @Test
    public void testValidRecipientCell() {
        Message msg = new Message(1, "+27829649254", "Hello mom.");
        assertEquals("Cell phone number successfully captured.",
                msg.checkRecipientCell());
    }

    // Test 4: Invalid recipient number is rejected
    @Test
    public void testInvalidRecipientCell() {
        Message msg = new Message(1, "08575975889", "Hello mom.");
        assertTrue(msg.checkRecipientCell()
                .contains("incorrectly formatted"));
    }

    // Test 5: Short message is accepted
    @Test
    public void testShortMessage() {
        Message msg = new Message(1, "+27829649254", "Hello mom.");
        assertEquals("Message ready to send.",
                msg.checkMessageLength());
    }

    // Test 6: Empty message does not exceed the limit
    @Test
    public void testEmptyMessageLength() {
        Message msg = new Message(1, "+27829649254", "");
        assertEquals("Message ready to send.",
                msg.checkMessageLength());
    }

    // Test 7: Message with exactly 250 characters is accepted
    @Test
    public void testMessageAt250Characters() {
        String text = "A".repeat(250);
        Message msg = new Message(1, "+27829649254", text);
        assertEquals("Message ready to send.",
                msg.checkMessageLength());
    }

    // Test 8: Message with 251 characters is rejected
    @Test
    public void testMessageOver250Characters() {
        String text = "A".repeat(251);
        Message msg = new Message(1, "+27829649254", text);
        assertTrue(msg.checkMessageLength()
                .contains("exceeds 250 characters"));
    }

    // Test 9: Message hash is created
    @Test
    public void testMessageHashNotEmpty() {
        Message msg = new Message(1, "+27829649254", "Hello mom.");
        assertNotNull(msg.getMessageHash());
        assertFalse(msg.getMessageHash().isEmpty());
    }

    // Test 10: Message hash uses uppercase letters
    @Test
    public void testMessageHashUppercase() {
        Message msg = new Message(1, "+27829649254", "hello mom.");
        assertEquals(msg.getMessageHash().toUpperCase(),
                msg.getMessageHash());
    }

    // Test 11: Message hash starts with the first two ID digits
    @Test
    public void testMessageHashStartsWithID() {
        Message msg = new Message(1, "+27829649254", "Hello mom.");
        String firstTwoDigits = msg.getMessageID().substring(0, 2);
        assertTrue(msg.getMessageHash().startsWith(firstTwoDigits));
    }

    // Test 12: Message hash remains consistent
    @Test
    public void testMessageHashConsistency() {
        Message msg = new Message(1, "+27829649254", "Hello mom.");
        assertEquals(msg.getMessageHash(), msg.createMessageHash());
    }
}
