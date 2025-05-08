package com.example.emobile.topic6.database.model;

import com.example.emobile.topic6.database.model.enums.FareConditions;
import com.example.emobile.topic6.database.model.id.SeatId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "seats", schema = "bookings")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Seat extends BaseEntity {

    @EmbeddedId
    private SeatId id;

    @MapsId("aircraft")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aircraft_code", referencedColumnName = "aircraft_code")
    private Aircraft aircraft;

    @Column(name = "fare_conditions")
    @NotNull
    @Enumerated(EnumType.STRING)
    private FareConditions fareConditions;
}