'use strict';

var app = angular.module('ItemSetManager', ['ngCookies', 'ui.router', 'ui.bootstrap']);

app.config(function ($stateProvider) {

    $stateProvider
        .state('summoner', {
            url: '/summoner/:region/:summoner',
            templateUrl: '/views/summoner.html',
            controller: 'homeCtrl'
        }).state('login', {
            url: '/',
            templateUrl: '/views/login.html',
            controller: 'loginCtrl'
        }).state('loginBis', {
            url: '',
            templateUrl: '/views/login.html',
            controller: 'loginCtrl'
        }).state('itemSet', {
            url: '/itemSet/:itemSetId',
            templateUrl: '/views/itemSet.html',
            controller: 'itemSetCtrl'
        })
    ;
});
