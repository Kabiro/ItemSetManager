package fr.kabiro.lol.ism.core.model.match;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MatchSummary {
    private Long gameId;
    private String gameMode;
    private String platformId;
    private Long gameStartTimestamp;
    private Team teamA;
    private Team teamB;
}
