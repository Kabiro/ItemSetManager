package fr.kabiro.lol.ism.core.remote.match.dto;

import java.util.Collections;
import java.util.List;

public class TeamStatsDto {
    public boolean firstDragon;	
    public boolean firstInhibitor;	
    public List<TeamBansDto> bans = Collections.emptyList();
    public int baronKills;	
    public boolean firstRiftHerald;	
    public boolean firstBaron;	
    public int riftHeraldKills;	
    public boolean firstBlood;	
    public int teamId;	
    public boolean firstTower;	
    public int vilemawKills;	
    public int inhibitorKills;	
    public int towerKills;	
    public int dominionVictoryScore;	
    public String win;	
    public int dragonKills;	
}
