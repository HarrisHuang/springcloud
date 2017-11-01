(function(){
    angular.module('app.layout').config(routesConfig);
    routesConfig.$inject = ['$stateProvider','$urlRouterProvider'];

    //基本路径配置
    function routesConfig($stateProvider,$urlRouterProvider) {
    	$urlRouterProvider.otherwise('/login');
    	
    }//end of function routesConfig

})();
