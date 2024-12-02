package com.PigeonSkyRace.PigeonSkyRace.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;

@Data
@AllArgsConstructor
@Document("results")
public class Result {
    @DBRef
    private String pigeon;
    private double distance;
    private Duration flightTime;
    private double speed;
    private double adjustmentCoefficient;
    private double points;


    public Result() {

    }

    public Result(String pigeon, double distance, double v, double speed, double v1, double points) {

    }
}