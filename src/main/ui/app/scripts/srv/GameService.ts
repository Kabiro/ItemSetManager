export class GameService {
    static $inject = ["$http"];

    constructor(private $http: ng.IHttpService) {
    }

    recentByUser(username: string, region: string): ng.IHttpPromise<any> {
        return this.$http.get('/api/games/v1/' + region + '/' + username + '/recents');
    }

    getById(id: number, region: string): ng.IHttpPromise<any> {
        return this.$http.get('/api/games/v1/' + region + '/' + id + '/details');
    }
}
