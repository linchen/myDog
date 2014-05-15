var myDogServices = angular.module('myDogServices', ['ngResource']);

myDogServices.factory('Product', ['$resource', function($resource) {
    return $resource('products/:productId.json', {}, {
        query: {method: 'GET', params: {productId: 'products'}, isArray:true}
    });
}]);


myDogServices.factory('shoppingCart', function() {

    //create shopping cart
    var myCart = new shoppingCart("MyDogStore");
    myCart.addCheckoutParameters("PayPal", "paypaluser@youremail.com");

    myCart.addCheckoutParameters("Google", "xxxxxxx",
        {
            ship_method_name_1: "UPS Next Day Air",
            ship_method_price_1: "20.00",
            ship_method_currency_1: "USD",
            ship_method_name_2: "UPS Ground",
            ship_method_price_2: "15.00",
            ship_method_currency_2: "USD"
        }
    );

    myCart.addCheckoutParameters("Stripe", "pk_test_xxxx",
        {
            chargeurl: "https://localhost:1234/processStripe.aspx"
        }
    );

    return {
        cart: myCart
    };
});