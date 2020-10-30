(function (angular) {
    'use strict';
    angular.module('retrievalSystem.home',[
        'ngRoute'
    ]).config(['$routeProvider',function($routeProvider) {
        $routeProvider.when('/home',{
            templateUrl: 'home/home.html',
            controller: 'homeCtrl'
        })
    }]).controller('homeCtrl', ['$scope','$location', function($scope,$location){
        
        //
    }]);
})(angular);