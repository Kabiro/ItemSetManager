'use strict';

app.service('itemsSetSrv', function ($http) {

    this.buildsByUser = function (username, region) {
        return $http.get('/api/sets/v1/' + region + '/' + username);
    };

    this.followedBuildsByUser = function (username, region) {
        return $http.get('/api/sets/v1/' + region + '/' + username + '/followed');
    };

    this.followBuild = function (username, region, buildId) {
        return $http.put('/api/sets/v1/' + region + '/' + username + '/followed/' + buildId, null);
    };

    this.unfollowBuild = function (username, region, buildId) {
        return $http.delete('/api/sets/v1/' + region + '/' + username + '/followed/' + buildId, null);
    };

    this.getByGame = function (gameId, region) {
        return $http.get('/api/sets/v1/game/' + region + '/' + gameId);
    };

    this.getById = function (id) {
        return $http.get('/api/sets/v1/' + id);
    };

    this.create = function(summoner, region, champions, itemSet){
        console.log(summoner, region, champions, itemSet);
        return $http.put('/api/sets/v1/', itemSet, {params : {summonerName: summoner, summonerRegion: region, champions: champions}});
    };

    this.delete = function(itemSetId){
        return $http.delete('api/sets/v1/' + itemSetId);
    };

});