package com.example.emobile.topic6.database.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "tickets", schema = "bookings")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseEntity {

    @Id
    @Column(name = "ticket_no")
    @NotBlank
    private String ticketNo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_ref", referencedColumnName = "book_ref")
    private Booking booking;

    @Size(min = 20, max = 20)
    @Column(name = "passenger_id")
    @NotBlank
    private String passengerId;

    @Column(name = "passenger_name")
    @NotBlank
    private String passengerName;

    @Column(name = "contact_data")
    private String contactData;

    @OneToMany(mappedBy = "ticket")
    private List<TicketFlight> ticketFlights;
}