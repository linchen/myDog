'use strict';

/* Controllers */

var myDogControllers = angular.module('myDogControllers', []);

// create the controller and inject Angular's $scope
myDogControllers.controller('mainCtrl', ['$scope','shoppingCart', function($scope, shoppingCart) {
   $scope.myInterval=5000;
    var slides = $scope.slides = [];
    slides.push({image: 'img/IMG_65044-sm.jpg'});
    slides.push({image: 'img/IMG_6910-sm.jpg'});
    slides.push({image: 'img/IMG_6702-sm.jpg'});
    slides.push({image: 'img/IMG_6644-(1)-sm.jpg'});
    slides.push({image: 'img/IMG_6337-sm.jpg'});
    slides.push({image: 'img/IMG_5339-sm.jpg'});
    slides.push({image: 'img/IMG_5148-(1)-sm.jpg'});
    $scope.cart = shoppingCart.cart;
}]);

myDogControllers.controller('aboutCtrl', ['$scope', function($scope) {
    $scope.message = 'Look! I am an about page.';
}]);

myDogControllers.controller('contactCtrl', ['$scope', function($scope) {
    $scope.message = 'Contact us! JK. This is just a demo.';
}]);

myDogControllers.controller('ProductListCtrl', ['$scope', 'Product','shoppingCart', function($scope, Product, shoppingCart) {
    $scope.products = Product.query();
    $scope.orderProp = 'age';
    $scope.cart = shoppingCart.cart;
}]);

myDogControllers.controller('ProductDetailCtrl', ['$scope', '$routeParams', 'Product', 'shoppingCart', function($scope, $routeParams, Product, shoppingCart) {
    $scope.product = Product.get({productId: $routeParams.productId}, function(product) {
       $scope.mainImageUrl = product.images[0];
    });
    $scope.setImage = function(imageUrl) {
        $scope.mainImageUrl = imageUrl;
    }
    $scope.cart = shoppingCart.cart;
}]);
