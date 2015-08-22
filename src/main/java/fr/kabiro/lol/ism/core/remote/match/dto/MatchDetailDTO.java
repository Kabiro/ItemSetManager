package fr.kabiro.lol.ism.core.remote.match.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchDetailDTO {
    private Integer mapId;
    private Long matchCreation;
    private Long matchDuration;
    private Integer matchId;
    private MatchModeDTO matchMode;
    private MatchTypeDTO matchType;
    private String matchVersion;
    private List<ParticipantIdentityDTO> participantIdentities;
    private List<ParticipantDTO> participants;
    private String platformId;
    private QueueTypeDTO queueType;
    private RegionDTO region;
    private SeasonDTO season;
    private List<TeamDTO> teams;
    private TimelineDTO timeline;

    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    public Long getMatchCreation() {
        return matchCreation;
    }

    public void setMatchCreation(Long matchCreation) {
        this.matchCreation = matchCreation;
    }

    public Long getMatchDuration() {
        return matchDuration;
    }

    public void setMatchDuration(Long matchDuration) {
        this.matchDuration = matchDuration;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public MatchModeDTO getMatchMode() {
        return matchMode;
    }

    public void setMatchMode(MatchModeDTO matchMode) {
        this.matchMode = matchMode;
    }

    public MatchTypeDTO getMatchType() {
        return matchType;
    }

    public void setMatchType(MatchTypeDTO matchType) {
        this.matchType = matchType;
    }

    public String getMatchVersion() {
        return matchVersion;
    }

    public void setMatchVersion(String matchVersion) {
        this.matchVersion = matchVersion;
    }

    public List<ParticipantIdentityDTO> getParticipantIdentities() {
        return participantIdentities;
    }

    public void setParticipantIdentities(List<ParticipantIdentityDTO> participantIdentities) {
        this.participantIdentities = participantIdentities;
    }

    public List<ParticipantDTO> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantDTO> participants) {
        this.participants = participants;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public QueueTypeDTO getQueueType() {
        return queueType;
    }

    public void setQueueType(QueueTypeDTO queueType) {
        this.queueType = queueType;
    }

    public RegionDTO getRegion() {
        return region;
    }

    public void setRegion(RegionDTO region) {
        this.region = region;
    }

    public SeasonDTO getSeason() {
        return season;
    }

    public void setSeason(SeasonDTO season) {
        this.season = season;
    }

    public List<TeamDTO> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamDTO> teams) {
        this.teams = teams;
    }

    public TimelineDTO getTimeline() {
        return timeline;
    }

    public void setTimeline(TimelineDTO timeline) {
        this.timeline = timeline;
    }
}
