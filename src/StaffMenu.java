import java.util.Scanner;

public class StaffMenu {

    MovieCollection movieCollection;
    MemberCollection memberCollection;


    public void AddNewMovie(){

        System.out.println("Movie title:");
        Scanner scan = new Scanner(System.in);
        String title = scan.nextLine();

        System.out.println("Starring:");
        scan = new Scanner(System.in);
        String starring = scan.nextLine();

        System.out.println("Director:");
        scan = new Scanner(System.in);
        String director = scan.nextLine();

        System.out.println("Duration:");
        scan = new Scanner(System.in);
        String duration = scan.nextLine();

        System.out.println("Genre:");
        scan = new Scanner(System.in);
        String genre = scan.nextLine();

        System.out.println("Classification:");
        scan = new Scanner(System.in);
        String classification = scan.nextLine();

        System.out.println("Release Date:");
        scan = new Scanner(System.in);
        String releaseDate = scan.nextLine();

        System.out.println("Copies available:");
        scan = new Scanner(System.in);
        int copiesAvailable = scan.nextInt();

        Movie newMovie = new Movie(title,starring,director,duration,genre,classification,releaseDate,copiesAvailable);

        this.movieCollection.addMovie(newMovie);

        System.out.println("Movie added to library.");

    }

    public void RemoveMovie(){
        System.out.println("Title of movie to delete:");
        Scanner scan = new Scanner(System.in);
        String title = scan.nextLine();

        this.movieCollection.removeMovie(title);

    }

    public void RegisterMember(){


        System.out.println("Surname:");
        Scanner scan = new Scanner(System.in);
        String surname = scan.nextLine();

        System.out.println("Given Name:");
        scan = new Scanner(System.in);
        String givenName = scan.nextLine();

        String username = surname + givenName;

        System.out.println("Residential Address:");
        scan = new Scanner(System.in);
        String residentialAddress = scan.nextLine();

        System.out.println("Contact Number:");
        scan = new Scanner(System.in);
        String phoneNumber = scan.nextLine();

        System.out.println("New password for member (4 digit integer):");
        scan = new Scanner(System.in);
        // ensure user provides a 4 digit integer:
        int password = 0;
        while (scan.hasNext()){
            if (scan.hasNextInt()){
                password =  scan.nextInt();
                if (String.valueOf(password).length() == 4){ break; }
                else { scan = new Scanner(System.in); }
            }
            else { scan.next(); }
            System.out.println("Password needs to be a 4 digit integer.");
        }

        Member newMember = new Member(username, password, residentialAddress, phoneNumber);
        memberCollection.addMember(newMember);

    }

    public void FindMemberPhoneNumber(){

        System.out.println("Enter username of Member:");
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();

        Member member = memberCollection.getMember(username);

        if (member != null){
            System.out.println("Member's phone number: " + member.getPhoneNumber());
        }
        else {
            System.out.println("Member with username '" + username + "' does not exist.");
        }

    }

    public void View() {

        System.out.println(
                "============Staff Menu===========\n" +
                "1. Add a new movie DVD\n" +
                "2. Remove a movie DVD\n" +
                "3. Register a new Member\n" +
                "4. Find a registered member's phone number\n" +
                "0. Return to main menu\n" +
                "=================================\n" +
                "Please make a selection(1-4 or 0 to return to main menu):");

        int option = -1;
        try {
            Scanner scan = new Scanner(System.in);
            option = scan.nextInt();
        } catch (Exception e){}

        switch (option){
            case 0:
                return;
            case 1:
                AddNewMovie();
                break;
            case 2:
                RemoveMovie();
                break;
            case 3:
                RegisterMember();
                break;
            case 4:
                FindMemberPhoneNumber();
                break;
            default:
                System.out.println("Invalid option, try again.");
                break;
        }
        View();

    }

    public StaffMenu(MovieCollection movieCollection, MemberCollection memberCollection){
        this.movieCollection = movieCollection;
        this.memberCollection = memberCollection;
    }


}
