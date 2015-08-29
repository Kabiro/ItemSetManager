'use strict';

app.controller('loginCtrl', function ($scope, $rootScope, $state, summonerSrv, loginSrv) {
    $scope.summonerRegion = 'EUW';
    $scope.regions = [];

    summonerSrv.regions().then(function (result) {
        $scope.regions = result.data;
    });

    $scope.login = function (name, region) {
        summonerSrv.byName(name, region).then(function (result) {
            loginSrv.logIn(result.data);
            $rootScope.user = result.data;
            $state.go('home', {summoner: name, region: region});
        });
    };

});