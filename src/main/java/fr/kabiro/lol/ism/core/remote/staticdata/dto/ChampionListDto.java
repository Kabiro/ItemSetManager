package fr.kabiro.lol.ism.core.remote.staticdata.dto;

import java.util.Collections;
import java.util.Map;

public class ChampionListDto {
    public Map<String, String> keys = Collections.emptyMap();
    public Map<String, ChampionDto> data = Collections.emptyMap();
    public String version;	
    public String type;	
    public String format;	
}
