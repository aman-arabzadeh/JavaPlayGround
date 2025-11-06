package org.example.movie;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Getter
public class Movie implements Comparable<Movie> {

    @EqualsAndHashCode.Include
    private final long id;
    @EqualsAndHashCode.Include
    private final String title;
    @EqualsAndHashCode.Include
    private final int releaseYear;
    @EqualsAndHashCode.Include
    private final String director;
    private final String description;
    private final int durationMinutes;
    private final Genre genre;
    private final double rating;
    private final List<String> cast;

    private Movie(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.releaseYear = builder.releaseYear;
        this.director = builder.director;
        this.description = builder.description;
        this.durationMinutes = builder.durationMinutes;
        this.genre = builder.genre;
        this.rating = builder.rating;
        this.cast = new ArrayList<>(builder.cast);
    }

    @Override
    public int compareTo(Movie other) {
        if (other == null) return 1;
        return Long.compare(this.id, other.id);
    }

    // builder Pattern design
    public static class Builder {
        private long id = System.currentTimeMillis();
        private String title;
        private String description;
        private int releaseYear;
        private int durationMinutes;
        private Genre genre;
        private double rating;
        private String director;
        private final List<String> cast = new ArrayList<>();

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            if (title == null || title.isBlank()) throw new IllegalArgumentException("Title must not be blank");
            this.title = title.trim();
            return this;
        }

        public Builder description(String description) {
            if (description != null && !description.isBlank()) {
                this.description = description.trim();
            }
            return this;
        }

        public Builder releaseYear(int year) {
            int nextYear = LocalDate.now().getYear() + 1;
            if (year < 1900 || year > nextYear)
                throw new IllegalArgumentException("ReleaseYear must be between 1900 and " + nextYear);
            this.releaseYear = year;
            return this;
        }

        public Builder durationMinutes(int minutes) {
            if (minutes < 0) throw new IllegalArgumentException("DurationMinutes must be greater than 0");
            this.durationMinutes = minutes;
            return this;
        }

        public Builder genre(Genre genre) {
            this.genre = genre;
            return this;
        }

        public Builder rating(double rating) {
            if (Double.isNaN(rating) || rating < 0.0 || rating > 10.0)
                throw new IllegalArgumentException("Rating must be between 0.0 and 10.0");
            this.rating = rating;
            return this;
        }

        public Builder director(String director) {
            if (director != null && director.isBlank()) director = null;
            this.director = director;
            return this;
        }

        public Builder addCast(String member) {
            if (member != null && !member.isBlank()) {
                String trimmed = member.trim();
                if (cast.stream().noneMatch(c -> c.equalsIgnoreCase(trimmed))) {
                    cast.add(trimmed);
                }
            }
            return this;
        }

        public Builder cast(List<String> members) {
            cast.clear();
            if (members != null) {
                for(var member : members){
                    addCast(member);
                }
            }
            return this;
        }

        public Movie build() {
            if (title == null) throw new IllegalStateException("Title is required");
            if (releaseYear == 0) throw new IllegalStateException("ReleaseYear is required");
            if (director == null) throw new IllegalStateException("Director is required");
            if (genre == null) throw new IllegalStateException("Genre is required");
            if (durationMinutes == 0) throw new IllegalStateException("DurationMinutes is required");

            return new Movie(this);
        }
    }
}
