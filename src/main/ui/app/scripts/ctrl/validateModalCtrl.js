'use strict';

app.controller('validateModalCtrl', function ($scope, $modalInstance, text) {

    $scope.text = text;

    $scope.ok = function () {
        $modalInstance.close();
    };

    $scope.cancel = function () {
        $modalInstance.dismiss();
    };
});