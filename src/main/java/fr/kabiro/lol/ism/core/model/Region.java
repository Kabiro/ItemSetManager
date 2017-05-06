package fr.kabiro.lol.ism.core.model;

public enum Region {
    BR(RegionV3.BR1),
    EUNE(RegionV3.EUN1),
    EUW(RegionV3.EUW1),
    KR(RegionV3.KR),
    LAN(RegionV3.LA1),
    LAS(RegionV3.LA2),
    NA(RegionV3.NA1),
    OCE(RegionV3.OC1),
    RU(RegionV3.RU),
    TR(RegionV3.TR1),
    ;

    Region(RegionV3 v3) {
        this.v3 = v3;
    }

    private RegionV3 v3;

    public RegionV3 getV3() {
        return v3;
    }
}
