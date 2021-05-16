package fr.kabiro.lol.ism.core.remote.summoner.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SummonerDTO implements Serializable {
    public String id;
    public String accountId;
    public String puuid;
    public String name;
    public int profileIconId;
    public long revisionDate;
    public long summonerLevel;
}
