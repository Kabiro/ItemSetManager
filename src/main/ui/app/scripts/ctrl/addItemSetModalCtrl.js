'use strict';

app.controller('addItemSetModalCtrl', function ($scope, $modalInstance, itemSet) {
    $scope.itemSet = itemSet;

    $scope.ok = function () {
        $modalInstance.close($scope.itemSet);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss();
    };
});