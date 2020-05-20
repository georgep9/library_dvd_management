import java.util.Scanner;

public class MemberMenu {

    MovieCollection movieCollection;

    public void View() {

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

    public MemberMenu(MovieCollection movieCollection) {
        this.movieCollection = movieCollection;
    }

}
