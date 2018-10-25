'use strict';

angular.
module('cartItems').
component('cartItems', {
   templateUrl: 'cart-items/cart-items.template.html',
    controller: ['$http', '$scope', function CartController($http, $scope) {
        
        var self = this;
        
        $http.get('http://localhost:3000/cart').then(function (response) {
           self.cart = response.data; 
        });
    }]
});