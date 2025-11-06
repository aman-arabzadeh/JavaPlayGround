package org.example.movie;

public class Main {
    public static void main(String[] args) {
        var customer = new Customer(23L, "Mona Lisa", "mona.lisa@yahoo.com");

        var movieInterstellar = new Movie.Builder()
                .id(1L)
                .title("Interstellar")
                .releaseYear(2014)
                .durationMinutes(169)
                .genre(Genre.SCIENCE_FICTION)
                .rating(8.7)
                .director("Christopher Nolan")
                .description("A team of explorers")
                .addCast("Matthew McConaughey")
                .build();

        var movieShawshank = new Movie.Builder()
                .id(2L)
                .title("The Shawshank Redemption")
                .releaseYear(1994)
                .durationMinutes(142)
                .description("Break from prison")
                .genre(Genre.DRAMA)
                .rating(9.3)
                .director("Frank Darabont")
                .addCast("Tim Robbins")
                .addCast("Morgan Freeman")
                .build();

        var movieGodfather = new Movie.Builder()
                .id(3L)
                .title("The Godfather")
                .description("family")
                .releaseYear(1972)
                .durationMinutes(175)
                .genre(Genre.CRIME)
                .rating(9.2)
                .director("Francis Ford Coppola")
                .addCast("Marlon Brando")
                .addCast("Al Pacino")
                .build();

        var movieInception = new Movie.Builder()
                .id(4L)
                .title("Inception")
                .description("Dreams")
                .releaseYear(2010)
                .durationMinutes(148)
                .genre(Genre.SCIENCE_FICTION)
                .rating(8.8)
                .director("Christopher Nolan")
                .addCast("Leonardo DiCaprio")
                .addCast("Tom Hardy")
                .build();
    }
}
