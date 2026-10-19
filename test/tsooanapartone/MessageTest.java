/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tsooanapartone;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tmoko
 */
public class MessageTest {
    
    @Test
    public void testMessageIDIsValid() {
        Message message = new Message(
                "1234567890", 1, "+27821234567", "Hello");

        assertTrue(message.checkMessageID());
    }

    @Test
    public void testMessageIDIsInvalid() {
        Message message = new Message(
                "12345", 1, "+27821234567", "Hello");

        assertFalse(message.checkMessageID());
    }

    @Test
    public void testRecipientCellIsValid() {
        Message message = new Message(
                "1234567890", 1, "+27821234567", "Hello");

        assertTrue(message.checkRecipientCell());
    }

    @Test
    public void testRecipientCellIsInvalid() {
        Message message = new Message(
                "1234567890", 1, "0821234567", "Hello");

        assertFalse(message.checkRecipientCell());
    }

    @Test
    public void testMessageWithinLimit() {
        Message message = new Message(
                "1234567890", 1, "+27821234567", "Hello");

        assertTrue(message.checkMessage());
    }

    @Test
    public void testMessageExceedsLimit() {
        String longText = "A".repeat(251);

        Message message = new Message(
                "1234567890", 1, "+27821234567", longText);

        assertFalse(message.checkMessage());
    }

    @Test
    public void testMessageHash() {
        Message message = new Message(
                "4112345678", 1, "+27821234567", "Hello there");

        assertEquals("41:1:HELLO:THERE",
                message.createMessageHash());
    }
    
}
