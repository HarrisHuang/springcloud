(function(){
	"use strict";
	angular
		.module("app.pageTwo")
		.controller("pageTwoController",pageTwoController)

	pageTwoController.$inject = ["$scope","constant"];
	
	function pageTwoController($scope,constant) {
		$scope.name = constant.name == "Luffy" ? "Joker" : "Lucy";
	}
})();