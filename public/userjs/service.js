(function() {
  'use strict';
    angular
      .module("app")
      .factory("userService", ["$http", function($http){
        var myComics = [];
        var getComics = function(){
          $http.get('/comics').then(function(data){
            console.log(data);
            //angular.copy(data.data, myComics)
          })

          return myComics
        }

        return {
          getComics : getComics
        }
      }])

}());
