package fr.kabiro.lol.ism.core.remote.game.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameDTO implements Serializable {
    private int championId;
    private long createDate;
    private List<PlayerDTO> fellowPlayers;
    private long gameId;
    private String gameMode;
    private String gameType;
    private int level;
    private int mapId;
    private int spell1;// summoner spell number one.
    private int spell2;// summoner spell number two.
    private RawStatsDTO stats;
    private String subType;
    private int teamId; // team color: blue id = 100, purple(red) id = 200.

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public List<PlayerDTO> getFellowPlayers() {
        return fellowPlayers;
    }

    public void setFellowPlayers(List<PlayerDTO> fellowPlayers) {
        this.fellowPlayers = fellowPlayers;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public int getSpell1() {
        return spell1;
    }

    public void setSpell1(int spell1) {
        this.spell1 = spell1;
    }

    public int getSpell2() {
        return spell2;
    }

    public void setSpell2(int spell2) {
        this.spell2 = spell2;
    }

    public RawStatsDTO getStats() {
        return stats;
    }

    public void setStats(RawStatsDTO stats) {
        this.stats = stats;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}
