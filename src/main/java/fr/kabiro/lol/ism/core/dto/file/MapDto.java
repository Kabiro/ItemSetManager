package fr.kabiro.lol.ism.core.dto.file;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.kabiro.lol.ism.core.serialization.SerializationIdSerializer;
import fr.kabiro.lol.ism.core.serialization.WithSerializationId;

@JsonSerialize(using = SerializationIdSerializer.class)
public enum MapDto implements WithSerializationId {
    ANY("any"),
    SUMMONER_RIFT("SR"),
    HOWLING_ABYSS("HA"),
    TWISTED_TREELINE("TT"),
    CRYSTAL_SCAR("CS");

    private String serializationId;

    MapDto(String serializationId){
        this.serializationId = serializationId;
    }

    public String getSerializationId(){
        return serializationId;
    }
}
