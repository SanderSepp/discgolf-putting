package com.discgolf.putting.controllers;

import com.discgolf.putting.data.entities.PuttingGame;
import com.discgolf.putting.data.entities.PuttingRound;
import com.discgolf.putting.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/games")
public class GameController {
    private final GameService gameService;

    @GetMapping()
    public List<PuttingGame> getAllGames() {
        return gameService.getAllGames();
    }

    @PostMapping()
    public PuttingGame createGame() {
        return gameService.createGame();
    }

    @GetMapping(value = "/{gameId}/rounds")
    public List<PuttingRound> getAllGameRounds(@PathVariable Long gameId) {
        return gameService.getAllGameRounds(gameId);
    }

    @PostMapping(value = "/{gameId}/rounds")
    public PuttingRound insertRound(@PathVariable Long gameId) {
        return gameService.insertRound(gameId);
    }
}
