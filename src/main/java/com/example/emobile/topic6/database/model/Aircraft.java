package com.example.emobile.topic6.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "aircrafts", schema = "bookings")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Aircraft extends BaseEntity {

    @Id
    @Column(name = "aircraft_code")
    @NotBlank
    private String aircraftCode;

    @Column(name = "model")
    @NotBlank
    private String model;

    @Column(name = "range")
    @NotNull
    @Positive
    private Integer range;
}