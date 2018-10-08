'use strict';

angular.
  module('userApp').
  config(['$locationProvider' ,'$routeProvider',
    function config($locationProvider, $routeProvider) {

      $routeProvider.
        when('/users', {
          template: '<user-list></user-list>'
        }).
       /* when('/phones/:phoneId', {
          template: '<phone-detail></phone-detail>'
        }).*/
        otherwise('/users');
    }
  ]);