public class MovieCollection {

    private MovieBST movieCollection;

    public MovieCollection(){
        this.movieCollection = new MovieBST();
    }

    public Movie getMovie(String title) { return this.movieCollection.getMovie(title); }

    public void displayMovies() { this.movieCollection.inorderPrintMovies(); }

    public void addMovie(Movie movie) { this.movieCollection.addMovie(movie); }

    public void removeMovie(String title) { this.movieCollection.removeMovie(title); }




}
