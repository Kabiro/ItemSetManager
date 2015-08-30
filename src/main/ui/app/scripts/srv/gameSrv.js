'use strict';

app.service('gameSrv', function ($http) {

    this.recentByUser = function (username, region) {
        return $http.get('/api/games/v1/' + region + '/' + username + '/recents');
    };

    this.getById = function (id, region) {
        return $http.get('/api/games/v1/' + region + '/' + id + '/details');
    };

});