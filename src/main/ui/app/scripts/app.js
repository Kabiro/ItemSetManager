'use strict';

var app = angular.module('ItemSetManager', ['ui.router', 'ui.bootstrap']);

app.config(function ($stateProvider) {

    $stateProvider
        .state('home', {
            url: '',
            templateUrl: '/views/home.html',
            controller: 'homeCtrl'
        })
    ;
});
