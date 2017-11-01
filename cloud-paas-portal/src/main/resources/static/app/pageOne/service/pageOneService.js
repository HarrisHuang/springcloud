(function(){
	"use strict";
	angular
		.module("app.pageOne")
		.service("pageOneService",pageOneService)
	
	pageOneService.$inject = ["$http", "$q", "httpService"];

	function pageOneService($http, $q, httpService) {
		this.getData = getData;
		
		function getData() {
			var accountNumber ={accountNumberId:"1"};
			return httpService.httpRequest({
				url:"account/get",
				async: true,
				type:"POST",
				data:accountNumber.accountNumberId,
				success:function(data) {
					console.log("service",data);
				}
			});
		}
		
		function list() {
			
			return httpService.httpRequest({
				url:"account/list",
				async: true,
				type:"POST",
				data:{page:1,pageSize:10},
				success:function(data) {
					console.log("service",data);
				}
			});
		}
	}
})()