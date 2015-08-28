package fr.kabiro.lol.ism.core.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Summoner {

    @Id
    private Long riotId;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Region region;

    private Integer summonerIcon;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "summoner")
    private List<Build> builds = new ArrayList<>();

    public Summoner() {
    }

    private Summoner(Builder builder) {
        this.riotId = builder.riotId;
        this.name = builder.name;
        this.region = builder.region;
        this.summonerIcon = builder.summonerIcon;
        this.builds = builder.builds;
    }

    public Long getRiotId() {
        return riotId;
    }

    public void setRiotId(Long riotId) {
        this.riotId = riotId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Integer getSummonerIcon() {
        return summonerIcon;
    }

    public void setSummonerIcon(Integer summonerIcon) {
        this.summonerIcon = summonerIcon;
    }

    public List<Build> getBuilds() {
        return builds;
    }

    public void setBuilds(List<Build> builds) {
        this.builds = builds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summoner summoner = (Summoner) o;
        return Objects.equals(riotId, summoner.riotId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(riotId);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long riotId;
        private String name;
        private Region region;
        private Integer summonerIcon;
        private List<Build> builds = new ArrayList<>();

        public Builder riotId(Long riotId) {
            this.riotId = riotId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder region(Region region) {
            this.region = region;
            return this;
        }

        public Builder summonerIcon(Integer summonerIcon){
            this.summonerIcon = summonerIcon;
            return this;
        }

        public Builder builds(List<Build> builds) {
            if (builds != null) {
                this.builds = builds;
            }
            return this;
        }

        public Summoner build() {
            return new Summoner(this);
        }
    }
}
