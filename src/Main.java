import java.util.ArrayList;
import java.util.Scanner;

class contacts {
        String First_name, Last_name, City, State, zip, phone, email;

        public contacts(String First_name, String Last_name, String City, String State, String zip, String phone, String email) {
                this.First_name = First_name;
                this.Last_name = Last_name;
                this.City = City;
                this.State = State;
                this.zip = zip;
                this.phone = phone;
                this.email = email;
        }

        public String getFirst_name() {
                return First_name;
        }

        public String getLast_name() {
                return Last_name;
        }

        public String getCity() {
                return City;
        }

        public String getState() {
                return State;
        }

        public String getZip() {
                return zip;
        }

        public String getPhone() {
                return phone;
        }

        public String getEmail() {
                return email;
        }
}

class Adbook {
        ArrayList<contacts> contact = new ArrayList<>();

        public void setContact(contacts contact) {
                this.contact.add(contact);
        }

        public void display() {
                for (contacts c : contact) {
                        System.out.println("Name of person is " + c.getFirst_name() + " " + c.getLast_name());
                        System.out.println("Name of City is " + c.getCity());
                        System.out.println("Name of State is " + c.getState());
                        System.out.println("Zip code is " + c.getZip());
                        System.out.println("phone number is " + c.getPhone());
                        System.out.println("Email id is " + c.getEmail());
                        System.out.println();
                }
        }
}

public class Main {
        public static void main(String[] args) {
                System.out.println("Welcome to address book ");
                Scanner sc = new Scanner(System.in);
                Adbook ad = new Adbook();
                while (true) {
                        System.out.println("enter the first name ");
                        String First_name = sc.next();
                        System.out.println("enter the last name ");
                        String Last_name = sc.next();
                        System.out.println("enter the city  ");
                        String city = sc.next();
                        System.out.println("enter the state ");
                        String state = sc.next();
                        System.out.println("enter the zip ");
                        String zip = sc.next();
                        System.out.println("enter the phone number ");
                        String phone = sc.next();
                        System.out.println("enter the email");
                        String email = sc.next();

                        contacts cd = new contacts(First_name, Last_name, city, state, zip, phone, email);
                        ad.setContact(cd);

                        System.out.println("Do you want to add more contacts? (yes/no) ");
                        String choice = sc.next();
                        if (!choice.equalsIgnoreCase("yes")) {
                                break;
                        }
                }
                ad.display();
                sc.close();
        }
}
