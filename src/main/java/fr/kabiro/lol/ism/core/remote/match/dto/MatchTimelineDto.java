package fr.kabiro.lol.ism.core.remote.match.dto;

import java.util.Collections;
import java.util.List;

public class MatchTimelineDto {
    public List<MatchFrameDto> frames = Collections.emptyList();
    public long frameInterval;
}
