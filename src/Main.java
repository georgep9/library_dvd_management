import java.util.Scanner;

public class Main {

    /*
    Movie and Member collection instances
     */
    private static MemberCollection memberCollection;
    private static MovieCollection movieCollection;

    /*
    Staff Menu object
     */
    private static StaffMenu staffMenu;

    /*
    Constant staff username & password
     */
    private static final String staffUsername = "staff";
    private static final String staffPassword = "today123";

    /*
    Login prompt for Staff Menu
     */
    public static void StaffLogin() {

        System.out.println("Username:");
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();

        System.out.println("Password:");
        scan = new Scanner(System.in);
        String password = scan.nextLine();

        // validate credentials
        if (username.equals(staffUsername) && password.equals(staffPassword)){
            staffMenu.View(); // load staff menu
        }
        else {
            System.out.println("Incorrect username or password.");
        }


    }

    /*
    Login prompt for Member Menu
     */
    public static void MemberLogin() {

        System.out.println("Username:");
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();


        Member member = memberCollection.getMember(username);

        // check if member with provided username exists
        if (member == null){
            System.out.println("Member does not exist.");
            return;
        }


        System.out.println("Password:");
        scan = new Scanner(System.in);
        // ensure an integer is provided
        while (!scan.hasNextInt()) {
            System.out.println("Password needs to be an integer.");
            scan.next();
        }
        int password = scan.nextInt();

        // validate password
        if (password == member.getPassword()){
            System.out.println("Successfully logged in.");
            // construct member menu
            MemberMenu memberMenu = new MemberMenu(member, movieCollection);
            memberMenu.View(); // load member menu
        }
        else {
            System.out.println("Incorrect password.");
        }

    }

    /*
    Main Menu display, switch case to run the prompts above.
    Recursively displays menu until input 0 is provided.
     */
    public static void MainMenu() {
        System.out.println(
                "============Main Menu============\n" +
                "1. Staff Login\n" +
                "2. Member Login\n" +
                "0. Exit\n" +
                "=================================\n" +
                "Please make a selection(1-2 or 0 exit):");

        int option = -1;
        try {
            Scanner scan = new Scanner(System.in);
            option = scan.nextInt();
        } catch (Exception e){}


        switch (option){
            case 0:
                System.out.println("Goodbye!");
                System.exit(0);
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

    /*
    Main entry point for program
     */
    public static void main(String[] args) {

        /*
        Construct collections
         */
        memberCollection = new MemberCollection();
        movieCollection = new MovieCollection();

        /*
        Construct Staff menu
         */
        staffMenu = new StaffMenu(movieCollection, memberCollection);

        System.out.println("Welcome to the Community Library");
        MainMenu(); // load main menu

    }
}
