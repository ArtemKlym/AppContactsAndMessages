package challenge1;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contacts> contacts;
    private static Scanner scanner;
    private static int id = 0;

    public static void main(String[] args){
        contacts = new ArrayList<>();

        showInitialOptions();
    }

    private static void showInitialOptions() {
        System.out.println("1.Manage contacts\n2.Messages\n3.Quit");

        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> manageContacts();
            case 2 -> manageMessages();
        }
    }

    private static void manageMessages() {
        System.out.println("""
                Select one:
                \t1. See the list of all messages
                \t2. Send a new message
                \t3. Go back to the previous menu""");
        int choice = scanner.nextInt();
        switch(choice){
            case 1 -> showListOfMessages();
            case 2 -> sendNewMessage();
            default -> showInitialOptions();
        }
    }

    private static void sendNewMessage() {
        System.out.println("Please enter contact's name");
        String name = scanner.next();

        if(name.equals("") ){
            System.out.println("Please fill in the correct message");
            sendNewMessage();
        }
        else{
            boolean doesExist = false;
            for(Contacts c : contacts){
                if (c.getName().equals(name)) {
                    doesExist = true;
                    break;
                }
            }

            if(doesExist){
                System.out.println("Please enter a new message:");
                String text = scanner.next();

                if(text.equals("")){
                    System.out.println("Please fill in the correct message");
                    sendNewMessage();
                }
                else{
                    id++;
                    Message newMessage = new Message(text,id,name);
                    for(Contacts c : contacts){
                        if(c.getName().equals(name)){
                            ArrayList<Message> newMessages = c.getMessages();
                            newMessages.add(newMessage);
                            c.setMessages((newMessages));
                            contacts.remove(c);
                            contacts.add(c);
                        }
                    }
                }
            }
            else
                System.out.println("There is no such contact");
        }
        manageMessages();
    }

    private static void showListOfMessages() {
        ArrayList<Message> allMessages = new ArrayList<>();
        System.out.println("List of Messages");
        for(Contacts c : contacts)
            allMessages.addAll(c.getMessages());

        if(allMessages.size()>0){
            for(Message m : allMessages) {
                m.getDetails();
                System.out.println("************");
            }
        }
        else
            System.out.println("You don't have any messages");
        manageMessages();
    }

    private static void manageContacts() {
        System.out.println("""
                Select one:
                \t1. Show all contacts
                \t2. Add a new contact
                \t3. Search for a contact
                \t4. Delete a contact
                \t5. Go back""");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> showAllContacts();
            case 2 -> addNewContact();
            case 3 -> searchForContact();
            case 4 -> deleteContact();
            default -> showInitialOptions();
        }
    }

    private static void deleteContact() {
        System.out.println("Enter the contact's name:");
        String name = scanner.next();

        if(name.equals("")){
            System.out.println("Please enter the name");
            deleteContact();
        }
        else{
            boolean doesExits = false;

            for(Contacts con: contacts){
                 if(con.getName().equals(name)){
                     doesExits = true;
                     contacts.remove(con);
                 }
            }
            if(!doesExits)
                System.out.println("There is no such contact");
        }
        showInitialOptions();
    }

    private static void searchForContact() {
        System.out.println("Enter the contact name");
        String name = scanner.next();
        if(name.equals("")){
            System.out.println("Please enter the name");
            searchForContact();
        }
        else{
            boolean doesExist = false;
            for(Contacts con:contacts){
                if(con.getName().equals(name)){
                    doesExist = true;
                    con.getDetails();
                }
            }
            if(!doesExist)
                System.out.println("There is no such contact in your phone");
        }

        showInitialOptions();
    }

    private static void addNewContact() {
        System.out.println("Adding a new contact..."+
                "\nEnter the contact's name");
        String name = scanner.next();
        System.out.println("Enter the contact's number");
        String number = scanner.next();
        System.out.println("Enter the contact's email");
        String email = scanner.next();

        if(name.equals("")||number.equals("")||email.equals("")){
            System.out.println("Please enter all of the information");
            addNewContact();
        }
        else{
            boolean doesExist = false;
            for(Contacts c : contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;
                    break;
                }
            }

            if(!doesExist) {
                Contacts contact = new Contacts(name, number, email);
                contacts.add(contact);
                System.out.println(name + " added successfully");
            }
            else {
                System.out.println("We have a contact named " + name + " saved on this device");
                addNewContact();
            }
        }
        showInitialOptions();
    }

    private static void showAllContacts() {
        for(Contacts con : contacts)
            con.getDetails();
        showInitialOptions();
    }


}
