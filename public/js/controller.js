(function() {
  'use strict';


  angular
    .module('app')
    .controller('mainController', ["$scope", "mainService", function($scope, mainService){

      $scope.hello = "Hello World";
      $scope.likes = 10;
      $scope.title = "PHILL MURRAY"

      $scope.login = function(){
        mainService.login($scope.user, $scope.pass).then(function(data){
          console.log(data);
        })
      }

      $scope.comicCollection = mainService.getComics();
      $scope.incLikes = function(comic){
        mainService.incLikes(comic);
      }

  }])
}());
