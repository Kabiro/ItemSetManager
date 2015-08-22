package fr.kabiro.lol.ism.core.controller;

import fr.kabiro.lol.ism.core.remote.staticdata.dto.ChampionDTO;
import fr.kabiro.lol.ism.core.remote.staticdata.dto.ChampionListDto;
import fr.kabiro.lol.ism.core.service.ChampionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChampionController {

    @Autowired
    private ChampionService championService;

    @RequestMapping("/api/champions/v1/champions")
    public Map<Integer, ChampionDTO> all() {
        ChampionListDto champions = championService.getAll();
        return champions.getData();
    }
}
