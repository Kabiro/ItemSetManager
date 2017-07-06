import * as angular from "angular";
import {IDirectiveFactory} from "angular";
import {IStateProvider} from "angular-ui-router";
import {ChampionsService} from "./srv/ChampionsService";
import {GameService} from "./srv/GameService";
import {ItemsSetService} from "./srv/ItemsSetService";
import {LoginService} from "./srv/LoginService";
import {SummonerService} from "./srv/SummonerService";
import {AddItemSetModalController} from "./ctrl/AddItemSetModalController";
import {BuildEditController} from "./ctrl/BuildEditController";
import {GameController} from "./ctrl/GameController";
import {HomeController} from "./ctrl/HomeController";
import {NavigationController} from "./ctrl/NavigationController";
import {SummonerController} from "./ctrl/SummonerController";
import {ValidateModalController} from "./ctrl/ValidateModalController";
import "../styles/app.scss";
import {LolImageComponent} from "./core/lolimage/LolImageComponent";
import {upgradeAdapter} from "./ng2app";

export const ng1App = angular.module('ItemSetManager', ['ngCookies', 'ui.router', 'ui.bootstrap']);

ng1App
    .service('ChampionsService', ChampionsService)
    .service('GameService', GameService)
    .service('ItemsSetService', ItemsSetService)
    .service('LoginService', LoginService)
    .service('SummonerService', SummonerService)
    .controller('AddItemSetModalController', AddItemSetModalController)
    .controller('BuildEditController', BuildEditController)
    .controller('GameController', GameController)
    .controller('HomeController', HomeController)
    .controller('NavigationController', NavigationController)
    .controller('SummonerController', SummonerController)
    .controller('ValidateModalController', ValidateModalController)
    .directive('ismLolImage', upgradeAdapter.downgradeNg2Component(LolImageComponent) as IDirectiveFactory)
;

ng1App.config(['$stateProvider', function ($stateProvider: IStateProvider) {

    $stateProvider
        .state('summoner', {
            url: '/summoner/:region/:summoner',
            templateUrl: '/views/summoner.html',
            controller: 'SummonerController',
            controllerAs: 'summoner'
        }).state('home', {
            url: '/',
            templateUrl: '/views/home.html',
            controller: 'HomeController',
            controllerAs: 'home'
        }).state('homeBis', {
            url: '',
            templateUrl: '/views/home.html',
            controller: 'HomeController',
            controllerAs: 'home'
        }).state('game', {
            url: '/game/:gameRegion/:gameId',
            templateUrl: '/views/game.html',
            controller: 'GameController',
            controllerAs: '$ctrl',
        }).state('buildEdit', {
            url: '/build/:buildId/edit',
            templateUrl: '/views/buildEdit.html',
            controller: 'BuildEditController',
            controllerAs: '$ctrl'
        })
    ;
}]);
