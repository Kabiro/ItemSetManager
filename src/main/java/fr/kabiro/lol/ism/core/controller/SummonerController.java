package fr.kabiro.lol.ism.core.controller;

import fr.kabiro.lol.ism.core.model.Region;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummonerController {

    @RequestMapping("/api/summoners/v1/regions")
    public Region[] regions() {
        return Region.values();
    }
}
