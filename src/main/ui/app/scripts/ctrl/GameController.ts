import {IModalService} from "angular-ui-bootstrap";
import {GameService} from "../srv/GameService";
import {ItemsSetService} from "../srv/ItemsSetService";
import {ChampionsService} from "../srv/ChampionsService";

export class GameController {

    static $inject = ['$rootScope', '$stateParams', '$uibModal', 'GameService', 'ItemsSetService', 'ChampionsService'];

    game: any = {};
    itemSet: any = {};

    constructor(private $rootScope: any, private $stateParams: angular.ui.IStateParamsService, private $modal: IModalService,
                private gameService: GameService, private itemsSetService: ItemsSetService, private championsService: ChampionsService) {
        this.$rootScope.header = {
            title: 'Game n°' + $stateParams.gameId + ' (' + $stateParams.gameRegion + ')'
        };


        this.gameService.getById($stateParams.gameId, $stateParams.gameRegion).then((result) => {
            this.game = result;
        });

        this.itemsSetService.getByGame($stateParams.gameId, $stateParams.gameRegion).then((result) => {
            this.itemSet = result;
        });
    }

    createItemSet(user: any, championId: string, itemSet: any) {
        this.championsService.champions.then((result) => {

            this.$modal.open({
                animation: true,
                size: 'sm',
                templateUrl: 'template/modal/addItemSetModal.html',
                controller: 'AddItemSetModalController',
                controllerAs: '$ctrl',
                resolve: {
                    itemSet: function () {
                        return itemSet;
                    }
                }
            }).result.then(() => {
                const championKey = result.data[championId].key;
                this.itemsSetService.create(user.name, user.region, championKey, itemSet);
            }, () => {});
        });
    };
}
