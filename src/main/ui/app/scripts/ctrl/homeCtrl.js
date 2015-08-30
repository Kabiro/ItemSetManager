'use strict';

app.controller('homeCtrl', function ($scope, $rootScope, $state, summonerSrv) {
    $scope.summonerRegion = 'EUW';
    $scope.regions = [];

    $rootScope.header = {};

    summonerSrv.regions().then(function (result) {
        $scope.regions = result.data;
    });

    $scope.searchSummoner = function (name, region) {
        $state.go('summoner', {summoner: name, region: region});
    };

});