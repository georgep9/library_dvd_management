public class MovieCollection {

    private MovieBST movieCollection;

    public MovieCollection(){
        this.movieCollection = new MovieBST();
    }

    public Movie getMovie(String title) { return this.movieCollection.getMovie(title); }

    public void displayMovies() { this.movieCollection.inorderPrintMovies(); }

    public void addMovie(Movie movie) { this.movieCollection.addMovie(movie); }

    public void removeMovie(String title) { this.movieCollection.removeMovie(title); }

    class QuickSort{

        // ALGORITHM Partition(arr[l..r], l, r)
        int partition(Movie arr[], int l, int r)
        {


            Movie p = arr[l];
            int i = l-1;
            int j = r+1;

            while(true){

                do {
                    i++;
                } while (arr[i].getCopiesBorrowed() > p.getCopiesBorrowed());
                do {
                    j--;
                } while (arr[j].getCopiesBorrowed() < p.getCopiesBorrowed());

                if (i >= j){
                    return j;
                }

                Movie temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }

        }

        void sort(Movie arr[], int l, int r){
            if (l < r){
                int s = partition(arr, l, r); // split position
                sort(arr, l, s);
                sort(arr,s+1, r);
            }
        }


    }

    public void displayTop10Borrowed() {

        int length = this.movieCollection.getMoviesCount();

        if (length == 0){
            System.out.println("No movies in the library.");
            return;
        }

        // get array of movies (flatten BST)
        Movie[] movies = this.movieCollection.getArrayMovies();

        QuickSort qs = new QuickSort();
        qs.sort(movies,0,length-1);

        // display top 10
        for (int i = 0; i < 10 && i < length; i++){
            System.out.println((i+1) + ") " + movies[i].getTitle() +
                "\nCopies borrowed: " + movies[i].getCopiesBorrowed() + "\n");
        }


    }




}
