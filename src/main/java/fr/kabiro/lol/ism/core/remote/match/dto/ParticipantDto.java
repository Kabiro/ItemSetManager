package fr.kabiro.lol.ism.core.remote.match.dto;

import java.util.Collections;
import java.util.List;

public class ParticipantDto {
    public ParticipantStatsDto stats;	
    public int participantId;	
    public List<RuneDto> runes;
    public ParticipantTimelineDto timeline;
    public int teamId;	
    public int spell2Id;	
    public List<MasteryDto> masteries = Collections.emptyList();
    public String highestAchievedSeasonTier;	
    public int spell1Id;	
    public int championId;	
}
