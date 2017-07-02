import {ChampionsService} from "../srv/ChampionsService";

export const LolImageDirective = [() => {
    const baseUrl = 'https://ddragon.leagueoflegends.com/cdn/';
    const lolVersion = '7.13.1';

    const championIdToChampionKey = function (id: any, champions: any) {
        return champions[id].key;
    };
    const identity = function (id: any) {
        return id;
    };

    const configs: any = {
        profile: {
            version: true,
            prefix: 'img/profileicon/',
            suffix: '.png',
            transformFunction: identity
        },
        championSplash: {
            version: false,
            prefix: 'img/champion/splash/',
            suffix: '_0.jpg',
            transformFunction: championIdToChampionKey
        },
        championLoading: {
            version: false,
            prefix: 'img/champion/loading/',
            suffix: '_0.jpg',
            transformFunction: championIdToChampionKey
        },
        championSquare: {
            version: true,
            prefix: 'img/champion/',
            suffix: '.png',
            transformFunction: championIdToChampionKey
        },
        item: {
            version: true,
            prefix: 'img/item/',
            suffix: '.png',
            transformFunction: identity
        }
    };

    return {
        restrict: 'AE',
        templateUrl: 'template/directives/lolImage.html',
        scope: {
            id: '=',
            type: '='
        },
        controller: ['$scope', 'ChampionsService', ($scope: ng.IScope, championsService: ChampionsService) =>  {
            championsService.champions.then((result) => {
                const champions = result.data;
                $scope.imageUrl = baseUrl;
                const config = configs[$scope.type];
                if (config.version) {
                    $scope.imageUrl += lolVersion + '/';
                }
                $scope.imageUrl += config.prefix + config.transformFunction($scope.id, champions) + config.suffix;
            });
        }]
    };
}];
