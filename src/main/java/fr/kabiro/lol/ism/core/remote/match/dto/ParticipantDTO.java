package fr.kabiro.lol.ism.core.remote.match.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParticipantDTO {
    private Integer championId;
    private String highestAchievedSeasonTier;
    private List<MasteryDTO> masteries;
    private Integer participantId;
    private List<RuneDTO> runes;
    private Integer spell1Id;
    private Integer spell2Id;
    private ParticipantStatsDTO stats;
    private Integer teamId;
    private ParticipantTimelineDTO timeline;

    public Integer getChampionId() {
        return championId;
    }

    public void setChampionId(Integer championId) {
        this.championId = championId;
    }

    public String getHighestAchievedSeasonTier() {
        return highestAchievedSeasonTier;
    }

    public void setHighestAchievedSeasonTier(String highestAchievedSeasonTier) {
        this.highestAchievedSeasonTier = highestAchievedSeasonTier;
    }

    public List<MasteryDTO> getMasteries() {
        return masteries;
    }

    public void setMasteries(List<MasteryDTO> masteries) {
        this.masteries = masteries;
    }

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public List<RuneDTO> getRunes() {
        return runes;
    }

    public void setRunes(List<RuneDTO> runes) {
        this.runes = runes;
    }

    public Integer getSpell1Id() {
        return spell1Id;
    }

    public void setSpell1Id(Integer spell1Id) {
        this.spell1Id = spell1Id;
    }

    public Integer getSpell2Id() {
        return spell2Id;
    }

    public void setSpell2Id(Integer spell2Id) {
        this.spell2Id = spell2Id;
    }

    public ParticipantStatsDTO getStats() {
        return stats;
    }

    public void setStats(ParticipantStatsDTO stats) {
        this.stats = stats;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public ParticipantTimelineDTO getTimeline() {
        return timeline;
    }

    public void setTimeline(ParticipantTimelineDTO timeline) {
        this.timeline = timeline;
    }

}
