import {Injectable} from "@angular/core";
import 'rxjs/add/operator/toPromise';
import {StaticChampion, StaticChampions} from "../model/StaticChampions";
import * as _ from "lodash";
import {Http} from "@angular/http";

@Injectable()
export class ChampionsService {
    champions: Promise<StaticChampions>;
    championsByKey: Promise<{ [k in string]: StaticChampion }>;

    constructor(private http: Http) {
        this.champions = this.http.get('https://ddragon.leagueoflegends.com/cdn/11.10.1/data/en_US/champion.json')
            .toPromise()
            .then(r => r.json());

        this.championsByKey = this.champions.then((c) => {
            return _.keyBy(c.data, (champ: StaticChampion) => champ.key);
        });
    }

}
