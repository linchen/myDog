var myDogServices = angular.module('myDogServices', ['ngResource']);

myDogServices.factory('Product', ['$resource', function($resource) {
    return $resource('products/:productId.json', {}, {
        query: {method: 'GET', params: {productId: 'products'}, isArray:true}
    });
}]);