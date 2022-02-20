package com.discgolf.putting.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/scores")
public class GameController {

    @GetMapping()
    public String getScores() {
        return "SCORES";
    }

    @PostMapping()
    public String saveScore(@RequestBody String score) {
        return score;
    }
}
