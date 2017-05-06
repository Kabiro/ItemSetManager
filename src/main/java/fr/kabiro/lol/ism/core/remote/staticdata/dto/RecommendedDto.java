package fr.kabiro.lol.ism.core.remote.staticdata.dto;

import java.util.Collections;
import java.util.List;

public class RecommendedDto {
    public String map;	
    public List<BlockDto> blocks = Collections.emptyList();
    public String champion;	
    public String title;	
    public boolean priority;	
    public String mode;	
    public String type;	
}
