(function() {
  'use strict';
  angular
    .module('app', [
      'ngRoute',
    ])
    .config(function($routeProvider){
      console.log("here");
        $routeProvider
          .when('/',{
            templateUrl:'views/home.html',
            controller:'mainController as mainCTRL'
          });
        });
}());
