import java.util.ArrayList;
import java.util.List;

public class Member {

    static final int MAX_BORROW_AMOUNT = 10;

    private String username;
    private String password;
    private String residentialAddress;
    private Integer phoneNumber;
    private List<Movie> borrowedMovies;


    public Member(String username, String password, String residentialAddress, Integer phoneNumber){
        this.username = username;
        this.password = password;
        this.residentialAddress = residentialAddress;
        this.phoneNumber = phoneNumber;
        this.borrowedMovies = new ArrayList<Movie>();
    }

    public String getUsername() { return this.username; }
    public String getPassword() { return this.password; }
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
