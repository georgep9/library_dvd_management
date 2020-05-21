import java.util.Date;

public class Movie {

    private String title;
    private String starring;
    private String director;
    private String duration;
    private String genre;
    private String classification;
    private String releaseDate;
    private int copiesAvailable;
    private int borrowedCount;

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

    public String getTitle() { return this.title; }
    public String getStarring() { return this.starring; }
    public String getDirector() { return this.director; }
    public String getDuration() { return this.duration; }
    public String getGenre() { return this.genre; }
    public String getClassification() { return this.classification; }
    public String getReleaseDate() { return this.releaseDate; }
    public int getCopiesAvailable() { return this.copiesAvailable; }
    public int getCopiesBorrowed() { return this.borrowedCount; }

    public void printMovieDesc() {
        System.out.println("Title: " + this.title + " | " +
            "Starring: " + this.starring + " | " +
            "Director: " + this.director + " | " +
            "Duration: " + this.duration + " | " +
            "Genre: " + this.genre + " | " +
            "Classification: " + this.classification + " | " +
            "Release Date: " + this.releaseDate + " | " +
            "Copies Available: " + this.copiesAvailable + "\n");
    }

    public void incBorrowCount() { this.borrowedCount++; }
    public void incCopiesAvailable() { this.copiesAvailable++; }
    public void decCopiesAvailable() { this.copiesAvailable--; }

}
