package fr.kabiro.lol.ism.core.remote.match.dto;

import java.util.Collections;
import java.util.List;

public class MatchDto {
    public int seasonId;
    public int queueId;
    public long gameId;
    public List<ParticipantIdentityDto> participantIdentities = Collections.emptyList();
    public String gameVersion;
    public String platformId;
    public String gameMode;
    public int mapId;
    public String gameType;
    public List<TeamStatsDto> teams = Collections.emptyList();
    public List<ParticipantDto> participants = Collections.emptyList();
    public long gameDuration;
    public long gameCreation;
}
