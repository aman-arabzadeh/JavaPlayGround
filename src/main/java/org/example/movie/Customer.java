package org.example.movie;

import java.util.Objects;

public record Customer(long id, String name, String email) {
    public Customer(long id, String name, String email) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.email = email;
    }
}
