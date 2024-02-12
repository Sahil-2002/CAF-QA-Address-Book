import java.sql.SQLOutput;
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
                for (int i = 0; i < book.size(); i++) {
                        System.out.println(book.get(i));
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








    }






}