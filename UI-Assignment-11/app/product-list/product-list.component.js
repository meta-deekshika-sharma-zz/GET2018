'use strict';

angular.module('productList').
component('productList', {
   templateUrl: 'product-list/product-list.template.html',
   controller: ['$http', '$scope', '$rootScope', function productsController($http, $scope, $routScope) {
       var self = this;
       
       $http.get('http://localhost:3000/products').then(function (response) {
           self.products = response.data;
       });
       
       $scope.addToCart = function(product) {
           debugger;
            $http.get('http://localhost:3000/cart/' + product.id).then(function successCallback(response) {

                $http({
                    method: 'PUT',
                    url: 'http://localhost:3000/cart/' + product.id,
                    data: response.data,
                    dataType: 'json'
                });
            }, function errorCallback(response) {

                var cartItem = {
                    "id": product.id,
                    "title": product.title,
                    "price": product.price,
                    "imageUrl": product.imageUrl
                }

                $http({
                    method: 'POST',
                    url: 'http://localhost:3000/cart/',
                    data: cartItem,
                    dataType: 'json'
                });

            });
        }
}]
});