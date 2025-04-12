package com.airbnb.airbnb.clone.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "listings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User host;

    private String title;
    private String description;
    private String location;
    private Double pricePerNight;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    private Boolean available = true;

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Listing listing = (Listing) o;
        return Objects.equals(id, listing.id) && Objects.equals(host, listing.host) && Objects.equals(title, listing.title) && Objects.equals(description, listing.description) && Objects.equals(location, listing.location) && Objects.equals(pricePerNight, listing.pricePerNight) && Objects.equals(createdAt, listing.createdAt) && Objects.equals(available, listing.available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, host, title, description, location, pricePerNight, createdAt, available);
    }
}
