package com.airbnb.airbnb.clone.domain.entities;

import com.airbnb.airbnb.clone.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "bookings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Listing listing;

    @ManyToOne
    private User guest;

    private LocalDate startDate;
    private LocalDate endDate;
    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) && Objects.equals(listing, booking.listing) && Objects.equals(guest, booking.guest) && Objects.equals(startDate, booking.startDate) && Objects.equals(endDate, booking.endDate) && Objects.equals(totalPrice, booking.totalPrice) && status == booking.status && Objects.equals(createdAt, booking.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, listing, guest, startDate, endDate, totalPrice, status, createdAt);
    }
}

