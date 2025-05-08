package com.example.emobile.topic6.database.model;

import com.example.emobile.topic6.database.model.id.BoardingPassId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "boarding_passes", schema = "bookings")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BoardingPass extends BaseEntity {

    @EmbeddedId
    private BoardingPassId id;

    @MapsId("ticket")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_no", referencedColumnName = "ticket_no")
    private Ticket ticket;

    @MapsId("flight")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", referencedColumnName = "flight_id")
    private Flight flight;

    @Column(name = "boarding_no")
    @NotNull
    private Integer boardingNo;

    @Size(max = 4)
    @Column(name = "seat_no")
    @NotBlank
    private String seatNo;
}