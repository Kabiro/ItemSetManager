package fr.kabiro.lol.ism.core.remote.match.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParticipantTimelineDTO {
    private ParticipantTimelineDataDTO ancientGolemAssistsPerMinCounts;
    private ParticipantTimelineDataDTO ancientGolemKillsPerMinCounts;
    private ParticipantTimelineDataDTO assistedLaneDeathsPerMinDeltas;
    private ParticipantTimelineDataDTO assistedLaneKillsPerMinDeltas;
    private ParticipantTimelineDataDTO baronAssistsPerMinCounts;
    private ParticipantTimelineDataDTO baronKillsPerMinCounts;
    private ParticipantTimelineDataDTO creepsPerMinDeltas;
    private ParticipantTimelineDataDTO csDiffPerMinDeltas;
    private ParticipantTimelineDataDTO damageTakenDiffPerMinDeltas;
    private ParticipantTimelineDataDTO damageTakenPerMinDeltas;
    private ParticipantTimelineDataDTO dragonAssistsPerMinCounts;
    private ParticipantTimelineDataDTO dragonKillsPerMinCounts;
    private ParticipantTimelineDataDTO elderLizardAssistsPerMinCounts;
    private ParticipantTimelineDataDTO elderLizardKillsPerMinCounts;
    private ParticipantTimelineDataDTO goldPerMinDeltas;
    private ParticipantTimelineDataDTO inhibitorAssistsPerMinCounts;
    private ParticipantTimelineDataDTO inhibitorKillsPerMinCounts;
    private String lane;
    private String role;
    private ParticipantTimelineDataDTO towerAssistsPerMinCounts;
    private ParticipantTimelineDataDTO towerKillsPerMinCounts;
    private ParticipantTimelineDataDTO towerKillsPerMinDeltas;
    private ParticipantTimelineDataDTO vilemawAssistsPerMinCounts;
    private ParticipantTimelineDataDTO vilemawKillsPerMinCounts;
    private ParticipantTimelineDataDTO wardsPerMinDeltas;
    private ParticipantTimelineDataDTO xpDiffPerMinDeltas;
    private ParticipantTimelineDataDTO xpPerMinDeltas;

    public ParticipantTimelineDataDTO getAncientGolemAssistsPerMinCounts() {
        return ancientGolemAssistsPerMinCounts;
    }

    public void setAncientGolemAssistsPerMinCounts(ParticipantTimelineDataDTO ancientGolemAssistsPerMinCounts) {
        this.ancientGolemAssistsPerMinCounts = ancientGolemAssistsPerMinCounts;
    }

    public ParticipantTimelineDataDTO getAncientGolemKillsPerMinCounts() {
        return ancientGolemKillsPerMinCounts;
    }

    public void setAncientGolemKillsPerMinCounts(ParticipantTimelineDataDTO ancientGolemKillsPerMinCounts) {
        this.ancientGolemKillsPerMinCounts = ancientGolemKillsPerMinCounts;
    }

    public ParticipantTimelineDataDTO getAssistedLaneDeathsPerMinDeltas() {
        return assistedLaneDeathsPerMinDeltas;
    }

    public void setAssistedLaneDeathsPerMinDeltas(ParticipantTimelineDataDTO assistedLaneDeathsPerMinDeltas) {
        this.assistedLaneDeathsPerMinDeltas = assistedLaneDeathsPerMinDeltas;
    }

    public ParticipantTimelineDataDTO getAssistedLaneKillsPerMinDeltas() {
        return assistedLaneKillsPerMinDeltas;
    }

    public void setAssistedLaneKillsPerMinDeltas(ParticipantTimelineDataDTO assistedLaneKillsPerMinDeltas) {
        this.assistedLaneKillsPerMinDeltas = assistedLaneKillsPerMinDeltas;
    }

    public ParticipantTimelineDataDTO getBaronAssistsPerMinCounts() {
        return baronAssistsPerMinCounts;
    }

    public void setBaronAssistsPerMinCounts(ParticipantTimelineDataDTO baronAssistsPerMinCounts) {
        this.baronAssistsPerMinCounts = baronAssistsPerMinCounts;
    }

    public ParticipantTimelineDataDTO getBaronKillsPerMinCounts() {
        return baronKillsPerMinCounts;
    }

    public void setBaronKillsPerMinCounts(ParticipantTimelineDataDTO baronKillsPerMinCounts) {
        this.baronKillsPerMinCounts = baronKillsPerMinCounts;
    }

    public ParticipantTimelineDataDTO getCreepsPerMinDeltas() {
        return creepsPerMinDeltas;
    }

    public void setCreepsPerMinDeltas(ParticipantTimelineDataDTO creepsPerMinDeltas) {
        this.creepsPerMinDeltas = creepsPerMinDeltas;
    }

    public ParticipantTimelineDataDTO getCsDiffPerMinDeltas() {
        return csDiffPerMinDeltas;
    }

    public void setCsDiffPerMinDeltas(ParticipantTimelineDataDTO csDiffPerMinDeltas) {
        this.csDiffPerMinDeltas = csDiffPerMinDeltas;
    }

    public ParticipantTimelineDataDTO getDamageTakenDiffPerMinDeltas() {
        return damageTakenDiffPerMinDeltas;
    }

    public void setDamageTakenDiffPerMinDeltas(ParticipantTimelineDataDTO damageTakenDiffPerMinDeltas) {
        this.damageTakenDiffPerMinDeltas = damageTakenDiffPerMinDeltas;
    }

    public ParticipantTimelineDataDTO getDamageTakenPerMinDeltas() {
        return damageTakenPerMinDeltas;
    }

    public void setDamageTakenPerMinDeltas(ParticipantTimelineDataDTO damageTakenPerMinDeltas) {
        this.damageTakenPerMinDeltas = damageTakenPerMinDeltas;
    }

    public ParticipantTimelineDataDTO getDragonAssistsPerMinCounts() {
        return dragonAssistsPerMinCounts;
    }

    public void setDragonAssistsPerMinCounts(ParticipantTimelineDataDTO dragonAssistsPerMinCounts) {
        this.dragonAssistsPerMinCounts = dragonAssistsPerMinCounts;
    }

    public ParticipantTimelineDataDTO getDragonKillsPerMinCounts() {
        return dragonKillsPerMinCounts;
    }

    public void setDragonKillsPerMinCounts(ParticipantTimelineDataDTO dragonKillsPerMinCounts) {
        this.dragonKillsPerMinCounts = dragonKillsPerMinCounts;
    }

    public ParticipantTimelineDataDTO getElderLizardAssistsPerMinCounts() {
        return elderLizardAssistsPerMinCounts;
    }

    public void setElderLizardAssistsPerMinCounts(ParticipantTimelineDataDTO elderLizardAssistsPerMinCounts) {
        this.elderLizardAssistsPerMinCounts = elderLizardAssistsPerMinCounts;
    }

    public ParticipantTimelineDataDTO getElderLizardKillsPerMinCounts() {
        return elderLizardKillsPerMinCounts;
    }

    public void setElderLizardKillsPerMinCounts(ParticipantTimelineDataDTO elderLizardKillsPerMinCounts) {
        this.elderLizardKillsPerMinCounts = elderLizardKillsPerMinCounts;
    }

    public ParticipantTimelineDataDTO getGoldPerMinDeltas() {
        return goldPerMinDeltas;
    }

    public void setGoldPerMinDeltas(ParticipantTimelineDataDTO goldPerMinDeltas) {
        this.goldPerMinDeltas = goldPerMinDeltas;
    }

    public ParticipantTimelineDataDTO getInhibitorAssistsPerMinCounts() {
        return inhibitorAssistsPerMinCounts;
    }

    public void setInhibitorAssistsPerMinCounts(ParticipantTimelineDataDTO inhibitorAssistsPerMinCounts) {
        this.inhibitorAssistsPerMinCounts = inhibitorAssistsPerMinCounts;
    }

    public ParticipantTimelineDataDTO getInhibitorKillsPerMinCounts() {
        return inhibitorKillsPerMinCounts;
    }

    public void setInhibitorKillsPerMinCounts(ParticipantTimelineDataDTO inhibitorKillsPerMinCounts) {
        this.inhibitorKillsPerMinCounts = inhibitorKillsPerMinCounts;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ParticipantTimelineDataDTO getTowerAssistsPerMinCounts() {
        return towerAssistsPerMinCounts;
    }

    public void setTowerAssistsPerMinCounts(ParticipantTimelineDataDTO towerAssistsPerMinCounts) {
        this.towerAssistsPerMinCounts = towerAssistsPerMinCounts;
    }

    public ParticipantTimelineDataDTO getTowerKillsPerMinCounts() {
        return towerKillsPerMinCounts;
    }

    public void setTowerKillsPerMinCounts(ParticipantTimelineDataDTO towerKillsPerMinCounts) {
        this.towerKillsPerMinCounts = towerKillsPerMinCounts;
    }

    public ParticipantTimelineDataDTO getTowerKillsPerMinDeltas() {
        return towerKillsPerMinDeltas;
    }

    public void setTowerKillsPerMinDeltas(ParticipantTimelineDataDTO towerKillsPerMinDeltas) {
        this.towerKillsPerMinDeltas = towerKillsPerMinDeltas;
    }

    public ParticipantTimelineDataDTO getVilemawAssistsPerMinCounts() {
        return vilemawAssistsPerMinCounts;
    }

    public void setVilemawAssistsPerMinCounts(ParticipantTimelineDataDTO vilemawAssistsPerMinCounts) {
        this.vilemawAssistsPerMinCounts = vilemawAssistsPerMinCounts;
    }

    public ParticipantTimelineDataDTO getVilemawKillsPerMinCounts() {
        return vilemawKillsPerMinCounts;
    }

    public void setVilemawKillsPerMinCounts(ParticipantTimelineDataDTO vilemawKillsPerMinCounts) {
        this.vilemawKillsPerMinCounts = vilemawKillsPerMinCounts;
    }

    public ParticipantTimelineDataDTO getWardsPerMinDeltas() {
        return wardsPerMinDeltas;
    }

    public void setWardsPerMinDeltas(ParticipantTimelineDataDTO wardsPerMinDeltas) {
        this.wardsPerMinDeltas = wardsPerMinDeltas;
    }

    public ParticipantTimelineDataDTO getXpDiffPerMinDeltas() {
        return xpDiffPerMinDeltas;
    }

    public void setXpDiffPerMinDeltas(ParticipantTimelineDataDTO xpDiffPerMinDeltas) {
        this.xpDiffPerMinDeltas = xpDiffPerMinDeltas;
    }

    public ParticipantTimelineDataDTO getXpPerMinDeltas() {
        return xpPerMinDeltas;
    }

    public void setXpPerMinDeltas(ParticipantTimelineDataDTO xpPerMinDeltas) {
        this.xpPerMinDeltas = xpPerMinDeltas;
    }
}
