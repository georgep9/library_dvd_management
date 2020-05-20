import java.util.Scanner;

public class StaffMenu {

    MemberCollection memberCollection;

    public void RegisterMember(){

        System.out.println("Surname:");
        Scanner scan = new Scanner(System.in);
        String surname = scan.nextLine();

        System.out.println("Given Name:");
        scan = new Scanner(System.in);
        String givenName = scan.nextLine();

        String username = surname + givenName;

        System.out.println("Residential Address:");
        scan = new Scanner(System.in);
        String residentialAddress = scan.nextLine();

        System.out.println("Contact Number:");
        scan = new Scanner(System.in);
        String phoneNumber = scan.nextLine();

        System.out.println("New password for member:");
        scan = new Scanner(System.in);
        String password = scan.nextLine();

        Member newMember = new Member(username, password, residentialAddress, phoneNumber);
        memberCollection.addMember(newMember);

        System.out.println("Member registered.");

    }

    public void FindMemberPhoneNumber(){

        System.out.println("Enter username of Member:");
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();

        Member member = memberCollection.getMember(username);

        if (member != null){
            System.out.println("Member's phone number: " + member.getPhoneNumber());
        }
        else {
            System.out.println("Member with username '" + username + "' does not exist.");
        }

    }

    public void View() {

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

        switch (i){
            case 0:
                return;
            case 1:
                break;
            case 2:
                break;
            case 3:
                RegisterMember();
                break;
            case 4:
                FindMemberPhoneNumber();
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
        View();

    }

    public StaffMenu(MemberCollection memberCollection){
        this.memberCollection = memberCollection;
    }


}
