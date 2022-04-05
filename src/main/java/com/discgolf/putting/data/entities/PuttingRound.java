package com.discgolf.putting.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity(name = "PuttingRound")
@Table(name = "putting_round")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PuttingRound {
    @Id
    @SequenceGenerator(name = "putting_round_sequence", sequenceName = "putting_round_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "putting_round_sequence")
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "made_putts", nullable = false)
    private Integer madePutts;
    @Column(name = "missed_putts", nullable = false)
    private Integer missedPutts;
    @Column(name = "total_putts", nullable = false)
    private Integer totalPutts;
    @Column(name = "distance", nullable = false)
    private Double distance;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private PuttingGame puttingGame;
}
