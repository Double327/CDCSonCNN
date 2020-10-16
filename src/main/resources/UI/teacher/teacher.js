(function (angular) {
    'use strict';
    angular.module('retrievalSystem.teacher',[
        'ngRoute'
    ]).config(['$routeProvider',function($routeProvider) {
        $routeProvider.when('/teacher',{
            templateUrl: 'teacher/teacher.html',
            controller: 'teacherCtrl'
        })
    }]).controller('teacherCtrl', ['$scope','$location','$window','$routeParams','$http', function($scope,$location,$routeParams,$window,$http){
        $scope.student=[];
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
        $scope.getStudent=function(){
            $http({
                url:address+'/student/list/?format=json&callback=JSON_CALLBACK',//验证表单的接口
                method:'get',
                params:{
                    'pageSize':'30',
                    'pageNum':'1',
                },
                headers:{
                'Content-Type':'application/json;charset=UTF-8',
                }, //将其变为 json 参数形式
            }).then(function successCallback(data) {
                // console.log(data);
                $scope.student=data.data.rows;
                console.log($scope.student);
            }, function errorCallback(response) {
                alert("error!\n"+"error message:"+response);
            });
        }

        //
    }]);
})(angular);