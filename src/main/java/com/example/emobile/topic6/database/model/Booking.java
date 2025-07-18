package com.example.emobile.topic6.database.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "bookings", schema = "bookings")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseEntity {

    @Id
    @Column(name = "book_ref")
    @NotBlank
    private String bookRef;

    @Column(name = "book_date")
    @NotNull
    private ZonedDateTime bookDate;

    @Column(name = "total_amount", precision = 10, scale = 2)
    @Digits(integer = 8, fraction = 2)
    @NotNull
    @PositiveOrZero
    private BigDecimal totalAmount;

    @OneToMany(mappedBy = "booking")
    private List<Ticket> tickets;
}