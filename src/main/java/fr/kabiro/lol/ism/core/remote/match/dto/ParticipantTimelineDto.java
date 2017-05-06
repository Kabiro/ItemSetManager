package fr.kabiro.lol.ism.core.remote.match.dto;

import java.util.Collections;
import java.util.Map;

public class ParticipantTimelineDto {
    public String lane;	
    public int participantId;	
    public Map<String, Double> csDiffPerMinDeltas = Collections.emptyMap();
    public Map<String, Double> goldPerMinDeltas = Collections.emptyMap();
    public Map<String, Double> xpDiffPerMinDeltas = Collections.emptyMap();
    public Map<String, Double> creepsPerMinDeltas = Collections.emptyMap();
    public Map<String, Double> xpPerMinDeltas = Collections.emptyMap();
    public String role;	
    public Map<String, Double> damageTakenDiffPerMinDeltas = Collections.emptyMap();
    public Map<String, Double> damageTakenPerMinDeltas = Collections.emptyMap();
}
