import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Contacts {
    String firstName, lastName, city, state, zip, phone, email;

    public Contacts(String firstName, String lastName, String city, String state, String zip, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj == null || (getClass() != obj.getClass()))) {
            return false;
        }
        Contacts other = (Contacts) obj;
        return firstName.equals(other.firstName);

    }
}

class AddressBook {
    ArrayList<Contacts> contactsList = new ArrayList<>();

    public void addContact(Contacts contact) {
        boolean isDuplicate = contactsList.stream()
                .anyMatch(existingContact -> existingContact.equals(contact));

        if (isDuplicate) {
            System.out.println("Duplicate entry. This contact already exists in the address book.");
        } else {
            contactsList.add(contact);
        }
    }

    public void displayContacts() {
        for (Contacts contact : contactsList) {
            System.out.println("Name: " + contact.firstName + " " + contact.lastName);
            System.out.println("City: " + contact.city);
            System.out.println("State: " + contact.state);
            System.out.println("Zip: " + contact.zip);
            System.out.println("Phone: " + contact.phone);
            System.out.println("Email: " + contact.email);
            System.out.println();
        }
    }

    public List<Contacts> searchByCity(String city) {
        return contactsList.stream()
                .filter(contact -> contact.city.equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<Contacts> searchByState(String state) {
        return contactsList.stream()
                .filter(contact -> contact.state.equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, AddressBook> addressBooks = new HashMap<>();

        while (true) {
            System.out.println("1. Create a new address book");
            System.out.println("2. Add contact to an existing address book");
            System.out.println("3. Display contacts of an address book");
            System.out.println("4. Search contacts by city");
            System.out.println("5. Search contacts by state");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name for the new address book: ");
                    String addressBookName = scanner.next();
                    addressBooks.put(addressBookName, new AddressBook());
                    break;
                case 2:
                    System.out.print("Enter address book name: ");
                    String existingAddressBookName = scanner.next();
                    AddressBook existingAddressBook = addressBooks.get(existingAddressBookName);
                    if (existingAddressBook != null) {
                        System.out.println("Enter contact details:");
                        System.out.print("First Name: ");
                        String firstName = scanner.next();
                        System.out.print("Last Name: ");
                        String lastName = scanner.next();
                        System.out.print("City: ");
                        String city = scanner.next();
                        System.out.print("State: ");
                        String state = scanner.next();
                        System.out.print("Zip: ");
                        String zip = scanner.next();
                        System.out.print("Phone: ");
                        String phone = scanner.next();
                        System.out.print("Email: ");
                        String email = scanner.next();
                        existingAddressBook.addContact(new Contacts(firstName, lastName, city, state, zip, phone, email));
                    } else {
                        System.out.println("Address book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter address book name: ");
                    String displayAddressBookName = scanner.next();
                    AddressBook displayAddressBook = addressBooks.get(displayAddressBookName);
                    if (displayAddressBook != null) {
                        System.out.println("Contacts in address book '" + displayAddressBookName + "':");
                        displayAddressBook.displayContacts();
                    } else {
                        System.out.println("Address book not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter city to search: ");
                    String cityToSearch = scanner.next();
                    searchContactsByCity(addressBooks, cityToSearch);
                    break;
                case 5:
                    System.out.print("Enter state to search: ");
                    String stateToSearch = scanner.next();
                    searchContactsByState(addressBooks, stateToSearch);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void searchContactsByCity(HashMap<String, AddressBook> addressBooks, String city) {
        for (String addressBookName : addressBooks.keySet()) {
            AddressBook addressBook = addressBooks.get(addressBookName);
            List<Contacts> contactsInCity = addressBook.searchByCity(city);
            if (!contactsInCity.isEmpty()) {
                System.out.println("Contacts in city '" + city + "' in address book '" + addressBookName + "':");
                for (Contacts contact : contactsInCity) {
                    System.out.println("Name: " + contact.firstName + " " + contact.lastName);

                    System.out.println();
                }
            }
        }
    }

    private static void searchContactsByState(HashMap<String, AddressBook> addressBooks, String state) {
        for (String addressBookName : addressBooks.keySet()) {
            AddressBook addressBook = addressBooks.get(addressBookName);
            List<Contacts> contactsInState = addressBook.searchByState(state);
            if (!contactsInState.isEmpty()) {
                System.out.println("Contacts in state '" + state + "' in address book '" + addressBookName + "':");
                for (Contacts contact : contactsInState) {
                    System.out.println("Name: " + contact.firstName + " " + contact.lastName);

                    System.out.println();
                }
            }
        }
    }
}
