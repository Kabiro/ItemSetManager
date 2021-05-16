package fr.kabiro.lol.ism.core.model;

public enum Region {
    BR1("AMERICAS"),
    EUN1("EUROPE"),
    EUW1("EUROPE"),
    JP1("ASIA"),
    KR("ASIA"),
    LA1("AMERICAS"),
    LA2("AMERICAS"),
    NA1("AMERICAS"),
    OC1("AMERICAS"),
    TR1("EUROPE"),
    RU("EUROPE");

    private final String routing;
    Region(String routing){
        this.routing = routing;
    }
    public String getRouting() {
        return this.routing.toLowerCase();
    }
}
