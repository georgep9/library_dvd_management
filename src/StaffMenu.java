import java.util.Scanner;

public class StaffMenu {

    MemberCollection memberCollection;

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
        System.out.println(i);

    }

    public StaffMenu(MemberCollection memberCollection){
        this.memberCollection = memberCollection;
    }


}
