package fr.kabiro.lol.ism.core.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Build {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String json;

    @ManyToOne(fetch = FetchType.LAZY)
    private Summoner summoner;

    @ManyToMany
    private Set<Champion> champions = new HashSet<>();

    public Build(){}

    private Build(Builder builder){
        this.id = builder.id;
        this.json = builder.json;
        this.summoner = builder.summoner;
        this.champions = builder.champions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public Summoner getSummoner() {
        return summoner;
    }

    public void setSummoner(Summoner summoner) {
        this.summoner = summoner;
    }

    public Set<Champion> getChampions() {
        return champions;
    }

    public void setChampions(Set<Champion> champions) {
        this.champions = champions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Build build = (Build) o;
        return Objects.equals(id, build.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder{
        private Long id;
        private String json;
        private Summoner summoner;
        private Set<Champion> champions = new HashSet<>();

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder json(String json){
            this.json = json;
            return this;
        }

        public Builder summoner(Summoner summoner){
            this.summoner = summoner;
            return this;
        }

        public Builder champions(Set<Champion> champions) {
            if (champions != null) {
                this.champions = champions;
            }
            return this;
        }

        public Build build(){
            return new Build(this);
        }
    }
}
