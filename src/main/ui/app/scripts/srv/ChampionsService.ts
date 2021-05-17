import {StaticChampion, StaticChampions} from "../model/StaticChampions";
import * as _ from "lodash";

export class ChampionsService {
    static $inject = ['$http'];

    champions: Promise<StaticChampions>;
    championsByKey: Promise<{ [k in string]: StaticChampion }>;

    constructor(private $http: ng.IHttpService) {
        this.champions = this.$http.get('https://ddragon.leagueoflegends.com/cdn/11.10.1/data/en_US/champion.json')
            .then(r => r.data) as any as Promise<StaticChampions>;

        this.championsByKey = this.champions.then((c) => {
            return _.keyBy(c.data, (champ: StaticChampion) => champ.key);
        });
    }
}
