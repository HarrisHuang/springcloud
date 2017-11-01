(function(){
	"use strict";
	angular
		.module("app.login")
		.controller("loginController",loginController)
	
	loginController.$inject = ["$state","$scope","loginService","constant"];
	
	function loginController($state,$scope,loginService,constant) {
		
		
		var vm = this;
		activate();
		function activate() {
			
			$("#header").hide();
			$("#slider").hide();
			
			
			vm.searchParam = {
				page : 1,
				pageSize : 10,
				sortParamList : []
			};
			
			vm.loginCheck = function() {
				console.log("loginName:"+vm.searchParam.loginName);
				console.log("loginPassword:"+vm.searchParam.loginPassword);
				
				loginService.login(vm.searchParam).then(
						function(data) {
							console.log("login response:" + data);
							if(data.validResult == true) {
								
								$state.go("pageOne");
								
								$("#header").show();
								$("#slider").show();
								
							} else if (data.validResult == "error"){
								alert(data.message);
							}
						}
				)
				
				

			}
			
		}// activate end
		
	
	}; //loginController end
	
})();