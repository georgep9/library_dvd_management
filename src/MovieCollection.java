public class MovieCollection {

    private MovieBST movieCollection; // BST

    /*
     Construct Movie Collection BST
     */
    public MovieCollection(){
        this.movieCollection = new MovieBST();
    }

    /*
    Movie Collection functions
     */
    public Movie getMovie(String title) { return this.movieCollection.getMovie(title); }
    public void displayMovies() { this.movieCollection.inorderPrintMovies(); }
    public void addMovie(Movie movie) { this.movieCollection.addMovie(movie); }
    public void removeMovie(String title) { this.movieCollection.removeMovie(title); }

    /*
    Class for quicksorting movies
     */
    class QuickSort{

        // ALGORITHM Partition(arr[l..r], l, r)
        int partition(Movie arr[], int l, int r)
        {
            /*
             Partitions a subarray by Hoare's algorithm, using the first element
                as a pivot
             Input: Subarray of array arr[0..n-1], defined by its left and right
                indices l and r (l < r)
             Ouput: Partition of arr[l..r], with the split position returned as
                the function's value
             */

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


        // ALGORITHM quicksort(arr[l..r], l, r)
        void sort(Movie arr[], int l, int r){
            /*
            Sorts a subarray by quicksort
            Input: Subarray of array arr[0..n-1], defined by its left and right
                indices l and r
            Output: Subarray arr[l..r] sort in decreasing order
             */

            if (l < r){
                int s = partition(arr, l, r); // split position
                sort(arr, l, s);
                sort(arr,s+1, r);
            }
        }


    }

    /*
    Print top 10 most borrowed movies
     */
    public void displayTop10Borrowed() {

        // array length
        int length = this.movieCollection.getMoviesCount();

        if (length == 0){
            System.out.println("No movies in the library.");
            return;
        }

        // get array of movies (flatten BST)
        Movie[] movies = this.movieCollection.getArrayMovies();

        // quick sort movies array based on borrowed count
        QuickSort qs = new QuickSort();
        qs.sort(movies,0,length-1);

        // print movies in sorted array up to 10 (or to length)
        for (int i = 0; i < 10 && i < length; i++){
            System.out.println((i+1) + ") " + movies[i].getTitle() +
                "\nCopies borrowed: " + movies[i].getCopiesBorrowed() + "\n");
        }


    }




}
