import entities.Movie;
import entities.Rent;
import services.MovieService;
import services.RentService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner read = new Scanner(System.in);
    static MovieService mService = new MovieService();
    static ArrayList<Movie> movieList = new ArrayList<>();
    static ArrayList<Rent> rentList = new ArrayList<>();
    static RentService rService = new RentService();

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an operation");
            System.out.println("1 - See or add movie details");
            System.out.println("2 - See or add rent details");
            System.out.println("0 - Exit");

            int opt = Integer.parseInt(read.nextLine());

            switch (opt) {
                case 1 -> movieMenu();
                case 2 -> rentMenu();
                case 0 -> exit = true;
                default -> System.out.println("Wrong option, please, try again.");
            }
        }
    }

    public static void movieMenu() {
        int opt = 0;

        while (opt != 9) {
            System.out.println("=*=*=*=*=*=*=*=*=MOVIES=*=*=*=*=*=*=*=*=");
            System.out.println("1 - Add Movies");
            System.out.println("2 - List all available movies");
            System.out.println("3 - Search Movie by Title");
            System.out.println("4 - Search Movie by Genre");
            System.out.println("9 - Go back to Main Menu");
            System.out.println("0 - Exit program");

            opt = Integer.parseInt(read.nextLine());

            switch (opt) {
                case 1 -> movieList = mService.createMovie();
                case 2 -> mService.listAvailableMovies(movieList);
                case 3 -> mService.searchMovieByTitle(movieList);
                case 4 -> mService.searchMovieByGenre(movieList);
                default -> System.out.println("Wrong option. Try again.");
                case 9 -> mainMenu();
                case 0 -> System.exit(0);
            }

        }
    }

    public static void rentMenu() {
        int opt = 0;

        while (opt != 9) {
            System.out.println("=*=*=*=*=*=*=*=*=RENTS=*=*=*=*=*=*=*=*=");
            System.out.println("1 - Rent Movies");
            System.out.println("2 - Show all rents");
            System.out.println("3 - Search Rent by date");
            System.out.println("4 - Show all profits from rents");
            System.out.println("9 - Go back to Main Menu");
            System.out.println("0 - Exit program");

            opt = Integer.parseInt(read.nextLine());

            switch (opt) {
                case 1 -> rentList.add(rService.rentMovies(movieList));
                case 2 -> rService.listRents(rentList);
                case 3 -> {//searchRentByDate
                }
                case 4 -> {//showProfits
                }
                default -> System.out.println("Wrong option. Try again.");
                case 9 -> mainMenu();
                case 0 -> System.exit(0);
            }

        }
    }
}