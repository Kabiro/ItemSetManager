package fr.kabiro.lol.ism.core.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Summoner {

    @Id
    private Long riotId;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Region region;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Build> builds = new ArrayList<>();

    public Summoner(){}

    private Summoner(Builder builder){
        this.riotId = builder.riotId;
        this.name = builder.name;
        this.region = builder.region;
        this.builds = builder.builds;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder{
        private Long riotId;
        private String name;
        private Region region;
        private List<Build> builds = new ArrayList<>();

        public Builder riotId(Long riotId){
            this.riotId = riotId;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder region(Region region){
            this.region = region;
            return this;
        }

        public Builder builds(List<Build> builds){
            if (builds != null){
                this.builds = builds;
            }
            return this;
        }

        public Summoner build(){
            return new Summoner(this);
        }
    }
}
