package fr.kabiro.lol.ism.core.remote.match.dto;

import java.util.ArrayList;
import java.util.List;

public class InfoDto {
    public Long gameId;
    public String gameMode;
    public Long gameStartTimestamp;
    public List<ParticipanDto> participants = new ArrayList<>();
}
