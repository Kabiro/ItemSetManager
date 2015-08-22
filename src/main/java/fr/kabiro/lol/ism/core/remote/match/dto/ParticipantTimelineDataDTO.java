package fr.kabiro.lol.ism.core.remote.match.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParticipantTimelineDataDTO {
    private Double tenToTwenty;
    private Double thirtyToEnd;
    private Double twentyToThirty;
    private Double zeroToTen;

    public Double getTenToTwenty() {
        return tenToTwenty;
    }

    public void setTenToTwenty(Double tenToTwenty) {
        this.tenToTwenty = tenToTwenty;
    }

    public Double getThirtyToEnd() {
        return thirtyToEnd;
    }

    public void setThirtyToEnd(Double thirtyToEnd) {
        this.thirtyToEnd = thirtyToEnd;
    }

    public Double getTwentyToThirty() {
        return twentyToThirty;
    }

    public void setTwentyToThirty(Double twentyToThirty) {
        this.twentyToThirty = twentyToThirty;
    }

    public Double getZeroToTen() {
        return zeroToTen;
    }

    public void setZeroToTen(Double zeroToTen) {
        this.zeroToTen = zeroToTen;
    }
}
