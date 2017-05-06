package fr.kabiro.lol.ism.core.remote.summoner.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SummonerDTO implements Serializable {
    public int profileIconId;
    public String name;
    public long summonerLevel;
    public long revisionDate;
    public long id;
    public long accountId;
}
