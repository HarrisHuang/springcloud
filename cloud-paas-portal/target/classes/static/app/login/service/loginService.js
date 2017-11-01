(function(){
	"use strict";
	angular
		.module("app.login")
		.service("loginService",loginService)
	
	loginService.$inject = ["$http", "$q", "httpService"];

	function loginService($http, $q, httpService) {
		this.login = login;
		function login(searchParam) {
			return httpService.httpRequest({
				url:"auth/login",
				async: true,
				type:"POST",
				data:JSON.stringify(searchParam),
				success:function(data) {
					//console.log("login data:",data);
				}
			});
		}
		
		
	}
})()