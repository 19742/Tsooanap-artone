/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tsooanapartone;
import java.util.Random;
import java.util.regex.Pattern;
/**
 *
 * @author tmoko
 */
public class Message {
     // Variables to store message information
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;
    private String messageStatus;

    // Constructor to initialise a message
    public Message(String messageID, int messageNumber,
                   String recipient, String messageText) {

        this.messageID = messageID;
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageStatus = "Pending";
    }

    // Generates a random 10-digit message ID
    public static String generateMessageID() {
        Random random = new Random();
        long id = 1000000000L
                + (long) (random.nextDouble() * 9000000000L);

        return String.valueOf(id);
    }

    // Checks whether the message ID contains exactly 10 digits
    public boolean checkMessageID() {
        return messageID != null
                && messageID.matches("[0-9]{10}");
    }

    // Checks whether the recipient's cellphone number is valid
    public boolean checkRecipientCell() {
        String phoneRegex = "^\\+27[0-9]{9}$";

        return recipient != null
                && Pattern.matches(phoneRegex, recipient);
    }

    
    // Checks whether the message is within the allowed length
    public boolean checkMessage() {
        return messageText != null
                && !messageText.trim().isEmpty()
                && messageText.length() <= 250;
    }

    
    // Creates the hash for a message
    public String createMessageHash() {

        String[] words = messageText.trim().split("\\s+");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        String firstTwoDigits = messageID.substring(0, 2);

        messageHash = firstTwoDigits + ":"
                + messageNumber + ":"
                + firstWord + ":"
                + lastWord;

        return messageHash;
    }

    
    // Marks a message as sent
    public String SentMessage() {
        messageStatus = "Sent";
        return "Message successfully sent.";
    }

    // Marks a message as disregarded
    public void DisregardMessage() {
        messageStatus = "Disregarded";
    }

    // Marks a message as stored
    public void StoreMessage() {
        messageStatus = "Stored";
    }

    // Returns the current message status
    public String getMessageStatus() {
        return messageStatus;
    }

    public String getMessageID() {
    return messageID;
}

public String getRecipient() {
    return recipient;
}

public String getMessageText() {
    return messageText;
}
    
}
