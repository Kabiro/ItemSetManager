package fr.kabiro.lol.ism.core.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class Build {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String json;

    @ManyToOne(fetch = FetchType.LAZY)
    private Summoner summoner;

    @ManyToMany
    @Builder.Default
    private Set<Champion> champions = new HashSet<>();
}
