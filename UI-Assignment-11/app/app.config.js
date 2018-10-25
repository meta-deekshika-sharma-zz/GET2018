'use strict';

angular.
module('shoppingApp').
config(['$routeProvider', function config($routeProvider) {
    
    $routeProvider.
    when('/home', {
        template: '<product-list></product-list>'
    }).
    when('/shopping-cart', {
        template: '<cart-items></cart-items>'
    }).
    when('/order-success', {
        template: '<order-success></order-success>'
    }).
    when('/check-out', {
        template: '<shipping-details></shipping-details>'
    }).
    when('/orders', {
        template: '<order-list></order-list>'
    }).
    otherwise('/home');
}
])