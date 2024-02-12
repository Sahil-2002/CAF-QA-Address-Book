import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");

String First_name, Last_name, City, State, email;
int zip; double phone;

        Scanner sc = new Scanner(System.in);
        System.out.println("We are creating Address book so for that we want following details : ");
        System.out.println("Enter your first name : ");
        First_name=sc.next();
        System.out.println("Enter your last name: ");
        Last_name=sc.next();
        System.out.println("Enter your address city : ");
        City=sc.next();
        System.out.println("Enter your state : ");
        State=sc.next();
        System.out.println("Enter your zip code : ");
        zip=sc.nextInt();
        System.out.println("Enter your phone number : ");
        phone=sc.nextDouble();
        System.out.println("Enter your Email-id");
        email=sc.next();





    }






}