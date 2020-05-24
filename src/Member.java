
public class Member {

    static final int MAX_BORROW_AMOUNT = 10;

    // Member object attributes
    private String username;
    private int password;
    private String residentialAddress;
    private String phoneNumber;
    private Movie[] borrowedMovies; // array of movies borrowed
    private int amountBorrowed; // current amount borrowed

    /*
    Construct Member object
     */
    public Member(String username, int password, String residentialAddress, String phoneNumber){
        this.username = username;
        this.password = password;
        this.residentialAddress = residentialAddress;
        this.phoneNumber = phoneNumber;
        this.borrowedMovies = new Movie[MAX_BORROW_AMOUNT];
        this.amountBorrowed = 0;
    }

    /*
     Getters for Member attributes
     */
    public String getUsername() { return this.username; }
    public int getPassword() { return this.password; }
    public String getResidentialAddress() { return this.residentialAddress; }
    public String getPhoneNumber() { return this.phoneNumber; }
    public Movie[] getBorrowedMovies(){ return this.borrowedMovies; }
    public int getAmountBorrowed() { return this.amountBorrowed; }

    /*
    Borrow movie if passes restrictions (if statements).
     */
    public void borrowMovie(Movie movie){

        // check if copies are available to borrow
        if (movie.getCopiesAvailable() <= 0){
            System.out.println("No available copies to borrow.");
            return;
        }

        // check if amount borrowed exceeds limit
        if (this.amountBorrowed == this.MAX_BORROW_AMOUNT){
            System.out.println("Borrow limit reached!");
            return;
        }

        // check if borrowed
        for (int i = 0; i < this.amountBorrowed; i++){
            if (this.borrowedMovies[i] == movie){
                System.out.println("Movie already borrowed.");
                return;
            }
        }

        // add movie to borrowed movies array +
        // increment and decrement counters
        this.borrowedMovies[this.amountBorrowed] = movie;
        this.amountBorrowed++;
        movie.incBorrowCount();
        movie.decCopiesAvailable();

        System.out.println("Successfully borrowed movie.");

    }


    /*
    Remove movie from borrowed array by shifting right elements to movie's position.
    Return status (true if success)
     */
    public boolean returnMovie(String title){

        for (int i = 0; i < this.amountBorrowed; i++){

            // if borrowed movie found
            if (title.compareTo(this.borrowedMovies[i].getTitle()) == 0){
                // shift remaining movies in array one position left
                for (int j = i + 1; j < this.amountBorrowed; j++){
                    this.borrowedMovies[j-1] = this.borrowedMovies[j];
                }
                this.amountBorrowed--;
                return true;
            }
        }

        // if made it here, movie has not been borrowed
        return false;
    }

}
