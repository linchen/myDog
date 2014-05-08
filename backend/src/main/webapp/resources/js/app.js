'use strict';

/* App Module */

var myDogApp = angular.module('myDogApp', [
    'ngRoute',
    'myDogControllers'
]);

myDogApp.config(['$routeProvider',
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
            when('/shop', {
                templateUrl:'pages/product-list.html',
                controller:'ProductListCtrl'
            }).
            when('/products/:productId', {
                templateUrl:'pages/product-detail.html',
                controller:'productDetailCtrl'
            });

    }]);