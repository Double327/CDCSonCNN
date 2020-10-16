(function (angular) {
    'use strict';
    angular.module('retrievalSystem.login',[
        'ngRoute'
    ]).config(['$routeProvider',function($routeProvider) {
        $routeProvider.when('/login',{
            templateUrl: 'login/login.html',
            controller: 'loginCtrl'
        })
    }]).controller('loginCtrl', ['$scope','$location','$window','$routeParams','$http', function($scope,$location,$routeParams,$window,$http){
        //初始化定义
        $scope.user={
            uuid:'',
            password:'',
            code:'',
            type:1,
        };
        $scope.info={
            codeImage:'',
        };
        $scope.user_type={
            type1:{
                name:'学生',
                id:1,
            },
            type2:{
                name:'教师',
                id:2,
            },
            type3:{
                name:'管理员',
                id:3,
            },
        };
        var address="";
        //----------初始化开始----------
        //读取到local信息跳转
        if(localStorage.getItem("uuid")!==null){
            $location.path("/"+$routeParams.search_key);
        }
        //读取config
        $http({
            url:'config.json',//验证表单的接口
            method:'get',
            headers:{
            'Content-Type':'application/json;charset=UTF-8',
            }, //将其变为 json 参数形式
        }).then(function successCallback(data) {
            address=data.data.address;
            gc();
        }, function errorCallback(response) {
            alert("error!\n"+"error message:"+response);
        });
        
        //----------初始化结束----------
        //登录
        $scope.login=function(){
            console.log("登录");
            localStorage.setItem("uuid","123456");
            // console.log($scope.user);
            // console.log($scope.user_type);
            //验证数据合法性
            //登录请求
            $http({
                url:'/loginAction',//验证表单的接口
                method:'post',
                data:$scope.user,
                headers:{'Content-Type':'application/json;charset=UTF-8'}, //将其变为 json 参数形式
            }).then(function successCallback(data) {
                if (data.data.uuid===null){
                    alert("登录失败！请检查帐号密码后再次尝试！");
                    return;
                }
                //
                // console.log(data.data);
                alert("登录成功！页面即将跳转，如果没有跳转请手动刷新！");
                $window.location.reload();
            }, function errorCallback(response) {
                alert("error!\n"+"error message:"+response);
            });
            window.location.reload();
        };
        //获取验证码
        $scope.getCode=gc;
        function gc(){
            $http({
                url:address+'/captchaImage/?format=json&callback=JSON_CALLBACK',//验证表单的接口
                method:'get',
                headers:{
                'Content-Type':'application/json;charset=UTF-8',
                }, //将其变为 json 参数形式
            }).then(function successCallback(data) {
                $scope.info.codeImage=data.data.img;
            }, function errorCallback(response) {
                alert("error!\n"+"error message:"+response);
            });
        }

        //
    }]);
})(angular);