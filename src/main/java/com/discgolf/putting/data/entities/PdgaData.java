package com.discgolf.putting.data.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "pdgaNumber",
                column = @Column(name = "pdga_number", unique = true)
        ),
        @AttributeOverride(
                name = "rating",
                column = @Column(name = "rating")
        )
})
public class PdgaData {
    private Integer pdgaNumber;
    private Integer rating;
}
