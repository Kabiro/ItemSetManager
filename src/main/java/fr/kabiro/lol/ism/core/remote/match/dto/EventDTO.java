package fr.kabiro.lol.ism.core.remote.match.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDTO {
    private AscendedTypeDTO ascendedType;
    private List<Integer> assistingParticipantIds;
    private BuildingTypeDTO buildingType;
    private Integer creatorId;
    private EventTypeDTO eventType;
    private Integer itemAfter;
    private Integer itemBefore;
    private Integer itemId;
    private Integer killerId;
    private LaneTypeDTO laneType;
    private LevelUpTypeDTO levelUpType;
    private MonsterTypeDTO monsterType;
    private Integer participantId;
    private PointCapturedDTO poIntegerCaptured;
    private PositionDTO position;
    private Integer skillSlot;
    private Integer teamId;
    private Long timestamp;
    private TowerTypeDTO towerType;
    private Integer victimId;
    private WardTypeDTO wardType;

    public AscendedTypeDTO getAscendedType() {
        return ascendedType;
    }

    public void setAscendedType(AscendedTypeDTO ascendedType) {
        this.ascendedType = ascendedType;
    }

    public List<Integer> getAssistingParticipantIds() {
        return assistingParticipantIds;
    }

    public void setAssistingParticipantIds(List<Integer> assistingParticipantIds) {
        this.assistingParticipantIds = assistingParticipantIds;
    }

    public BuildingTypeDTO getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingTypeDTO buildingType) {
        this.buildingType = buildingType;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public EventTypeDTO getEventType() {
        return eventType;
    }

    public void setEventType(EventTypeDTO eventType) {
        this.eventType = eventType;
    }

    public Integer getItemAfter() {
        return itemAfter;
    }

    public void setItemAfter(Integer itemAfter) {
        this.itemAfter = itemAfter;
    }

    public Integer getItemBefore() {
        return itemBefore;
    }

    public void setItemBefore(Integer itemBefore) {
        this.itemBefore = itemBefore;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getKillerId() {
        return killerId;
    }

    public void setKillerId(Integer killerId) {
        this.killerId = killerId;
    }

    public LaneTypeDTO getLaneType() {
        return laneType;
    }

    public void setLaneType(LaneTypeDTO laneType) {
        this.laneType = laneType;
    }

    public LevelUpTypeDTO getLevelUpType() {
        return levelUpType;
    }

    public void setLevelUpType(LevelUpTypeDTO levelUpType) {
        this.levelUpType = levelUpType;
    }

    public MonsterTypeDTO getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(MonsterTypeDTO monsterType) {
        this.monsterType = monsterType;
    }

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public PointCapturedDTO getPoIntegerCaptured() {
        return poIntegerCaptured;
    }

    public void setPoIntegerCaptured(PointCapturedDTO poIntegerCaptured) {
        this.poIntegerCaptured = poIntegerCaptured;
    }

    public PositionDTO getPosition() {
        return position;
    }

    public void setPosition(PositionDTO position) {
        this.position = position;
    }

    public Integer getSkillSlot() {
        return skillSlot;
    }

    public void setSkillSlot(Integer skillSlot) {
        this.skillSlot = skillSlot;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public TowerTypeDTO getTowerType() {
        return towerType;
    }

    public void setTowerType(TowerTypeDTO towerType) {
        this.towerType = towerType;
    }

    public Integer getVictimId() {
        return victimId;
    }

    public void setVictimId(Integer victimId) {
        this.victimId = victimId;
    }

    public WardTypeDTO getWardType() {
        return wardType;
    }

    public void setWardType(WardTypeDTO wardType) {
        this.wardType = wardType;
    }

}
