package org.example.movie;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@ToString
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Rental {

    @EqualsAndHashCode.Include
    private final Movie movie;

    @EqualsAndHashCode.Include
    private final Customer customer;

    @EqualsAndHashCode.Include
    private final LocalDate rentalDate;

    private final LocalDate returnDate;
    private final double price;

    public Rental(Movie movie, Customer customer, LocalDate rentalDate, LocalDate returnDate) {
        this.movie = Objects.requireNonNull(movie, "Movie must not be null");
        this.customer = Objects.requireNonNull(customer, "Customer must not be null");
        this.rentalDate = Objects.requireNonNull(rentalDate, "Rental date must not be null");
        this.returnDate = returnDate;
        this.price = calculatePrice(movie);
    }

    public int getDaysRented() {
        if (returnDate == null) {
            return 0;
        }
        return (int) ChronoUnit.DAYS.between(rentalDate, returnDate);
    }

    private double calculatePrice(Movie movie) {
        int days = getDaysRented();
        return switch (movie.getGenre()) {
            case ACTION, ADVENTURE, SCIENCE_FICTION -> days > 7 ? 7.0 : 5.6;
            case DRAMA, ROMANCE, COMEDY, WESTERN, HISTORY, FANTASY, ANIMATION, CRIME, MUSIC, MYSTERY ->
                    days > 7 ? 4.0 : 3.5;
            case CLASSIC -> days > 2 ? 7.0 : 4.6;
            case DOCUMENTARY, FAMILY -> days > 5 ? 7.0 : 4.5;
            case HORROR, THRILLER -> days > 7 ? 6.0 : 4.0;
            case WAR -> days > 7 ? 7.0 : 4.0;
            case OTHER -> 3.0;
        };
    }
}
