import {SummonerService} from "../srv/SummonerService";
export class HomeController {

    static $inject = ["$rootScope", "$state", "SummonerService"];

    summonerRegion: string = "EUW1";
    gameRegion: string = "EUW1";
    regions: string[] = [];

    constructor(private $rootScope: ng.IRootScopeService, private $state: ng.ui.IStateService, private summonerService: SummonerService) {
        this.$rootScope.header = {};

        this.summonerService.regions().then(result => {
            this.regions = result.data || [];
        });
    }


    searchSummoner(name: string, region: string) {
        this.$state.go('summoner', {summoner: name, region: region});
    }

    searchGame(id: number, region: string) {
        this.$state.go('game', {gameId: id, gameRegion: region});
    }
}