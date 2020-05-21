

public class MovieBST {

    class Node {
        String key;
        Movie movie;
        Node left, right;
        public Node(Movie movie){
            this.key = movie.getTitle();
            this.movie = movie;
            this.left = this.right = null;
        }
    }

    private Node root;

    MovieBST() {
        this.root = null;
    }

    void addMovie(Movie movie) {
        this.root = insertMoveRec(this.root, movie);
    }

    // Move recursively through nodes to insert movie
    Node insertMoveRec(Node node, Movie movie){

        // if node is empty, add new node
        if (node == null){
            node = new Node(movie);
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

    void removeMovie(String title){ this.root = deleteMovieRec(this.root, title); }

    /* A recursive function to insert a new key in BST */
    Node deleteMovieRec(Node root, String key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)  {
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key.compareTo(root.key) < 0)
            root.left = deleteMovieRec(root.left, key);
        else if (key.compareTo(root.key) > 0)
            root.right = deleteMovieRec(root.right, key);

            // if key is same as root's key, then This is the node
            // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            Node minNodeRight = minNode(root.right);
            root.key = minNodeRight.key;
            root.movie = minNodeRight.movie;

            // Delete the inorder successor
            root.right = deleteMovieRec(root.right, root.key);
        }

        return root;
    }

    Node minNode(Node root){
        if (root.left != null){
            minNode(root.left);
        }
        return root;
    }



    void inorderPrintMovies(){
        inorderPrintMoviesRec(this.root);
    }

    void inorderPrintMoviesRec(Node root){
        if (root != null){

            inorderPrintMoviesRec(root.left);

            System.out.println("Title: " + root.key + " | " +
                    "Starring: " + root.movie.getStarring() + " | " +
                    "Director: " + root.movie.getDirector() + " | " +
                    "Duration: " + root.movie.getDuration() + " | " +
                    "Genre: " + root.movie.getGenre() + " | " +
                    "Classification: " + root.movie.getClassification() + " | " +
                    "Release Date: " + root.movie.getReleaseDate() + " | " +
                    "Copies Available: " + root.movie.getCopiesAvailable() + "\n");

            inorderPrintMoviesRec(root.right);
        }
    }





}
