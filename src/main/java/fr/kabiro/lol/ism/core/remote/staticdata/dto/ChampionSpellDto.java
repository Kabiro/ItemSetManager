package fr.kabiro.lol.ism.core.remote.staticdata.dto;

import java.util.Collections;
import java.util.List;

public class ChampionSpellDto {
    public String cooldownBurn;	
    public String resource;	
    public LevelTipDto leveltip;	
    public List<SpellVarsDto> vars = Collections.emptyList();
    public String costType;	
    public ImageDto image;	
    public String sanitizedDescription;	
    public String sanitizedTooltip;	
    public List<List<Double>> effect = Collections.emptyList();
    public String tooltip;	
    public int maxrank;	
    public String costBurn;	
    public String rangeBurn;	
    public Object range;           //	This field is either a List of Integer or the String 'self' for spells that target one's own champion.
    public List<Double> cooldown = Collections.emptyList();
    public List<Integer> cost = Collections.emptyList();
    public String key;	
    public String description;	
    public List<String> effectBurn = Collections.emptyList();
    public List<ImageDto> altimages = Collections.emptyList();
    public String name;	
}
