'use strict';

/* Controllers */

var phonecatControllers = angular.module('phonecatControllers', []);

phonecatControllers.controller('PhoneListCtrl', function($scope, $http) {
  $http.get('api/phones.json').success(function(data) {
    $scope.phones = data;
  });

  $scope.orderProp = 'age';
});

// create the controller and inject Angular's $scope
phonecatControllers.controller('mainController', function($scope) {
    // create a message to display in our view
    $scope.message = 'Everyone come and see how good I look!';
});

phonecatControllers.controller('aboutController', function($scope) {
    $scope.message = 'Look! I am an about page.';
});

phonecatControllers.controller('contactController', function($scope) {
    $scope.message = 'Contact us! JK. This is just a demo.';
});
