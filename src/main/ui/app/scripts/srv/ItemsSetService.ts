import {Injectable} from "@angular/core";
import {Build, ItemSet} from "../model/Build";
import {HttpClient, HttpParams} from "@angular/common/http";

@Injectable()
export class ItemsSetService {
    constructor(private http: HttpClient) {
    }

    buildsByUser(username: string, region: string): Promise<Build[]> {
        return this.http.get<Build[]>('/api/sets/v1/' + region + '/' + username).toPromise();
    }

    followedBuildsByUser(username: string, region: string): Promise<Build[]> {
        return this.http.get<Build[]>('/api/sets/v1/' + region + '/' + username + '/followed').toPromise();
    }

    followBuild(username: string, region: string, buildId: number): Promise<any> {
        return this.http.put('/api/sets/v1/' + region + '/' + username + '/followed/' + buildId, null).toPromise();
    }

    unfollowBuild(username: string, region: string, buildId: number): Promise<any> {
        return this.http.delete('/api/sets/v1/' + region + '/' + username + '/followed/' + buildId).toPromise();
    }

    getByGame(gameId: number, region: string): Promise<Map<number, ItemSet>> {
        return this.http.get<Map<number, ItemSet>>('/api/sets/v1/game/' + region + '/' + gameId).toPromise();
    }

    getById(id: number): Promise<Build> {
        return this.http.get<Build>('/api/sets/v1/' + id).toPromise();
    }

    create(summoner: any, region: string, champions: any, itemSet: any): Promise<Build> {
        return this.http.put<Build>('/api/sets/v1/', itemSet, {
            params: new HttpParams().set('summonerName', summoner).set('summonerRegion', region).set('champions', champions)
        }).toPromise();
    }

    delete(itemSetId: number): Promise<any> {
        return this.http.delete('api/sets/v1/' + itemSetId).toPromise();
    }

    update(id: number, itemSet: any, champions: any): Promise<Build> {
        return this.http.post<Build>('api/sets/v1/' + id, itemSet, {params: new HttpParams().set('champions', champions)}).toPromise();
    }
}
