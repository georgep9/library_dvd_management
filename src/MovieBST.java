

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



}
