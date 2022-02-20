package com.discgolf.putting.data.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PuttingGame {

    @Id
    @SequenceGenerator(name = "game_sequence", sequenceName = "game_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_sequence")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private List<PuttingRound> rounds;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "player_game_mapping",
            joinColumns = @JoinColumn(
                    name = "game_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "player_id",
                    referencedColumnName = "id"
            )
    )
    private List<Player> players;

    public void addPlayers(Player player) {
        if (players == null) players = new ArrayList<>();
        players.add(player);
    }
}
