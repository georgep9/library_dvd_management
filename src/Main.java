import java.util.Scanner;

public class Main {

    public static void MemberMenu() {

    }

    public static void StaffMenu() {
        System.out.println(
                "============Staff Menu===========\n" +
                "1. Add a new movie DVD\n" +
                "2. Remove a movie DVD\n" +
                "3. Register a new Member\n" +
                "4. Find a registered member's phone number\n" +
                "0. Return to main menu\n" +
                "=================================\n");
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        System.out.println(i);

    }

    public static void MainMenu() {
        System.out.println(
                "Welcome to the Community Library\n" +
                "============Main Menu============\n" +
                "1. Staff Login\n" +
                "2. Member Login\n" +
                "0. Exit\n" +
                "=================================\n" +
                "Please make a selection(1-2 or 0 exit):");
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        System.out.println(i);
    }

    public static void main(String[] args) {
        MainMenu();
    }
}
