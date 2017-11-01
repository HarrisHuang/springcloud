(function(){
	"use strict";
	angular
		.module("app.pageTwo")
		.service("pageTwoService",pageTwoService)
	
	function pageTwoService() {
		this.getDate = getDate;
		
		function getDate() {
			
		}
	}
})()