package fr.kabiro.lol.ism.core.remote.game.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerDTO implements Serializable {
    private int championId;
    private Long riotId;//summonerId
    private int teamId;

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
    }

    public Long getRiotId() {
        return riotId;
    }

    public void setRiotId(Long riotId) {
        this.riotId = riotId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}
