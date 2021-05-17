package fr.kabiro.lol.ism.core.mapper;

import fr.kabiro.lol.ism.core.model.match.MatchSummary;
import fr.kabiro.lol.ism.core.model.match.Team;
import fr.kabiro.lol.ism.core.model.match.TeamPlayer;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchDto;
import fr.kabiro.lol.ism.core.remote.match.dto.ParticipanDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MatchSummaryMapper {

    public MatchSummary matchDtoToMatchSummary(MatchDto dto) {
        return MatchSummary.builder()
                .gameId(dto.info.gameId)
                .gameMode(dto.info.gameMode)
                .platformId(dto.info.platformId)
                .gameStartTimestamp(dto.info.gameStartTimestamp)
                .teamA(this.matchToTeam(dto, 100))
                .teamB(this.matchToTeam(dto, 200))
                .build();
    }

    private Team matchToTeam(MatchDto dto, Integer teamId) {
        List<TeamPlayer> teamPlayers = dto.info.participants
                .stream()
                .filter(p -> p.teamId.equals(teamId))
                .map(this::participantToTeamPlayer)
                .collect(Collectors.toList());

        return Team.builder()
                .players(teamPlayers)
                .build();
    }

    private TeamPlayer participantToTeamPlayer(ParticipanDto dto) {
        return TeamPlayer.builder()
                .championId(dto.championId)
                .championName(dto.championName)
                .build();
    }
}
