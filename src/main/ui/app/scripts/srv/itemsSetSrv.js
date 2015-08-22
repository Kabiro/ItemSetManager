'use strict';

app.service('itemsSetSrv', function ($http) {

    this.getByUser = function (username, region) {
        return $http.get('/api/sets/v1/' + username + '/' + region + '/');
    };

});