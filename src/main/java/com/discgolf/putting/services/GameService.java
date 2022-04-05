package com.discgolf.putting.services;

import com.discgolf.putting.data.entities.Player;
import com.discgolf.putting.data.entities.PuttingGame;
import com.discgolf.putting.data.entities.PuttingRound;
import com.discgolf.putting.repositories.PlayerRepository;
import com.discgolf.putting.repositories.PuttingGameRepository;
import com.discgolf.putting.repositories.PuttingRoundRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameService {
    private final PuttingGameRepository gameRepository;
    private final PuttingRoundRepository roundRepository;
    private final PlayerRepository playerRepository;

    public List<PuttingGame> getAllGames() {
        return gameRepository.findAll();
    }

    public PuttingGame createGame() {
        var newGame = new PuttingGame();
        newGame.setName("5-10 meters");
        return gameRepository.save(newGame);
    }

    public List<PuttingRound> getAllGameRounds(Long gameId) {
        return gameRepository.getById(gameId).getRounds();
    }

    public PuttingRound insertRound(Long gameId) {
        Player player = playerRepository.findById(1L).get();
        PuttingGame game = gameRepository.findById(gameId).get();

        var round = new PuttingRound();
        round.setDistance(10.0);
        round.setMadePutts(5);
        round.setMissedPutts(0);
        round.setTotalPutts(5);
        round.setPlayer(player);
        round.setPuttingGame(game);
        return roundRepository.save(round);
    }
}
