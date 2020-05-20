import java.util.Scanner;

public class Main {

    private static MemberCollection memberCollection;

    private static final String staffUsername = "staff";
    private static final String staffPassword = "today123";

    public static void StaffLogin() {

        System.out.println("Username:");
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();

        System.out.println("Password:");
        scan = new Scanner(System.in);
        String password = scan.nextLine();

        if (username.equals(staffUsername) && password.equals(staffPassword)){
            StaffMenu();
        }
        else {
            System.out.println("Incorrect username or password.");
            MainMenu();
        }

    }

    public static void StaffMenu() {
        System.out.println(
            "============Staff Menu===========\n" +
            "1. Add a new movie DVD\n" +
            "2. Remove a movie DVD\n" +
            "3. Register a new Member\n" +
            "4. Find a registered member's phone number\n" +
            "0. Return to main menu\n" +
            "=================================\n" +
            "Please make a selection(1-4 or 0 to return to main menu):");
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        System.out.println(i);

    }

    public static void MemberLogin() {

        System.out.println("Username:");
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();

        System.out.println("Password:");
        scan = new Scanner(System.in);
        String password = scan.nextLine();

        if (memberCollection.authenticateMember(username, password)){
            MemberMenu();
        }
        else {
            System.out.println("Incorrect username or password.");
            MainMenu();
        }

    }

    public static void MemberMenu() {

        System.out.println(
            "===========Member Menu===========\n" +
            "1. Display all movies\n" +
            "2. Borrow a movie DVD\n" +
            "3. Return a movie DVD\n" +
            "4. List current borrowed movie DVDs\n" +
            "5. Display top 10 most popular movies\n" +
            "0. Return to main menu" +
            "=================================\n" +
            "Please make a selection(1-5 or 0 to return to main menu):");
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        System.out.println(i);

    }



    public static void MainMenu() {
        System.out.println(
                "============Main Menu============\n" +
                "1. Staff Login\n" +
                "2. Member Login\n" +
                "0. Exit\n" +
                "=================================\n" +
                "Please make a selection(1-2 or 0 exit):");

        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();

        switch (option){
            case 0:
                System.out.println("Goodbye!");
                break;
            case 1:
                StaffLogin();
                break;
            case 2:
                MemberLogin();
                break;
            default:
                System.out.println("Invalid option, try again.");
                MainMenu();
                break;

        }
    }

    public static void main(String[] args) {
        memberCollection = new MemberCollection();

        System.out.println("Welcome to the Community Library");
        MainMenu();
    }
}
