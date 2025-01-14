package com.IW.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
}

