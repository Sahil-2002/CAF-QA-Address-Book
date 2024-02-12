
import java.util.ArrayList;
import java.util.Scanner;

class addressbook{
        String First_name, Last_name, City, State, email, phone,zip;
        ArrayList<String>book = new ArrayList<>();
        public void Getdetails(){
                Scanner sc = new Scanner(System.in);

                System.out.println("Enter your name : ");
                First_name=sc.next();
                book.add(First_name);
                System.out.println("Enter your last name : ");
                Last_name=sc.next();
                book.add(Last_name);
                System.out.println("Enter your City : ");
                City=sc.next();
                book.add(City);
                System.out.println("Enter your State : ");
                State=sc.next();
                book.add(State);
                System.out.println("Enter your zip : ");
                zip=sc.next();
                book.add(zip);
                System.out.println("enter your phone number : ");
                phone=sc.next();
                book.add(phone);
                System.out.println("Enter your Email id : ");
                email=sc.next();
                book.add(email);
        }
        public void display() {
                for (int i =0; i<book.size();i++){
                        System.out.println(book.get(i));}
        }
        public void edit(String name){
                Scanner scanner = new Scanner(System.in);
                boolean contactFound = false;
                for(int i =0; i<book.size(); i=i+7) {
                        if (book.get(i).equalsIgnoreCase(name)) {
                                System.out.println("Contact found. Enter new details:");

                                System.out.println("Enter your last name: ");
                                book.set(i + 1, scanner.next());

                                System.out.println("Enter your City: ");
                                book.set(i + 2, scanner.next());

                                System.out.println("Enter your State: ");
                                book.set(i + 3, scanner.next());

                                System.out.println("Enter your zip: ");
                                book.set(i + 4, scanner.next());

                                System.out.println("Enter your phone number: ");
                                book.set(i + 5, scanner.next());

                                System.out.println("Enter your Email id: ");
                                book.set(i + 6, scanner.next());
                                contactFound = true;
                                break;


                        }


                }
                if (!contactFound) {
                        System.out.println("Contact not found.");
                }

        }
        public void delete(String name1){
                for(int i =0; i<book.size();i=i+7) {
                        if (book.get(i).equalsIgnoreCase(name1))
                        {
                              book.remove(i+6);book.remove(i+5);book.remove(i+4);book.remove(i+3);book.remove(i+2);book.remove(i);

                        }
                }

        }

        }



public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");
addressbook ad = new addressbook();
ad.Getdetails();
            System.out.println("\n");
ad.display();
Scanner sc = new Scanner(System.in);
            System.out.println("enter name you want to edit : ");
            String name = sc.next();
            ad.edit(name);
            System.out.println("updated contact list ");
            ad.display();
            System.out.println("enter name you want to delete ");
            String name1 =sc.next();
            ad.delete(name1);
            System.out.println("after deleting the data ");
            ad.display();








    }






}