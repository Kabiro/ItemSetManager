'use strict';

app.controller('buildEditCtrl', function ($scope, $rootScope, $stateParams, $timeout, itemsSetSrv) {
    $scope.build = {};

    $rootScope.header = {};

    $scope.json = '';
    $scope.champions = '';
    $scope.success = false;


    itemsSetSrv.getById($stateParams.buildId).then(function(result){
        $scope.build = result.data;
        $rootScope.header.title = result.data.itemSet.title;

        $scope.json = angular.toJson(result.data.itemSet, true);
        $scope.champions = angular.toJson(_.map(result.data.champions, function(champion){return champion.key;}), true);
    });

    $scope.update = function(){
        var itemSet = angular.fromJson($scope.json);
        var champions = angular.fromJson($scope.champions);
        itemsSetSrv.update($scope.build.id, itemSet, champions).then(function(result){
            $scope.build = result.data;

            $scope.json = angular.toJson(result.data.itemSet, true);
            $scope.champions = angular.toJson(_.map(result.data.champions, function(champion){return champion.key;}), true);
            $scope.success = true;
            $timeout(function(){
                $scope.success = false;
            }, 3000);
        });
    }
});