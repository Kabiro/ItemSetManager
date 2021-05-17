package fr.kabiro.lol.ism.core.controller;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.model.match.MatchSummary;
import fr.kabiro.lol.ism.core.remote.match.dto.MatchDto;
import fr.kabiro.lol.ism.core.service.GameService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GamesController {

    private GameService gameService;

    public GamesController(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping("/api/games/v1/{region}/{name}/recents")
    public List<MatchSummary> recentGamesBySummoner(@PathVariable("name") String name, @PathVariable("region") Region region) {
        return gameService.recentGamesBySummoner(name, region);
    }

    @RequestMapping("/api/games/v1/{region}/{id}/details")
    public MatchDto byId(@PathVariable("id") String id, @PathVariable("region") Region region) {
        return gameService.byId(id, region);
    }

}
