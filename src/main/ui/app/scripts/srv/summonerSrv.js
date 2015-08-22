'use strict';

app.service('summonerSrv', function ($http) {

    this.regions = function () {
        return $http.get('/api/summoners/v1/regions/');
    };

});