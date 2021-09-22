package fr.kabiro.lol.ism.core.remote.match.dto;

import java.util.ArrayList;
import java.util.List;

public class InfoDto {
    public String gameId;
    public String gameMode;
    public String platformId;
    public Long gameStartTimestamp;
    public List<ParticipantDto> participants = new ArrayList<>();
    public List<TeamDto> teams = new ArrayList<>();
}
