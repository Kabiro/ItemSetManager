'use strict';

app.service('championsSrv', function ($rootScope, $http) {

    this.champions = $http.get('/api/champions/v1/champions');

});