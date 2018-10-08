'use strict';

angular.
  module('userList').
  component('userList', {
    templateUrl: 'user-list/user-list.template.html',
    controller: ['$http', function UserListController($http) {
      var self = this;
      self.orderProp = 'name';

      $http.get('users/users.json').then(function(response) {
        self.users = response.data;
      });
    }]
  });