export class ChampionsService {
    static $inject = ['$http'];

    champions: ng.IHttpPromise<any>;

    constructor(private $http: ng.IHttpService) {
        this.champions = this.$http.get('/api/champions/v1/champions');
    }

}