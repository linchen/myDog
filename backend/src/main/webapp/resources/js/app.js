'use strict';

/* App Module */

var phonecatApp = angular.module('phonecatApp', [
    'ngRoute',
    'phonecatControllers'
]);

phonecatApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/', {
                templateUrl: 'pages/home.html',
                controller: 'mainController'
            }).
            when('/about', {
                templateUrl: 'pages/about.html',
                controller: 'aboutController'
            }).
            when('/contact', {
                templateUrl: 'pages/contact.html',
                controller: 'contractController'
            }).
            when('/phones', {
                templateUrl: 'pages/phone-list.html',
                controller: 'PhoneListCtrl'
            }).
            otherwise({
                redirectTo: '/'
            });
    }]);