//The component part will executes all the functionalities of add, edit and displaying user data

angular.
  module('userList').
  component('userList', {
    templateUrl: 'user-list/user-list.template.html',
    controller: ['$http', '$scope', function UserListController($http, $scope) {
      var self = this;
       
      $scope.createUser = function() {
        $scope.header = "Add";
        self.user = {
          picture: "images//male-user-shadow_318-34042.jpg",
          name: null,
          phone: null,
          address: null
        }  
      }
      
      $scope.editUser = function(userIndex) {
         $scope.header = "Edit";
        
         if(userIndex != null) {
                self.user.name = self.users[userIndex].name;
                self.user.phone = self.users[userIndex].phone;
                self.user.address = self.users[userIndex].address;
                self.user.userIndex = userIndex;
          } 
      }

      $http.get('users/users.json').then(function(response) {
        self.users = response.data;
      });
        
      $scope.addUser = function() {
          if(self.user.userIndex != null)
                self.users[self.user.userIndex] = self.user;
          else if(self.user.name != null && self.user.phone != null && self.user.address != null)
                self.users.push(self.user);
          
          self.user = {
          picture: "images//male-user-shadow_318-34042.jpg",
          name: null,
          phone: null,
          address: null
        }  
      }
       
      $scope.searchUser = function() {
        self.query = document.getElementById("searchKeyword").value;
      }
    }]
  });
