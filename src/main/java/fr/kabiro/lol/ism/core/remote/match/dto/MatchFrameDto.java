package fr.kabiro.lol.ism.core.remote.match.dto;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MatchFrameDto {
    public long timestamp;
    public Map<Integer, MatchParticipantFrameDto> participantFrames = Collections.emptyMap();
    public List<MatchEventDto> events = Collections.emptyList();
}
