'use strict';

app.controller('homeCtrl', function ($scope, $state, $stateParams, utils, itemsSetSrv) {

    if (utils.isEmpty($stateParams.summoner) || utils.isEmpty($stateParams.region)) {
        $state.go('login');
    }

    $scope.itemsSets = [];
    $scope.summoner = {
        name: $stateParams.summoner,
        region: $stateParams.region
    };


    itemsSetSrv.getByUser($scope.summoner.name, $scope.summoner.region).then(function (result) {
        $scope.itemsSets = result.data;
    });


});