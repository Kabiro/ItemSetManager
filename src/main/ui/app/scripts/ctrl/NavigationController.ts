import {LoginService} from "../srv/LoginService";
import {SummonerService} from "../srv/SummonerService";

export class NavigationController {
    static $inject = ['$rootScope', '$state', 'LoginService', 'SummonerService'];

    userRegion: string = "EUW1";
    regions: string[] = [];

    constructor(private $rootScope: any, private $state: angular.ui.IStateService, private loginService: LoginService, private summonerService: SummonerService) {

        const cookieUser = this.loginService.getUser();
        if (cookieUser) {
            $rootScope.user = cookieUser;
        }

        this.summonerService.regions().then((result) => {
            this.regions = result || [];
        });
    }

    logout() {
        this.loginService.logout();
        delete this.$rootScope.user;
    }


    login(name: string, region: string) {
        this.summonerService.byName(name, region).then((result) => {
            this.loginService.logIn(result);
            this.$rootScope.user = result;
            if (this.$state.current.name === 'home' || this.$state.current.name === 'homeBis') {
                this.$state.go('summoner', {summoner: name, region: region});
            }
        });
    };
}
