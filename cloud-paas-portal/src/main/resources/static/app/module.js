(function(){
	'use strict'
	angular
		.module("app.layout")
		.service("httpService",httpService);
		
		httpService.$inject = ['$http', '$q'];
		
		function httpService($http, $q) {
			var _this = this;
			var data;
			this.httpRequest = httpRequest;
			
			function httpRequest(httpParam) {
				var defer = $q.defer();
				var _httpParam = {
					type: "POST",
					async: true,
					dataType:"json",
					headers: {
						'Content-Type': 'application/json'
					}
				};
				
				if (httpParam) {
					for (var item in httpParam) {
						if (httpParam[item]) {
							_httpParam[item] = httpParam[item];
						}
					}
				}
				
				if (typeof httpParam.success  == "function") {
					_httpParam.success = function(response) {
						httpParam.success(response);
						data = response;
						defer.resolve(response);
					};
				}else {
					_httpParam.success = function(response) {
						data = response;
					};
					_httpParam.error = function(error) {
						console.log(error);
					};
				}
				
				if (typeof httpParam.async == "boolean") {
					_httpParam.async = httpParam.async;
				}
				
				$.ajax(_httpParam);
				return defer.promise;
			}
		}
})();

(function(){
	'use strict'
	angular
		.module("app.layout")
		.controller("headerController",headerController);
		
		headerController.$inject = ['$scope'];
		
		function headerController($scope) {
			//$scope.name="Logo";
		}
})();


(function(){
	'use strict'
	angular
		.module("app.router")
		.constant("constant",{"name":"Joker","age":41})
		.config(routerConfig)
	
		function routerConfig($stateProvider, $urlRouterProvider){
			$urlRouterProvider.otherwise('/login');
			angular.forEach(appConfig.router, function(oRoute,index){
				var loadArr = [];
				loadArr.push("app/"+oRoute.name+"/service/"+oRoute.name+"Service.js");
				loadArr.push("app/"+oRoute.name+"/controllers/"+oRoute.name+"Controllers.js");
				$stateProvider.state(oRoute.name,{
					url: oRoute.url,
					views: {
						"content": {
							"templateUrl": "app/"+oRoute.name+"/views/"+oRoute.name+".html"
						}
					},
					resolve: {
						deps:['$ocLazyLoad', function($ocLazyLoad){
							return $ocLazyLoad.load(loadArr);
						}]
					}
				});
			});
		};
})();
