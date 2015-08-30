'use strict';

app.controller('gameCtrl', function ($scope, $rootScope, $stateParams, gameSrv) {

    $rootScope.header = {
        title: 'Game n°' + $stateParams.gameId + ' (' + $stateParams.gameRegion + ')'
    };

    $scope.game = {};

    gameSrv.getById($stateParams.gameId, $stateParams.gameRegion).then(function (result) {
        $scope.game = result.data;
    });

});