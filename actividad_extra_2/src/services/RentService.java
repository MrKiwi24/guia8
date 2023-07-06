package services;

import entities.Movie;
import entities.Rent;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class RentService {
    Scanner read = new Scanner(System.in);
    MovieService mService = new MovieService();

    public Rent rentMovies(ArrayList<Movie> movies) {
        Rent rent = new Rent();
        ArrayList<Movie> bufferMovieList = new ArrayList<>();

        System.out.println("Enter your name: ");
        rent.setRenterName(read.nextLine());

        System.out.println("=*=*=*=*=LIST OF AVAILABLE MOVIES*=*=*=*=");
        mService.listAvailableMovies(movies);
        System.out.println("-----------------------------------------");
        System.out.println("Enter the movie codes to select a movie for rent");
        System.out.println("When you're done, press 'Q' to exit.");
        System.out.println("-----------------------------------------");

        String opt = read.nextLine();

        while (!opt.equalsIgnoreCase("Q")) {
            int i = Integer.parseInt(opt);

            if (movies.get(i).isRented() == false) {
                System.out.println(movies.get(i).getTitle() + " has been added to your rent list!");
                movies.get(i).setRented(true);
                bufferMovieList.add(movies.get(i));
            } else {
                System.out.println("The code is incorrect or the movie is not available!");
                System.out.println("Please, try again.");
            }
            opt = read.nextLine();
        }

        rent.setRentedMovies(bufferMovieList);
        LocalDate now = LocalDate.now();
        rent.getStartRentingDate(now);

        return rent;
    }
    public void listRents(ArrayList<Rent> rentList){
        System.out.println("-----------------------------------------");
        System.out.println("=*=*=*=*=*=*=*=*=RESULTS=*=*=*=*=*=*=*=*=");

        for(int i = 0; i < rentList.size(); i++){
            System.out.println("- Rent Code-|-----------Renter Name------");
            System.out.println("\t"+i +"\t\t| " + rentList.get(i).getRenterName());
            System.out.println("--------------RENTED MOVIE(S)------------");
            for(int j = 0 ; j < rentList.get(i).getRentedMovies().size(); j++){
                System.out.println("=> "+ rentList.get(i).getRentedMovies().get(j).getTitle());
            }
            System.out.println("-----------------------------------------");
        }
    }
}