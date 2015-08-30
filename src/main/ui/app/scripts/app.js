'use strict';

var app = angular.module('ItemSetManager', ['ngCookies', 'ui.router', 'ui.bootstrap']);

app.config(function ($stateProvider) {

    $stateProvider
        .state('summoner', {
            url: '/summoner/:region/:summoner',
            templateUrl: '/views/summoner.html',
            controller: 'summonerCtrl'
        }).state('home', {
            url: '/',
            templateUrl: '/views/home.html',
            controller: 'homeCtrl'
        }).state('homeBis', {
            url: '',
            templateUrl: '/views/home.html',
            controller: 'homeCtrl'
        }).state('game', {
            url: '/game/:gameRegion/:gameId',
            templateUrl: '/views/game.html',
            controller: 'gameCtrl'
        })
    ;
});
