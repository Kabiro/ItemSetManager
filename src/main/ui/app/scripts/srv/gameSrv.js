'use strict';

app.service('gameSrv', function ($http) {

    this.recentByUser = function (username, region) {
        return $http.get('/api/games/v1/' + username + '/' + region + '/recents/');
    };

});