'use strict';

/* Controllers */

var myDogControllers = angular.module('myDogControllers', []);

// create the controller and inject Angular's $scope
myDogControllers.controller('mainCtrl', ['$scope', function($scope) {
   $scope.myInterval=5000;
    var slides = $scope.slides = [];
    slides.push({image: 'img/IMG_65044-sm.jpg'});
    slides.push({image: 'img/IMG_6910-sm.jpg'});
    slides.push({image: 'img/IMG_6702-sm.jpg'});
    slides.push({image: 'img/IMG_6644-(1)-sm.jpg'});
    slides.push({image: 'img/IMG_6337-sm.jpg'});
    slides.push({image: 'img/IMG_5339-sm.jpg'});
    slides.push({image: 'img/IMG_5148-(1)-sm.jpg'});
}]);

myDogControllers.controller('aboutCtrl', ['$scope', function($scope) {
    $scope.message = 'Look! I am an about page.';
}]);

myDogControllers.controller('contactCtrl', ['$scope', function($scope) {
    $scope.message = 'Contact us! JK. This is just a demo.';
}]);

myDogControllers.controller('ProductListCtrl', ['$scope', 'Product', function($scope, Product) {
    $scope.products = Product.query();
    $scope.orderProp = 'age';
}]);

myDogControllers.controller('ProductDetailCtrl', ['$scope', '$routeParams', 'Product', function($scope, $routeParams, Product) {
    $scope.product = Product.get({productId: $routeParams.productId}, function(product) {
       $scope.mainImageUrl = product.images[0];
    });
    $scope.setImage = function(imageUrl) {
        $scope.mainImageUrl = imageUrl;
    }
}]);
