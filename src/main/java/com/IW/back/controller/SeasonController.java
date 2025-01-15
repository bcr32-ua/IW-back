package com.IW.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.IW.back.model.Season;
import com.IW.back.repository.SeasonRepository;

@RestController
@RequestMapping("/season")
public class SeasonController {

    @Autowired
    private SeasonRepository seasonRepository;

    @GetMapping
    public List<Season> getAllSeasons(){
        return seasonRepository.findAll();
    }

    @PostMapping
    public Season createSeason(@RequestBody Season season){ return seasonRepository.save(season); }

    @PutMapping
    public Season updateSeason(@RequestBody Season season){
        return seasonRepository.save(season);
    }

    @DeleteMapping("/{id}")
    public void deleteSeason(@PathVariable Long id){
        seasonRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Season getSeasonById(@PathVariable Long id){
        return seasonRepository.findById(id).orElse(null);
    }

    @GetMapping("/date")
    public Season getSeasonByDate(@RequestParam(value = "date", required = true) String date){

        try {
            Date parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);

            return seasonRepository.findByDate(parsedDate);
        } catch (ParseException e) {
            return null;
        }
    }

}

