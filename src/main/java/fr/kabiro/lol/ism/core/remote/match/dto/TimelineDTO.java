package fr.kabiro.lol.ism.core.remote.match.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimelineDTO {
    private Long frameInterval;
    private List<FrameDTO> frames;

    public Long getFrameInterval() {
        return frameInterval;
    }

    public void setFrameInterval(Long frameInterval) {
        this.frameInterval = frameInterval;
    }

    public List<FrameDTO> getFrames() {
        return frames;
    }

    public void setFrames(List<FrameDTO> frames) {
        this.frames = frames;
    }

}
