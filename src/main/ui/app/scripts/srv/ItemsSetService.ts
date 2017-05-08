export class ItemsSetService {
    static $inject = ['$http'];

    constructor(private $http: ng.IHttpService) {
    }

    buildsByUser(username: string, region: string): ng.IHttpPromise<any> {
        return this.$http.get('/api/sets/v1/' + region + '/' + username);
    }

    followedBuildsByUser(username: string, region: string): ng.IHttpPromise<any> {
        return this.$http.get('/api/sets/v1/' + region + '/' + username + '/followed');
    }

    followBuild(username: string, region: string, buildId: number): ng.IHttpPromise<object> {
        return this.$http.put('/api/sets/v1/' + region + '/' + username + '/followed/' + buildId, null);
    }

    unfollowBuild(username: string, region: string, buildId: number): ng.IHttpPromise<object> {
        return this.$http.delete('/api/sets/v1/' + region + '/' + username + '/followed/' + buildId);
    }

    getByGame(gameId: number, region: string): ng.IHttpPromise<any> {
        return this.$http.get('/api/sets/v1/game/' + region + '/' + gameId);
    }

    getById(id: number): ng.IHttpPromise<any> {
        return this.$http.get('/api/sets/v1/' + id);
    }

    create(summoner: any, region: string, champions: any, itemSet: any): ng.IHttpPromise<any> {
        return this.$http.put('/api/sets/v1/', itemSet, {
            params: {
                summonerName: summoner,
                summonerRegion: region,
                champions: champions
            }
        });
    }

    delete(itemSetId: number): ng.IHttpPromise<object> {
        return this.$http.delete('api/sets/v1/' + itemSetId);
    }

    update(id: number, itemSet: any, champions: any): ng.IHttpPromise<any> {
        return this.$http.post('api/sets/v1/' + id, itemSet, {params: {champions: champions}});
    }
}
