'use strict';

app.service('itemsSetSrv', function ($http) {

    this.buildsByUser = function (username, region) {
        return $http.get('/api/sets/v1/' + region + '/' + username);
    };

    this.getByGame = function (gameId, region) {
        return $http.get('/api/sets/v1/game/' + region + '/' + gameId);
    };

});