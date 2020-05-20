public class MovieCollection {

    private MovieBST moveCollection;

    public MovieCollection(){
        this.moveCollection = new MovieBST();
    }

    public void addMovie(Movie movie) { moveCollection.addMovie(movie); }


}
