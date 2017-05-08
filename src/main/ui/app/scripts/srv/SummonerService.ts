export class SummonerService {
    static $inject = ['$http'];

    constructor(private $http: ng.IHttpService) {
    }


    regions(): ng.IHttpPromise<string[]> {
        return this.$http.get('/api/summoners/v1/regions');
    }

    byName(name: string, region: string): ng.IHttpPromise<any> {
        return this.$http.get('/api/summoners/v1/' + region + '/' + name);
    }
}
