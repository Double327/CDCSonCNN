(function (angular){
	'use strict';
	//路由管理
	var app=angular.module('retrievalSystem',[
		'ngRoute',
        'retrievalSystem.login',
		'retrievalSystem.home',
        'retrievalSystem.teacher',
        'retrievalSystem.projects',
        'retrievalSystem.userinfo',
        'retrievalSystem.admin',
	]);
	// app.config('$routeProvider',function($routeProvider){
	
	// 	 $routeProvider.otherwise({redirectTo:'/login'});
	// });
	// 	//乱写内容路由回home页
	app.config(['$routeProvider', function($routeProvider){
	  $routeProvider.otherwise({redirectTo:'/home'});
	}]);
	//防止路由翻墙功能
	app.run(['$rootScope', '$location', function($rootScope, $location) {
        /* 监听路由的状态变化 */
        $rootScope.$on('$routeChangeStart', function(evt, next, current){
            // console.log('route begin change');//开始变化
        });
        $rootScope.$on('$routeChangeSuccess', function(evt, current, previous) {
            // console.log('route have already changed ：'+$location.path());//变化结束
            //如果登录过后访问登录/注册
            // if(($location.path()==='/login'||$location.path()==="/register")&&sessionStorage.getItem("uuid")!=null){
            //     $location.path("/home");
            //     return;
            // }
            // //没有登录访问个人信息和购物车
            // if(($location.path()==="/userinfo"||$location.path()==="/cart")&& sessionStorage.getItem("uuid")===null){
            //     $location.path("/login");
            //     return;
            // }
        });
        //结束标志
    }]);
    //ng控制
    app.controller('indexCtrl',['$scope','$location','$window',function($scope,$location,$window){
        var title_default="毕业设计分析系统";
        $scope.user={
            status:false,
        };
        $scope.info={
            title: title_default,
        };
        //进入主页加载用户信息
        if(localStorage.getItem("uuid")!==null){
            $scope.user.status=true;
        }else{
            $scope.user.status=false;
        }
        //去登录页面或者个人信息页面
        $scope.gotoLogin=function(){
            console.log(localStorage.getItem("uuid"));
            if(localStorage.getItem("uuid")!==null){
                console.log("用户已经登陆");
                $scope.user.status=true;
            }
            else{
                if($location.path()==='/login')
                    return;
                var from=$location.path();
                $location.path('/login').search({"from":from.substring(1,from.length)});
                $scope.user.status=false;
                $scope.info.title=title_default+" - 登录"
            }

        };
        //回到主页
        $scope.gohome=function(){
            $scope.info.title=title_default;
        };
        //退出登录
        $scope.logout=function(){
            localStorage.clear();
            alert("退出成功！如果页面没有刷新请手动刷新页面！");
            $window.location.reload();
        };
        //用户操作
        $scope.operation=function(option){
            switch(option){
                case 1:{
                    $scope.info.title=title_default+" - 项目仓库";
                    $location.path("/projects");
                    break;
                };
                case 2:{
                    $scope.info.title=title_default+" - 个人信息";
                    $location.path("/userinfo");
                    break;
                };
                case 3:{
                    $scope.info.title=title_default+" - 教师功能";
                    $location.path("/teacher");
                    break;
                };
                case 4:{
                    $scope.info.title=title_default+" - 网站管理";
                    $location.path("/admin");
                    break;
                };
                default:{
                    break;
                }
            }
        }
        //

    
    	//结束标志
    }]);
})(angular)