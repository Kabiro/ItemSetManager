'use strict';

app.controller('homeCtrl', function ($scope, $state, $stateParams, utils, itemsSetSrv, gameSrv, summonerSrv) {

    if (utils.isEmpty($stateParams.summoner) || utils.isEmpty($stateParams.region)) {
        $state.go('login');
    }

    $scope.builds = [];
    $scope.recentGames = [];
    $scope.summoner = {
        name: $stateParams.summoner,
        region: $stateParams.region
    };

    summonerSrv.byName($scope.summoner.name, $scope.summoner.region).then(function (result) {
        $scope.summoner = result.data;

        itemsSetSrv.buildsByUser($scope.summoner.name, $scope.summoner.region).then(function (result) {
            $scope.builds = result.data;
        });

        gameSrv.recentByUser($scope.summoner.name, $scope.summoner.region).then(function (result) {
            $scope.recentGames = result.data;
        });
    });

    $scope.copyToClipboard = function(selector){
        document.querySelector(selector).select();
        document.execCommand('copy');
    };
});