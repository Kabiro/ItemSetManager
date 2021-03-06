package fr.kabiro.lol.ism.core.dto;

public class SummonerDto {
    private Long riotId;
    private Long accountId;
    private String name;
    private RegionDto region;
    private Integer summonerIcon;

    public Long getRiotId() {
        return riotId;
    }

    public void setRiotId(Long riotId) {
        this.riotId = riotId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RegionDto getRegion() {
        return region;
    }

    public void setRegion(RegionDto region) {
        this.region = region;
    }

    public Integer getSummonerIcon() {
        return summonerIcon;
    }

    public void setSummonerIcon(Integer summonerIcon) {
        this.summonerIcon = summonerIcon;
    }
}
