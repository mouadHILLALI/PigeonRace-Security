package com.PigeonSkyRace.PigeonSkyRace.controller;

import com.PigeonSkyRace.PigeonSkyRace.dto.GpsPointDto;
import com.PigeonSkyRace.PigeonSkyRace.model.PigeonResults;
import com.PigeonSkyRace.PigeonSkyRace.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.PigeonSkyRace.PigeonSkyRace.dto.CompetitionDto;
import com.PigeonSkyRace.PigeonSkyRace.model.Competition;
import com.PigeonSkyRace.PigeonSkyRace.service.CompetitionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api(value = "Competition API", description = "Operations related to competitions")
@RestController
@RequestMapping("/api/competitions")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @ApiOperation(value = "Create a new competition", notes = "Provide competition details to create a new competition")
    @PostMapping("/create")
    public Competition createCompetition(@RequestBody CompetitionDto competitionDto) {
        return competitionService.createCompetition(competitionDto);
    }

    @ApiOperation(value = "Close a competition", notes = "Close a competition and provide results")
    @PostMapping("/close")
    public List<Result> closeCompetition(@RequestBody List<PigeonResults> results) {
        return competitionService.closeCompetition(results);
    }

    @ApiOperation(value = "Calculate distance", notes = "Calculate the distance between release and arrival points")
    @PostMapping("/distance")
    public double distance(@RequestBody GpsPointDto gpsPointDto) {
        return competitionService.calcDistance(gpsPointDto.releasePoint(), gpsPointDto.arrivalPoint());
    }

}
