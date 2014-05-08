'use strict';

/* Controllers */

var myDogControllers = angular.module('myDogControllers', []);

myDogControllers.controller('PhoneListCtrl', function($scope, $http) {
  $http.get('api/phones.json').success(function(data) {
    $scope.phones = data;
  });
  $scope.orderProp = 'age';
});

// create the controller and inject Angular's $scope
myDogControllers.controller('mainController', function($scope) {
    // create a message to display in our view
    $scope.message = 'Everyone come and see how good I look!';
});

myDogControllers.controller('aboutController', function($scope) {
    $scope.message = 'Look! I am an about page.';
});

myDogControllers.controller('contactController', function($scope) {
    $scope.message = 'Contact us! JK. This is just a demo.';
});

myDogControllers.controller('ProductListCtrl', function($scope, $http) {
    $http.get('api/products').success(function(data){
        $scope.products = data;
    });
});

myDogControllers.controller('productDetailCtrl', ['$scope','$routeParams','$http', function($scope, $routeParams, $http){
    $http.get('api/products/' + $routeParams.productId).success(function(data){
        $scope.productId = $routeParams.productId;
        $scope.product = data;

    });
}]);
