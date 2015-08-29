'use strict';

app.service('loginSrv', function ($cookies) {

    this.logIn = function (user) {
        $cookies.putObject('user', user);
    };

    this.getUser = function () {
        return $cookies.getObject('user');
    };

    this.logout = function () {
        $cookies.remove('user');
    };
});