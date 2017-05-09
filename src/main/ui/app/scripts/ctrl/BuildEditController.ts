import {ItemsSetService} from "../srv/ItemsSetService";

export class BuildEditController {
    static $inject = ['$rootScope', '$stateParams', '$timeout', 'ItemsSetService'];

    build: any;
    json: string = '';
    champions: string = '';
    success: boolean = false;

    constructor(private $rootScope: ng.IRootScopeService, private $stateParams: angular.ui.IStateParamsService, private $timeout: ng.ITimeoutService,
                private itemsSetService: ItemsSetService) {
        this.$rootScope.header = {};


        this.itemsSetService.getById($stateParams.buildId).then((result) => {
            this.build = result.data;
            $rootScope.header.title = result.data.itemSet.title;

            this.json = JSON.stringify(result.data.itemSet, null, 4);
            this.champions = JSON.stringify((<any[]>result.data.champions).map(item => item.key), null, 4);
        });
    }


    update(): void {
        const itemSet = JSON.parse(this.json);
        const champions = JSON.parse(this.champions);
        this.itemsSetService.update(this.build.id, itemSet, champions).then((result) => {
            this.build = result.data;

            this.json = JSON.stringify(result.data.itemSet, null, 4);
            this.champions = JSON.stringify((<any[]>result.data.champions).map(item => item.key), null, 4);

            this.success = true;
            this.$timeout(() => {
                this.success = false;
            }, 3000);
        });
    }
}
