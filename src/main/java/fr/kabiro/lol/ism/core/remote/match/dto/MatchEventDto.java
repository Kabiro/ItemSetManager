package fr.kabiro.lol.ism.core.remote.match.dto;

import java.util.Collections;
import java.util.List;

public class MatchEventDto {
//    public String eventType;
    public String towerType;
    public int teamId;
    public String ascendedType;
    public int killerId;
    public String levelUpType;
    public String pointCaptured;
    public List<Integer> assistingParticipantIds = Collections.emptyList();
    public String wardType;
    public String monsterType;
    public MatchEventType type;
    public int skillSlot;
    public int victimId;
    public long timestamp;
    public int afterId;
    public String monsterSubType;
    public String laneType;
    public int itemId;
    public int participantId;
    public String buildingType;
    public int creatorId;
    public MatchPositionDto position;
    public int beforeId;
}
