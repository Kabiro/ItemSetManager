'use strict';

app.controller('mainCtrl', function ($rootScope, loginSrv) {

    var cookieUser = loginSrv.getUser();
    if (cookieUser) {
        $rootScope.user = cookieUser;
    }

    $rootScope.logout = function () {
        loginSrv.logout();
        delete $rootScope.user;
    };

});