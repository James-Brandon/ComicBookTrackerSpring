(function() {
  'use strict';


  angular
    .module('app')
    .controller('mainController', ["$scope", "mainService", function($scope, mainService){
      console.log("hello");

      $scope.hello = "Hello World";

      $scope.login = function(){
        var userName = $scope.user;
        var password = $scope.pass;
        console.log(userName, password);
      }

  }])
}());
