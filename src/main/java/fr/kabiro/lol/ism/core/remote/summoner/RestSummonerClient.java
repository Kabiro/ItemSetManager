package fr.kabiro.lol.ism.core.remote.summoner;

import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.remote.RestRiotClient;
import fr.kabiro.lol.ism.core.remote.summoner.dto.SummonerDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Component
public class RestSummonerClient extends RestRiotClient {
    private final static String VERSION = "v1.4";

    public RestSummonerClient() {
        super(VERSION);
    }

    public Set<SummonerDTO> getSummonersByNames(Collection<String> names, Region region) {
        if (CollectionUtils.isEmpty(names)) {
            return Collections.emptySet();
        }
        StringJoiner joiner = new StringJoiner(",");
        names.forEach(joiner::add);
        Map<String, SummonerDTO> nameToSummoner = doGet("/summoner/by-name/" + joiner.toString(), region, Collections.emptyMap(), mapStringSummoner());
        return new HashSet<>(nameToSummoner.values());
    }

    public Optional<SummonerDTO> getSummonerByName(String name, Region region) {
        if (StringUtils.isEmpty(name) || region == null) {
            return Optional.empty();
        }
        Set<SummonerDTO> summoners = this.getSummonersByNames(Collections.singletonList(name), region);
        return summoners.stream().findFirst();
    }

    public Map<Long, SummonerDTO> getSummonersByRiotIds(Collection<Long> riotIds, Region region) {
        if (CollectionUtils.isEmpty(riotIds)) {
            return Collections.emptyMap();
        }
        StringJoiner joiner = new StringJoiner(",");
        riotIds.forEach(id -> joiner.add(id.toString()));
        Map<String, SummonerDTO> idToSummoner = doGet("/summoner/" + joiner.toString(), region, Collections.emptyMap(), mapStringSummoner());

        Map<Long, SummonerDTO> intIdToSummoner = new HashMap<>();
        for (Map.Entry<String, SummonerDTO> entry : idToSummoner.entrySet()) {
            intIdToSummoner.put(Long.parseLong(entry.getKey()), entry.getValue());
        }
        return intIdToSummoner;
    }

    public Optional<SummonerDTO> getSummonerByRiotId(Long id, Region region) {
        if (id == null || region == null) {
            return Optional.empty();
        }
        Map<Long, SummonerDTO> summoners = this.getSummonersByRiotIds(Collections.singletonList(id), region);
        return Optional.ofNullable(summoners.get(id));
    }

    private ParameterizedTypeReference<Map<String, SummonerDTO>> mapStringSummoner() {
        return new ParameterizedTypeReference<Map<String, SummonerDTO>>() {
        };
    }
}
