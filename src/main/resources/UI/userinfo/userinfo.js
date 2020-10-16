(function (angular) {
    'use strict';
    angular.module('retrievalSystem.userinfo',[
        'ngRoute'
    ]).config(['$routeProvider',function($routeProvider) {
        $routeProvider.when('/userinfo',{
            templateUrl: 'userinfo/userinfo.html',
            controller: 'userinfoCtrl'
        })
    }]).controller('userinfoCtrl', ['$scope','$location','$window','$routeParams','$http', function($scope,$location,$routeParams,$window,$http){
        var address="";
        //----------初始化开始----------
        //读取config
        $http({
            url:'config.json',//验证表单的接口
            method:'get',
            headers:{
            'Content-Type':'application/json;charset=UTF-8',
            }, //将其变为 json 参数形式
        }).then(function successCallback(data) {
            address=data.data.address;
        }, function errorCallback(response) {
            alert("error!\n"+"error message:"+response);
        });
        //----------初始化结束----------

        //
    }]);
})(angular);