package entities;

import java.time.LocalDate;

public class Rent {
    private String renterName;
    private Movie rentedMovie;
    private LocalDate startRentingDate;
    private LocalDate returnDate;

    public Rent() {
    }

    public Rent(String renterName, Movie rentedMovie, LocalDate startRentingDate, LocalDate returnDate) {
        this.renterName = renterName;
        this.rentedMovie = rentedMovie;
        this.startRentingDate = startRentingDate;
        this.returnDate = returnDate;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public Movie getRentedMovie() {
        return rentedMovie;
    }

    public void setRentedMovie(Movie rentedMovie) {
        this.rentedMovie = rentedMovie;
    }

    public LocalDate getStartRentingDate() {
        return startRentingDate;
    }

    public void setStartRentingDate(LocalDate startRentingDate) {
        this.startRentingDate = startRentingDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
