import java.util.ArrayList;
import java.util.List;

public class Member {

    static final int MAX_BORROW_AMOUNT = 10;

    private String fullName;
    private int password;
    private String residentialAddress;
    private int phoneNumber;
    private List<Movie> borrowedMovies;


    public Member(String fullName, String residentialAddress, int phoneNumber, int password){
        this.fullName = fullName;
        this.password = password;
        this.residentialAddress = residentialAddress;
        this.phoneNumber = phoneNumber;
        this.borrowedMovies = new ArrayList<Movie>();
    }

    public String getFullName() { return this.fullName; }
    public int getPassword() { return this.password; }
    public String getResidentialAddress() { return this.residentialAddress; }
    public int getPhoneNumber() { return this.phoneNumber; }
    public List<Movie> getBorrowedMovies(){ return this.borrowedMovies; }

    public Boolean addMovieBorrow(Movie movie){
        if (this.borrowedMovies.size() < MAX_BORROW_AMOUNT && !this.borrowedMovies.contains(movie)){
            this.borrowedMovies.add(movie);
            return true;
        }
        return false;
    }

}
