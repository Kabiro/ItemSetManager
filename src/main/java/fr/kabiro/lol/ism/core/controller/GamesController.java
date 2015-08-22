package fr.kabiro.lol.ism.core.controller;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.game.dto.GameDTO;
import fr.kabiro.lol.ism.core.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class GamesController {

    @Autowired
    private GameService gameService;

    @RequestMapping("/api/games/v1/{name}/{region}/recents/")
    public Set<GameDTO> recentGamesBySummoner(@PathVariable("name") String name, @PathVariable("region") Region region) {
        return gameService.recentGamesBySummoner(name, region);
    }
}
