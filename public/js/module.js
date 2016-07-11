(function() {
  'use strict';
  angular
    .module('app', [
      'ngRoute',
    ])
    .config(function($routeProvider){
        $routeProvider
          .when('/',{
            templateUrl:'views/home.html',
            controller:'mainController as mainCTRL'
          })
          .when('/home', {
            templateUrl:'views/mycollection.html',
            controller:'userController as userCTRL'
          })
        });
}());
