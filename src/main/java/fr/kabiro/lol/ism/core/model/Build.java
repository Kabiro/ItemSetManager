package fr.kabiro.lol.ism.core.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Build {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String json;

    @ManyToOne(fetch = FetchType.LAZY)
    private Summoner summoner;

    public Build(){}

    private Build(Builder builder){
        this.id = builder.id;
        this.json = builder.json;
        this.summoner = builder.summoner;
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

        public Build build(){
            return new Build(this);
        }
    }
}
