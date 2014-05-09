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
                controller: 'mainCtrl'
            }).
            when('/about', {
                templateUrl: 'pages/about.html',
                controller: 'aboutCtrl'
            }).
            when('/contact', {
                templateUrl: 'pages/contact.html',
                controller: 'contractCtrl'
            }).
            when('/shop', {
                templateUrl:'pages/product-list.html',
                controller:'ProductListCtrl'
            }).
            when('/products/:productId', {
                templateUrl:'pages/product-detail.html',
                controller:'ProductDetailCtrl'
            });
    }]);