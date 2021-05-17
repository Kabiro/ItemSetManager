package fr.kabiro.lol.ism.core.model.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Team {
    @Builder.Default
    private List<TeamPlayer> players = new ArrayList<>();
}
