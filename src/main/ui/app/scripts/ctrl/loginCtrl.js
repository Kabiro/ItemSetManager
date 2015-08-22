'use strict';

app.controller('loginCtrl', function ($scope, $state, summonerSrv) {
    $scope.summonerRegion = 'EUW';
    $scope.regions = [];

    summonerSrv.regions().then(function (result) {
        $scope.regions = result.data;
    });

    $scope.login = function (name, region) {
        $state.go('home', {summoner: name, region: region});
    };

});