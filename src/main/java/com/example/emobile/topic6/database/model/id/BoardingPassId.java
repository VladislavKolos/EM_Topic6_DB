package com.example.emobile.topic6.database.model.id;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class BoardingPassId implements Serializable {
    private String ticket;
    private Integer flight;
}