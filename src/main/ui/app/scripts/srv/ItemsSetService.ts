import {Injectable} from "@angular/core";
import 'rxjs/add/operator/toPromise';
import {Build, ItemSet} from "../model/Build";
import {Http} from "@angular/http";

@Injectable()
export class ItemsSetService {
    constructor(private http: Http) {
    }

    buildsByUser(username: string, region: string): Promise<Build[]> {
        return this.http.get('/api/sets/v1/' + region + '/' + username).toPromise().then(r => r.json());
    }

    followedBuildsByUser(username: string, region: string): Promise<Build[]> {
        return this.http.get('/api/sets/v1/' + region + '/' + username + '/followed').toPromise().then(r => r.json());
    }

    followBuild(username: string, region: string, buildId: number): Promise<any> {
        return this.http.put('/api/sets/v1/' + region + '/' + username + '/followed/' + buildId, null).toPromise().then(r => r.json());
    }

    unfollowBuild(username: string, region: string, buildId: number): Promise<any> {
        return this.http.delete('/api/sets/v1/' + region + '/' + username + '/followed/' + buildId).toPromise().then(r => r.json());
    }

    getByGame(gameId: number, region: string): Promise<Map<number, ItemSet>> {
        return this.http.get('/api/sets/v1/game/' + region + '/' + gameId).toPromise().then(r => r.json());
    }

    getById(id: number): Promise<Build> {
        return this.http.get('/api/sets/v1/' + id).toPromise().then(r => r.json());
    }

    create(summoner: any, region: string, champions: any, itemSet: any): Promise<Build> {
        return this.http.put('/api/sets/v1/', itemSet, {
            params: {summonerName: summoner, summonerRegion: region, champions: champions}
        }).toPromise().then(r => r.json());
    }

    delete(itemSetId: number): Promise<any> {
        return this.http.delete('api/sets/v1/' + itemSetId).toPromise().then(r => r.json());
    }

    update(id: number, itemSet: any, champions: any): Promise<Build> {
        return this.http.post('api/sets/v1/' + id, itemSet, {params: {champions: champions}}).toPromise().then(r => r.json());
    }
}
