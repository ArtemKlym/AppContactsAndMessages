package challenge1;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contacts> contacts;
    private static Scanner scanner;

    public static void main(String[] args){
        contacts = new ArrayList<>();


        System.out.println("Hello!");

        showInitialOptions();



    }

    private static void showInitialOptions() {
        System.out.println("1.Manage contacts\n2.Messages\n3.Quit");

        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                manageContacts();
                break;
            case 2:
                manageMessages();
                break;
            default:
                break;
        }
    }

    private static void manageContacts() {
        System.out.println("Select one:"+
                "\n\t1. Show all contacts"+
                "\n\t2. Add a new contact"+
                "\n\t3. Search for a contact"+
                "\n\t4. Delete a contact"+
                "\n\t5. Go back");

        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                showAllContacts();
                break;
            case 2:
                addNewContact();
                break;
            case 3:
                searchForContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                showInitialOptions();
                break;
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

            if(!doesExits) {
                System.out.println("There is no such contact");
            }
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

            if(!doesExist){
                System.out.println("There is no such contact in your phone");
            }
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
            Contacts contact = new Contacts(name,number,email);
            contacts.add(contact);
        }

        showInitialOptions();
    }

    private static void showAllContacts() {
        for(Contacts con : contacts){
            con.getDetails();
        }

        showInitialOptions();
    }


}
