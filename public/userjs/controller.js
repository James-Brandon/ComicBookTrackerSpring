(function() {
  'use strict';
    angular
    .module('app')
    .controller('userController', ['$scope', 'userService' function($scope, userService){


      $scope.myComics = userService.getComics();

    }])
}());
