'use strict';

app.directive('lolImage', function () {

    var baseUrl = 'https://ddragon.leagueoflegends.com/cdn/';
    var lolVersion = '7.9.2';

    var championIdToChampionKey = function (id, champions) {
        return champions[id].key;
    };
    var identity = function (id) {
        return id;
    };

    var configs = {
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
        controller: function ($scope, championsSrv) {
            championsSrv.champions.then(function (result) {
                var champions = result.data;
                $scope.imageUrl = baseUrl;
                var config = configs[$scope.type];
                if (config.version) {
                    $scope.imageUrl += lolVersion + '/';
                }
                $scope.imageUrl += config.prefix + config.transformFunction($scope.id, champions) + config.suffix;
            });
        }
    };
});