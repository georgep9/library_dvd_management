import java.util.Scanner;

public class MemberMenu {

    Member member; // current member logged on
    MovieCollection movieCollection;

    public void DisplayMovies(){
        this.movieCollection.displayMovies();
    }

    public void BorrowMovie(){

        System.out.println("Title of movie to borrow:");
        Scanner scan = new Scanner(System.in);
        String title = scan.nextLine();

        Movie movie = this.movieCollection.getMovie(title);

        if (movie == null){
            System.out.println("Movie with title '" + title + "' does not exist.");
        }
        else {
            this.member.borrowMovie(movie);
        }

    }

    public void ReturnMovie() {
        System.out.println("Title of movie to return:");
        Scanner scan = new Scanner(System.in);
        String title = scan.nextLine();



        boolean returnStatus = this.member.returnMovie(title);

        if (returnStatus){
            System.out.println("Movie has been returned.");

            Movie movie = this.movieCollection.getMovie(title);
            if (movie != null){
                movie.incCopiesAvailable();
            }

        }
        else {
            System.out.println("This movie has not been borrowed.");
        }
    }




    public void ListBorrowedMovies(){
        Movie[] movies = this.member.getBorrowedMovies();
        for (int i = 0; i < this.member.getAmountBorrowed(); i++){

            movies[i].printMovieDesc();
        }
    }

    public void DisplayTop10Borrowed(){
        this.movieCollection.displayTop10Borrowed();
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
                BorrowMovie();
                break;
            case 3:
                ReturnMovie();
                break;
            case 4:
                ListBorrowedMovies();
                break;
            case 5:
                DisplayTop10Borrowed();
                break;
            default:
                System.out.println("Invalid option, try again.");
                break;
        }

        View();

    }

    public MemberMenu(Member member, MovieCollection movieCollection) {
        this.member = member;
        this.movieCollection = movieCollection;
    }

}
