package fr.kabiro.lol.ism.core.controller;

import fr.kabiro.lol.ism.core.remote.staticdata.dto.ChampionDto;
import fr.kabiro.lol.ism.core.remote.staticdata.dto.ChampionListDto;
import fr.kabiro.lol.ism.core.service.ChampionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChampionController {

    private ChampionService championService;

    public ChampionController(ChampionService championService) {
        this.championService = championService;
    }

    @RequestMapping("/api/champions/v1/champions")
    public Map<String, ChampionDto> all() {
        ChampionListDto champions = championService.getAll();
        return champions.data;
    }
}
