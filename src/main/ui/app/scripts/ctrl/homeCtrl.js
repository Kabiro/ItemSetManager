'use strict';

app.controller('homeCtrl', function ($scope, $state, $stateParams, utils, itemsSetSrv, gameSrv) {

    if (utils.isEmpty($stateParams.summoner) || utils.isEmpty($stateParams.region)) {
        $state.go('login');
    }

    $scope.builds = [];
    $scope.recentGames = [];
    $scope.itemsSetsFromGame = [];
    $scope.summoner = {
        name: $stateParams.summoner,
        region: $stateParams.region
    };

    itemsSetSrv.buildsByUser($scope.summoner.name, $scope.summoner.region).then(function (result) {
        $scope.builds = result.data;
    });

    gameSrv.recentByUser($scope.summoner.name, $scope.summoner.region).then(function (result) {
        $scope.recentGames = result.data;
    });

    $scope.itemsSetByGame = function (gameId) {
        itemsSetSrv.getByGame(gameId, $scope.summoner.region).then(function (result) {
            $scope.itemsSetsFromGame = result.data;
        });
    };

});