package fr.kabiro.lol.ism.core.controller;

import fr.kabiro.lol.ism.core.dto.SummonerDto;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.service.SummonerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummonerController {

    private SummonerService summonerService;

    public SummonerController(SummonerService summonerService) {
        this.summonerService = summonerService;
    }

    @RequestMapping("/api/summoners/v1/regions")
    public Region[] regions() {
        return Region.values();
    }

    @RequestMapping("/api/summoners/v1/{region}/{name}")
    public SummonerDto summoner(@PathVariable("name") String name, @PathVariable("region") Region region) {
        return summonerService.findByNameAndRegion(name, region).get();
    }
}
