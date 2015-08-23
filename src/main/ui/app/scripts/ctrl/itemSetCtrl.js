'use strict';

app.controller('itemSetCtrl', function ($scope, $stateParams, itemsSetSrv) {
    $scope.build = {};

    itemsSetSrv.getById($stateParams.itemSetId).then(function (result) {
        $scope.build = result.data;
    });
});