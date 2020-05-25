
public class Movie {

    // Movie object attributes
    private String title;
    private String starring;
    private String director;
    private String duration;
    private String genre;
    private String classification;
    private String releaseDate;
    private int copiesAvailable;
    private int borrowedCount;

    /*
    Construct Movie object
     */
    public Movie(String title,
                 String starring,
                 String director,
                 String duration,
                 String genre,
                 String classification,
                 String releaseDate,
                 int copiesAvailable){

        this.title = title;
        this.starring = starring;
        this.director = director;
        this.duration = duration;
        this.genre = genre;
        this.classification = classification;
        this.releaseDate = releaseDate;
        this.copiesAvailable = copiesAvailable;
        this.borrowedCount = 0;

    }

    /*
    Getters for Movie attributes
     */
    public String getTitle() { return this.title; }
    public String getStarring() { return this.starring; }
    public String getDirector() { return this.director; }
    public String getDuration() { return this.duration; }
    public String getGenre() { return this.genre; }
    public String getClassification() { return this.classification; }
    public String getReleaseDate() { return this.releaseDate; }
    public int getCopiesAvailable() { return this.copiesAvailable; }
    public int getCopiesBorrowed() { return this.borrowedCount; }

    /*
    Print the Movie object's attributes
     */
    public void printMovieDesc() {

        String genre = "";
        switch (this.genre){
            case "1": genre = "Drama";
                break;
            case "2": genre = "Adventure";
                break;
            case "3": genre = "Family";
                break;
            case "4": genre = "Action";
                break;
            case "5": genre = "Sci-Fi";
                break;
            case "6": genre = "Comedy";
                break;
            case "7": genre = "Animated";
                break;
            case "8": genre = "Thriller";
                break;
            default: genre = "Other";
                break;
        }

        String classification = "";
        switch (this.classification){
            case "1": classification = "General (G)";
                break;
            case "2": classification = "Parental Guidance (PG)";
                break;
            case "3": classification = "Mature (M15+)";
                break;
            case "4": classification = "Mature Accompanied (MA15+)";
                break;
            default: classification = "Other";
                break;
        }

        System.out.println("Title: " + this.title + " | " +
            "Starring: " + this.starring + " | " +
            "Director: " + this.director + " | " +
            "Duration: " + this.duration + " | " +
            "Genre: " + genre + " | " +
            "Classification: " + classification + " | " +
            "Release Date: " + this.releaseDate + " | " +
            "Copies Available: " + this.copiesAvailable + "\n");
    }

    /*
    Decrement and increment counters
     */
    public void incBorrowCount() { this.borrowedCount++; }
    public void incCopiesAvailable() { this.copiesAvailable++; }
    public void decCopiesAvailable() { this.copiesAvailable--; }

}
