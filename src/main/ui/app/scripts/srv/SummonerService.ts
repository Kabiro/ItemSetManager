import {Summoner} from "../model/Summoner";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class SummonerService {
    constructor(private http: HttpClient) {
    }

    regions(): Promise<string[]> {
        return this.http.get<string[]>('/api/summoners/v1/regions').toPromise();
    }

    byName(name: string, region: string): Promise<Summoner> {
        return this.http.get<Summoner>('/api/summoners/v1/' + region + '/' + name).toPromise();
    }
}
