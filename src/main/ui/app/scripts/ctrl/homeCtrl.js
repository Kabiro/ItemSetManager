'use strict';

app.controller('homeCtrl', function ($scope, $rootScope, $state, summonerSrv, loginSrv) {
    $scope.summonerRegion = 'EUW';
    $scope.regions = [];

    $rootScope.header = {};

    summonerSrv.regions().then(function (result) {
        $scope.regions = result.data;
    });

    $scope.login = function (name, region) {
        summonerSrv.byName(name, region).then(function (result) {
            loginSrv.logIn(result.data);
            $rootScope.user = result.data;
            $state.go('summoner', {summoner: name, region: region});
        });
    };

});