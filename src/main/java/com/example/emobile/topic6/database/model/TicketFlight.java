package com.example.emobile.topic6.database.model;

import com.example.emobile.topic6.database.model.enums.FareConditions;
import com.example.emobile.topic6.database.model.id.TicketFlightId;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@Table(name = "ticket_flights", schema = "bookings")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TicketFlight extends BaseEntity {

    @EmbeddedId
    private TicketFlightId id;

    @MapsId("ticket")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_no", referencedColumnName = "ticket_no")
    private Ticket ticket;

    @MapsId("flight")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", referencedColumnName = "flight_id")
    private Flight flight;

    @Column(name = "fare_conditions")
    @NotNull
    @Enumerated(EnumType.STRING)
    private FareConditions fareConditions;

    @Column(name = "amount", precision = 10, scale = 2)
    @Digits(integer = 8, fraction = 2)
    @NotNull
    @PositiveOrZero
    private BigDecimal amount;
}