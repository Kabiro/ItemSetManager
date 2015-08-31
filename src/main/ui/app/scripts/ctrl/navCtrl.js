'use strict';

app.controller('navCtrl', function ($scope, $rootScope, $state, loginSrv, summonerSrv) {
    $scope.userRegion = 'EUW';
    $scope.regions = [];

    var cookieUser = loginSrv.getUser();
    if (cookieUser) {
        $rootScope.user = cookieUser;
    }

    summonerSrv.regions().then(function (result) {
        $scope.regions = result.data;
    });

    $scope.logout = function () {
        loginSrv.logout();
        delete $rootScope.user;
    };


    $scope.login = function (name, region) {
        summonerSrv.byName(name, region).then(function (result) {
            loginSrv.logIn(result.data);
            $rootScope.user = result.data;
            if ($state.current.name === 'home' || $state.current.name === 'homeBis'){
                $state.go('summoner', {summoner: name, region: region});
            }
        });
    };


});