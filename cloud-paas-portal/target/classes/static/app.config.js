appConfig = {};
function getModule(resolve, reject){
	$.getJSON("api/module.json",function(data){
		appConfig.module = data;
		if (appConfig.module) {
			resolve(true);
		}else{
			reject(false);
		}
	});
}
function getRouter(resolve, reject){
	$.getJSON("api/router.json",function(data){
		appConfig.router = data;
		if (appConfig.router) {
			resolve(true);
		}else{
			reject(false);
		}
	});
}
function lazyScript(name,src){
	var defer = new Promise(loadScript);
	
	function loadScript(resolve, reject) {
		var el = document.createElement('script');
	    el.onload = function(script){
	        console.log(name+"加载完毕！"+new Date().toLocaleTimeString());
	        resolve(true);
	    };
	    el.src = src;
	    var x = document.getElementsByTagName('script')[0];
	    x.parentNode.appendChild(el);
	};
	
	return defer;
}