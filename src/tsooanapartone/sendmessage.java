/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tsooanapartone;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author tmoko
 */
public class sendmessage {
     private ArrayList<Message> messages = new ArrayList<>();

    public void sendMessages(Scanner input, int numberOfMessages) {

        for (int i = 0; i < numberOfMessages; i++) {

            System.out.println("\nMessage " + (i + 1));

            System.out.print("Enter recipient cellphone number: ");
            String recipient = input.nextLine();

            System.out.print("Enter your message: ");
            String messageText = input.nextLine();

            String messageID = Message.generateMessageID();

            Message message = new Message(
                    messageID, i + 1, recipient, messageText
            );

            if (!message.checkMessageID()) {
                System.out.println("Invalid message ID.");
                i--;
                continue;
            }

            if (!message.checkRecipientCell()) {
                System.out.println("Invalid cellphone number. Please try again.");
                i--;
                continue;
            }

            if (!message.checkMessage()) {
                System.out.println("Message must contain 1 to 250 characters.");
                i--;
                continue;
            }

            message.createMessageHash();

            System.out.println("Message ID: " + messageID);
            System.out.println("Message Hash: " + message.createMessageHash());

            System.out.println("Choose an action:");
            System.out.println("1. Send");
            System.out.println("2. Disregard");
            System.out.println("3. Store");
            System.out.print("Your choice: ");

            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    System.out.println(message.SentMessage());
                    messages.add(message);
                    break;

                case "2":
                    message.DisregardMessage();
                    System.out.println("Message disregarded.");
                    break;

               case "3":
                    message.StoreMessage();
                     messages.add(message);
                     saveMessagesToJson();
                     break;

                default:
                    System.out.println("Invalid choice. Message disregarded.");
                    message.DisregardMessage();
                    break;
            }
        }
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
   
   
public void showRecentlySentMessages() {

    boolean foundSentMessage = false;

    System.out.println("\nRecently sent messages:");

    for (Message message : messages) {
        if ("Sent".equals(message.getMessageStatus())) {

            System.out.println("Message ID: "
                    + message.getMessageID());
            System.out.println("Recipient: "
                    + message.getRecipient());
            System.out.println("Message: "
                    + message.getMessageText());
            System.out.println("Status: "
                    + message.getMessageStatus());
            System.out.println("-------------------------");

            foundSentMessage = true;
        }
    }

    if (!foundSentMessage) {
        System.out.println("No sent messages found.");
    }
}
public void saveMessagesToJson() {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    try (FileWriter writer = new FileWriter(
        System.getProperty("user.home") + "/Documents/messages.json")) {
        gson.toJson(messages, writer);
        System.out.println("Messages saved to messages.json.");
    } catch (IOException e) {
        System.out.println("Error saving messages: " + e.getMessage());
    }
}
}
