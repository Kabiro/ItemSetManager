package fr.kabiro.lol.ism.core.model;

import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = {"riotId"})
public class Summoner {

    @Id
    private String riotId;

    @Column(nullable = false)
    private String accountId;

    @Column(nullable = false)
    private String puuid;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Region region;

    private Integer summonerIcon;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "summoner")
    @Builder.Default
    private Set<Build> builds = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @BatchSize(size = 100)
    @Builder.Default
    private Set<Build> followedBuilds = new HashSet<>();
}
