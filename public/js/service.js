(function() {
  'use strict';
  angular
    .module('app')
      .factory('mainService', ["$http", function($http){
        var comicCollection = [];
        var mycollection = [{
          img:"http://www.fillmurray.com/200/300",
          uploader:"phill collins",
          title:"Phill Murray",
          blurb:"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
          likes:10
        },
        {
          img:"http://www.fillmurray.com/200/300",
          uploader:"tommy jefferson",
          title:"Phill my Murray",
          blurb:"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
          likes:13
        },
        {
          img:"http://www.fillmurray.com/200/300",
          uploader:"betty white",
          title:"Phill  you Murray",
          blurb:"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
          likes:16
        }];


        var login = function(user, pass){
          return $http.post('/login', {username: user, password: pass})
        }

        var getComics = function(){
          // $http.get('/comics').then(function(data){
          //   console.log(data);
          //   angular.copy(data.data, comicCollection)
          // })
          angular.copy(mycollection, comicCollection)
          return comicCollection;
        }

        var incLikes = function(comic){
          comicCollection[comicCollection.indexOf(comic)].likes++;
        }

        return {
          login: login,
          getComics: getComics,
          incLikes: incLikes
        }
      }])
}());
