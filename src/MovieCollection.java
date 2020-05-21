public class MovieCollection {

    private MovieBST moveCollection;

    public MovieCollection(){
        this.moveCollection = new MovieBST();
    }

    public void displayMovies() { moveCollection.inorderPrintMovies(); }

    public void addMovie(Movie movie) { moveCollection.addMovie(movie); }

    public void removeMovie(String title) { moveCollection.removeMovie(title); }


}
