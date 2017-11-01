(function(){
	'use strict'
	Promise.all([new Promise(getModule),new Promise(getRouter)]).then(function(status){
		var newDate = new Date().toLocaleTimeString();
		status[0] ? console.log("Module数据读取完成！"+newDate) : console.log("Module数据读取失败！"+newDate);
		status[1] ? console.log("Router数据读取完成！"+newDate) : console.log("Router数据读取失败！"+newDate);
		
		var newRouterRely = [];
		//处理子模块依赖关系与子模块申明
		angular.forEach(appConfig.router,function(oRoute,index){
			angular.module(oRoute.module,[]);
			newRouterRely.push(oRoute.module);
		});
		appConfig.module["app.router"]["rely"]=newRouterRely;
		
		//通用服务申明
		var ModuleGroup = [];
		angular.forEach(appConfig.module,function(value,name){
			angular.module(name,value.rely);
			ModuleGroup.push(name);
		});
		
		//app加载依赖
		angular.module("app",ModuleGroup);
		
		lazyScript("Module","app/module.js").then(function(status){
			if (status) {
				angular.bootstrap(document,["app"]);
			}
		});
		
	});
})();