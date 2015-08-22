package fr.kabiro.lol.ism.core.remote.staticdata.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChampionListDto {
    private Map<Integer, ChampionDTO> data;

    public Map<Integer, ChampionDTO> getData() {
        return data;
    }

    public void setData(Map<Integer, ChampionDTO> data) {
        this.data = data;
    }
}
