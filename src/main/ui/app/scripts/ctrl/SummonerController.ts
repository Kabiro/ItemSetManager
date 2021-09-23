import {ItemsSetService} from "../srv/ItemsSetService";
import {GameService} from "../srv/GameService";
import {SummonerService} from "../srv/SummonerService";
import {Utils} from "../factories/Utils";

export class SummonerController {
    static $inject = ['$rootScope', '$state', '$stateParams', '$uibModal', 'ItemsSetService', 'GameService', 'SummonerService'];

    builds: any[] = [];
    followedBuilds: any[] = [];
    userFollowedBuilds: any[] = [];
    recentGames: any[] = [];
    summoner: any = {};

    constructor(private $rootScope: any, private $state: ng.ui.IStateService, private $stateParams: ng.ui.IStateParamsService,
                private $modal: ng.ui.bootstrap.IModalService, private itemsSetService: ItemsSetService, private gameService: GameService, private summonerService: SummonerService) {

        if (Utils.isEmpty($stateParams.summoner) || Utils.isEmpty($stateParams.region)) {
            $state.go('home');
        }

        $rootScope.header = {
            title: $stateParams.summoner + ' (' + $stateParams.region + ')'
        };

        this.summoner = {
            name: $stateParams.summoner,
            region: $stateParams.region
        };

        this.summonerService.byName(this.summoner.name, this.summoner.region).then((result) => {
            this.summoner = result;

            this.itemsSetService.buildsByUser(this.summoner.name, this.summoner.region).then((result) => {
                this.builds = result;
            });

            this.itemsSetService.followedBuildsByUser(this.summoner.name, this.summoner.region).then((result) => {
                this.followedBuilds = result;
            });

            this.gameService.recentByUser(this.summoner.name, this.summoner.region).then((result) => {
                this.recentGames = result;
            });

            if ($rootScope.user) {
                this.itemsSetService.followedBuildsByUser($rootScope.user.name, $rootScope.user.region).then((result) => {
                    this.userFollowedBuilds = (<any[]>result).map(build => build.id);
                });
            }
        });
    }

    copyToClipboard(selector: any) {
        document.querySelector(selector).select();
        document.execCommand('copy');
    }

    followBuild(buildId: number) {
        this.itemsSetService.followBuild(this.$rootScope.user.name, this.$rootScope.user.region, buildId).then(() => {
            this.userFollowedBuilds.push(buildId);
        });
    }

    unfollowBuild(buildId: number) {
        this.itemsSetService.unfollowBuild(this.$rootScope.user.name, this.$rootScope.user.region, buildId).then(() => {
            this.userFollowedBuilds.splice(this.userFollowedBuilds.indexOf(buildId), 1);
        })
    }

    edit(buildId: number) {
        this.$state.go('buildEdit', {buildId: buildId});
    }

    delete(buildId: number) {
        this.$modal.open({
            animation: true,
            size: 'sm',
            templateUrl: 'template/modal/validateModal.html',
            controller: 'ValidateModalController',
            controllerAs: 'validate',
            resolve: {
                text: () => 'Are you sure you want to delete this itemSet?'
            }
        }).result.then(() => {
            this.itemsSetService.delete(buildId).then(() => {
                this.builds = this.builds.filter(build => build.id != buildId);
            });
        }, () => {});
    }
}

