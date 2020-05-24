import java.lang.reflect.Array;

public class MovieBST {

    private Movie arrayMovies[]; // for flattening BST
    private int arrayMoviesIndex; // for indexing

    private int moviesCount; // count of BST nodes

    /*
    Class for creating node
     */
    private class Node {
        String key;
        Movie movie;
        Node left, right;
        public Node(Movie movie){
            this.key = movie.getTitle();
            this.movie = movie;
            this.left = this.right = null;
        }
    }

    private Node root; // root

    /*
    Construct BST
     */
    public MovieBST() {
        this.root = null;
        this.moviesCount = 0;
    }

    /*
    Add movie node
     */
    public void addMovie(Movie movie) {
        this.root = insertMoveRec(this.root, movie);
    }

    /*
     Move recursively through nodes to insert movie
     */
    private Node insertMoveRec(Node node, Movie movie){

        // if node is empty, add new node
        if (node == null){
            node = new Node(movie);
            this.moviesCount++;
            return node;
        }

        // move down to left subtree if movie is smaller than node key
        // else, move down to right subtree
        if (movie.getTitle().compareTo(node.key) < 0){
            node.left = insertMoveRec(node.left, movie);
        }
        else if (movie.getTitle().compareTo(node.key) > 0){
            node.right = insertMoveRec(node.right, movie);
        }

        return node; // tree unchanged

    }

    /*
    Delete movie node
     */
    public void removeMovie(String title){
        this.moviesCount--; // dec. count
        this.root = deleteMovieRec(this.root, title);
    }

    /*
     Move recursively through nodes to delete movie
     */
    private Node deleteMovieRec(Node root, String key)
    {
        // base Case: If the tree is empty
        if (root == null)  {
            this.moviesCount++; // correct the count
            return root;
        }

        // recur down the tree
        if (key.compareTo(root.key) < 0)
            root.left = deleteMovieRec(root.left, key);
        else if (key.compareTo(root.key) > 0)
            root.right = deleteMovieRec(root.right, key);

        // if key is same as root's key, then this is the node
        // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children:
            // get inorder successor to replace node
            Node minNodeRight = minNode(root.right);
            root.key = minNodeRight.key;
            root.movie = minNodeRight.movie;

            // delete the inorder successor
            root.right = deleteMovieRec(root.right, root.key);
        }

        return root;
    }

    /*
    Recursively get the inorder successor (smallest in right subtree)
     */
    private Node minNode(Node root){
        if (root.left != null){
            minNode(root.left);
        }
        return root;
    }

    /*
    Print movie description of all nodes
     */
    public void inorderPrintMovies(){
        inorderPrintMoviesRec(this.root);
    }

    /*
    Move recursively (inorder) through nodes and print
    movie description on the way
     */
    private void inorderPrintMoviesRec(Node root){
        if (root != null){

            inorderPrintMoviesRec(root.left);

            root.movie.printMovieDesc();

            inorderPrintMoviesRec(root.right);
        }
    }

    /*
    Get movie from BST by searching for nodes.
    Null if node with given movie title does not exist
     */
    public Movie getMovie(String title){
        return inorderSearchMovieRec(this.root, title);
    }

    /*
    Move recursively (inorder) through nodes until node with
    movie title is found
     */
    private Movie inorderSearchMovieRec(Node root, String title){

        // not found
        if (root == null){
            return null;
        }

        // movie found
        if (title.compareTo(root.key) == 0){
            return root.movie;
        }
        // else, move down left or right trees
        else if (title.compareTo(root.key) < 0){
            return inorderSearchMovieRec(root.left, title);
        }
        else if (title.compareTo(root.key) > 0){
            return inorderSearchMovieRec(root.right, title);
        }

        return null;

    }

    /*
    Flatten BST
     */
    public Movie[] getArrayMovies(){
        this.arrayMovies = new Movie[this.moviesCount]; // new array to populate
        this.arrayMoviesIndex = 0;
        this.flattenMovies(this.root);
        return this.arrayMovies;
    }

    /*
    Recursively move through nodes and add them to array
     */
    public void flattenMovies(Node root){
        if (root != null){

            flattenMovies(root.left);

            // add to array and increment index
            this.arrayMovies[arrayMoviesIndex] = root.movie;
            arrayMoviesIndex++;

            flattenMovies(root.right);
        }
    }


    /*
    Getter for movies count (used as size for movies array)
     */
    public int getMoviesCount(){
        return this.moviesCount;
    }






}
