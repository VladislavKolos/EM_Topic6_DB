package com.example.emobile.topic6.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "airports", schema = "bookings")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Airport extends BaseEntity {

    @Id
    @Column(name = "airport_code")
    @NotBlank
    private String airportCode;

    @Column(name = "airport_name")
    @NotBlank
    private String airportName;

    @Column(name = "city")
    @NotBlank
    private String city;

    @Column(name = "longitude")
    @NotNull
    private Double longitude;

    @Column(name = "latitude")
    @NotNull
    private Double latitude;

    @Column(name = "timezone")
    @NotBlank
    private String timezone;
}