import {Injectable} from "@angular/core";
import {StaticChampion, StaticChampions} from "../model/StaticChampions";
import * as _ from "lodash";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class ChampionsService {
    champions: Promise<StaticChampions>;
    championsByKey: Promise<{ [k in string]: StaticChampion }>;

    constructor(private http: HttpClient) {
        this.champions = this.http.get<StaticChampions>('https://ddragon.leagueoflegends.com/cdn/11.10.1/data/en_US/champion.json')
            .toPromise();

        this.championsByKey = this.champions.then((c) => {
            return _.keyBy(c.data, (champ: StaticChampion) => champ.key);
        });
    }

}
