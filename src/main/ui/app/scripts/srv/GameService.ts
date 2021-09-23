import {Injectable} from "@angular/core";
import {MatchSummary} from "../model/MatchSummary";
import {Match} from "../model/Match";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class GameService {
    constructor(private http: HttpClient) {
    }

    recentByUser(username: string, region: string): Promise<MatchSummary[]> {
        return this.http.get<MatchSummary[]>('/api/games/v1/' + region + '/' + username + '/recents').toPromise();
    }

    getById(id: number, region: string): Promise<Match> {
        return this.http.get<Match>('/api/games/v1/' + region + '/' + id + '/details').toPromise();
    }
}
