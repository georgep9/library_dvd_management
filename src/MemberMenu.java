import java.util.Scanner;

public class MemberMenu {

    MovieCollection movieCollection;

    public void DisplayMovies(){
        movieCollection.displayMovies();
    }

    public void View() {

        System.out.println(
                "===========Member Menu===========\n" +
                "1. Display all movies\n" +
                "2. Borrow a movie DVD\n" +
                "3. Return a movie DVD\n" +
                "4. List current borrowed movie DVDs\n" +
                "5. Display top 10 most popular movies\n" +
                "0. Return to main menu\n" +
                "=================================\n" +
                "Please make a selection(1-5 or 0 to return to main menu):");

        int option = -1;
        try {
            Scanner scan = new Scanner(System.in);
            option = scan.nextInt();
        } catch (Exception e){}

        switch (option){
            case 0:
                return;
            case 1:
                DisplayMovies();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid option, try again.");
                break;
        }
        View();

    }

    public MemberMenu(MovieCollection movieCollection) {
        this.movieCollection = movieCollection;
    }

}
