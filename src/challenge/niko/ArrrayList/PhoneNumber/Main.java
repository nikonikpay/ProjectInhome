package challenge.niko.ArrrayList.PhoneNumber;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("065094025");


    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printAction();


        while (!quit) {
            System.out.println("\n Enter action ( 6 to available action)");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("\n shutting down");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContact();
                    break;
                case 2:
                    addNewContact();
                    break;

                case 3:
                    updateContact();
                    break;

                case 4:
                    removeContact();
                    break;

                case 5:
                    queryContact();
                    break;

                case 6:
                    printAction();
                    break;

            }


        }


    }

    private static void startPhone() {
        System.out.println("Start phone ...");

    }

    private static void printAction() {
        System.out.println("Available action :\n press");
        System.out.println(" 0 -  to Shut Down\n" +
                " 1 - To print contact \n " +
                " 2 - To add new contact\n" +
                " 3 - To update an existing contact\n" +
                " 4 - To remove an existing Contact\n" +
                " 5 - Query if an existing contact exist\n" +
                " 6 - To print a lit of available contact\n"

        );

        System.out.println("Choose your action");


    }


    private static void addNewContact() {
        System.out.println("enter new contact name ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number");
        String phoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phoneNumber);

        if (mobilePhone.addNewContacts(newContact)) {
            System.out.println(" new contact added " + name + " phone is : " + phoneNumber);

        } else {
            System.out.println("Can not add " + name + " is already on file");

        }


    }

    private static void updateContact() {
        System.out.println(" enter an existing contact ");
        String name = scanner.nextLine();

        Contact existingContact = mobilePhone.queryContact(name);

        if (existingContact == null) {
            System.out.println(" Contact not found");
            return;

        }
        System.out.println("Enter new contact");
        String newName = scanner.nextLine();
        System.out.println(" Enter new phone Number");
        String newPhone = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newPhone);
        if (mobilePhone.updateContact(existingContact, newContact)) {
            System.out.println(" Successfully updated record");


        } else {
            System.out.println(" error updating record");
        }

    }

    private static void removeContact() {
        System.out.println(" enter an existing contact ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);

        if (existingContact == null) {
            System.out.println(" Contact not found");
            return;

        }

        if (mobilePhone.removeContact(existingContact)) {
            System.out.println(" Successfully Delete record");

        } else {
            System.out.println(" error deleting record");
        }


    }

    private static void queryContact() {
        System.out.println(" enter an existing contact ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);

        if (existingContact == null) {
            System.out.println(" Contact not found");
            return;

        }

        System.out.println(" name is :" + existingContact.getName() + "phone number is :" + existingContact.getPhoneNumber());


    }

}