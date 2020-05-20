import java.util.Scanner;

public class Main {

    private static MemberCollection memberCollection;
    private static MovieCollection movieCollection;

    private static StaffMenu staffMenu;
    private static MemberMenu memberMenu;

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
            staffMenu.View();
        }
        else {
            System.out.println("Incorrect username or password.");
        }
        MainMenu();

    }

    public static void MemberLogin() {

        System.out.println("Username:");
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();

        System.out.println("Password:");
        scan = new Scanner(System.in);
        String password = scan.nextLine();

        if (memberCollection.authenticateMember(username, password)){
            memberMenu.View();
        }
        else {
            System.out.println("Incorrect username or password.");
        }

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
                System.exit(0);
                break;
            case 1:
                StaffLogin();
                break;
            case 2:
                MemberLogin();
                break;
            default:
                System.out.println("Invalid option, try again.");
                break;
        }
        MainMenu();
    }

    public static void main(String[] args) {

        memberCollection = new MemberCollection();
        movieCollection = new MovieCollection();

        staffMenu = new StaffMenu(memberCollection);
        memberMenu = new MemberMenu(movieCollection);

        System.out.println("Welcome to the Community Library");
        MainMenu();
    }
}
