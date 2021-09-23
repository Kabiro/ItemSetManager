import {Http} from "@angular/http";
import {Injectable} from "@angular/core";
import 'rxjs/add/operator/toPromise';
import {MatchSummary} from "../model/MatchSummary";
import {Match} from "../model/Match";

@Injectable()
export class GameService {
    constructor(private http: Http) {
    }

    recentByUser(username: string, region: string): Promise<MatchSummary[]> {
        return this.http.get('/api/games/v1/' + region + '/' + username + '/recents').toPromise().then(r => r.json());
    }

    getById(id: number, region: string): Promise<Match> {
        return this.http.get('/api/games/v1/' + region + '/' + id + '/details').toPromise().then(r => r.json());
    }
}
