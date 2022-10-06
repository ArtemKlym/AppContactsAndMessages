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
        }
    }
}
