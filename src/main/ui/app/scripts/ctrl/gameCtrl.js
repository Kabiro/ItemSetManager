'use strict';

app.controller('gameCtrl', function ($scope, $rootScope, $stateParams, $modal, gameSrv, itemsSetSrv, championsSrv) {

    $rootScope.header = {
        title: 'Game n°' + $stateParams.gameId + ' (' + $stateParams.gameRegion + ')'
    };

    $scope.game = {};
    $scope.itemSets = {};

    gameSrv.getById($stateParams.gameId, $stateParams.gameRegion).then(function (result) {
        $scope.game = result.data;
    });

    itemsSetSrv.getByGame($stateParams.gameId, $stateParams.gameRegion).then(function (result) {
        $scope.itemSets = result.data;
    });

    $scope.createItemSet = function(user, championId, itemSet){
        championsSrv.champions.then(function (result) {

            $modal.open({
                animation: true,
                size: 'sm',
                templateUrl: 'template/modal/addItemSetModal.html',
                controller: 'addItemSetModalCtrl',
                resolve: {
                    itemSet: function(){return itemSet;}
                }
            }).result.then(function () {
                    var championKey = result.data[championId].key;
                    itemsSetSrv.create(user.name, user.region, championKey, itemSet);
                }, function () {
                });
        });
    };

});