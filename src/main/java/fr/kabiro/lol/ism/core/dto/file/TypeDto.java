package fr.kabiro.lol.ism.core.dto.file;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.kabiro.lol.ism.core.serialization.SerializationIdSerializer;
import fr.kabiro.lol.ism.core.serialization.WithSerializationId;

@JsonSerialize(using = SerializationIdSerializer.class)
public enum TypeDto implements WithSerializationId {
    CUSTOM("custom"),
    GLOBAL("global");

    private String serializationId;

    TypeDto(String serializationId){
        this.serializationId = serializationId;
    }

    public String getSerializationId(){
        return serializationId;
    }
}
