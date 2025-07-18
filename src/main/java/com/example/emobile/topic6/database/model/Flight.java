package com.example.emobile.topic6.database.model;

import com.example.emobile.topic6.database.model.enums.FlightStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "flights", schema = "bookings")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Flight extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Integer flightId;

    @Size(max = 6)
    @Column(name = "flight_no")
    @NotBlank
    private String flightNo;

    @Column(name = "scheduled_departure")
    @NotNull
    private ZonedDateTime scheduledDeparture;

    @Column(name = "scheduled_arrival")
    @NotNull
    private ZonedDateTime scheduledArrival;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_airport", referencedColumnName = "airport_code")
    @NotNull
    private Airport departureAirport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrival_airport", referencedColumnName = "airport_code")
    @NotNull
    private Airport arrivalAirport;

    @Column(name = "status")
    @NotNull
    @Enumerated(EnumType.STRING)
    private FlightStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aircraft_code", referencedColumnName = "aircraft_code")
    @NotNull
    private Aircraft aircraft;

    @Column(name = "actual_departure")
    private ZonedDateTime actualDeparture;

    @Column(name = "actual_arrival")
    private ZonedDateTime actualArrival;

    @OneToMany(mappedBy = "flight")
    private List<TicketFlight> ticketFlights;

    @OneToMany(mappedBy = "flight")
    private List<BoardingPass> boardingPasses;
}