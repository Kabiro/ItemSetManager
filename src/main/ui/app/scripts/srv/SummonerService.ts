import {Summoner} from "../model/Summoner";
import {Injectable} from "@angular/core";
import 'rxjs/add/operator/toPromise';
import {Http} from "@angular/http";

@Injectable()
export class SummonerService {
    constructor(private http: Http) {
    }

    regions(): Promise<string[]> {
        return this.http.get('/api/summoners/v1/regions').toPromise().then(r => r.json());
    }

    byName(name: string, region: string): Promise<Summoner> {
        return this.http.get('/api/summoners/v1/' + region + '/' + name).toPromise().then(r => r.json());
    }
}
