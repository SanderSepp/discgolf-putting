package com.discgolf.putting.controllers;

import com.discgolf.putting.data.dtos.PlayerDto;
import com.discgolf.putting.data.entities.Player;
import com.discgolf.putting.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/players")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;

    @GetMapping()
    public List<Player> getAllPlayer() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }

    @PostMapping()
    public Player savePlayer(@RequestBody @Valid PlayerDto playerDto) {
        return playerService.savePlayer(playerDto);
    }
}
