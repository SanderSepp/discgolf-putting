package com.discgolf.putting.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "PuttingGame")
@Table(name = "putting_game")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PuttingGame {
    @Id
    @SequenceGenerator(name = "putting_game_sequence", sequenceName = "putting_game_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "putting_game_sequence")
    @Column(name = "game_id", updatable = false)
    private Long id;
    @Column(name = "game_name", columnDefinition = "TEXT", nullable = false)
    private String name;
    @JsonManagedReference
    @OneToMany(mappedBy = "puttingGame")
    private List<PuttingRound> rounds;
}
