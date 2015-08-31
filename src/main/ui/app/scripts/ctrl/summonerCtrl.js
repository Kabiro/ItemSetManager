'use strict';

app.controller('summonerCtrl', function ($scope, $rootScope, $state, $stateParams, $modal, utils, itemsSetSrv, gameSrv, summonerSrv) {

    if (utils.isEmpty($stateParams.summoner) || utils.isEmpty($stateParams.region)) {
        $state.go('home');
    }

    $rootScope.header = {
        title: $stateParams.summoner + ' (' + $stateParams.region + ')'
    };
    $scope.builds = [];
    $scope.followedBuilds = [];
    $scope.userFollowedBuilds = [];
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

        itemsSetSrv.followedBuildsByUser($scope.summoner.name, $scope.summoner.region).then(function (result) {
            $scope.followedBuilds = result.data;
        });

        gameSrv.recentByUser($scope.summoner.name, $scope.summoner.region).then(function (result) {
            $scope.recentGames = result.data;
        });

        if ($rootScope.user){
            itemsSetSrv.followedBuildsByUser($rootScope.user.name, $rootScope.user.region).then(function (result) {
                $scope.userFollowedBuilds = _.map(result.data, function (build) {
                    return build.id;
                });
            });
        }
    });

    $scope.copyToClipboard = function (selector) {
        document.querySelector(selector).select();
        document.execCommand('copy');
    };

    $scope.followBuild = function (buildId) {
        itemsSetSrv.followBuild($scope.user.name, $scope.user.region, buildId).then(function () {
            $scope.userFollowedBuilds.push(buildId);
        });
    };

    $scope.unfollowBuild = function (buildId) {
        itemsSetSrv.unfollowBuild($scope.user.name, $scope.user.region, buildId).then(function () {
            $scope.userFollowedBuilds.splice($scope.userFollowedBuilds.indexOf(buildId), 1);
        });
    };

    $scope.delete = function(buildId){
        $modal.open({
            animation: true,
            size: 'sm',
            templateUrl: 'template/modal/validateModal.html',
            controller: 'validateModalCtrl',
            resolve: {
                text: function(){return 'Are you sure you want to delete this itemSet?';}
            }
        }).result.then(function () {
            itemsSetSrv.delete(buildId).then(function(){
                $scope.builds = _.filter($scope.builds, function(build){return build.id !== buildId;});
            });
        }, function () {
        });
    };
});