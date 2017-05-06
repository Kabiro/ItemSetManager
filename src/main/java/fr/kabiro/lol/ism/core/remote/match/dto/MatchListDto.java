package fr.kabiro.lol.ism.core.remote.match.dto;

import java.util.Collections;
import java.util.List;

public class MatchListDto {
    public List<MatchReferenceDto> matches = Collections.emptyList();
    public int totalGames;
    public int startIndex;
    public int endIndex;
}
