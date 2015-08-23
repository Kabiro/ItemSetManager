package fr.kabiro.lol.ism.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.kabiro.lol.ism.core.serialization.SerializationIdSerializer;
import fr.kabiro.lol.ism.core.serialization.WithSerializationId;

@JsonSerialize(using = SerializationIdSerializer.class)
public enum ModeDto implements WithSerializationId{
    ANY("any"),
    CLASSIC("CLASSIC"),
    ARAM("ARAM"),
    DOMINION("ODIN");

    private String serializationId;

    ModeDto(String serializationId){
        this.serializationId = serializationId;
    }

    public String getSerializationId(){
        return serializationId;
    }
}
