app.config(function ($stateProvider, $urlRouterProvider, $httpProvider) {


    $httpProvider.defaults.cache = false;
    if (!$httpProvider.defaults.headers.get) {
        $httpProvider.defaults.headers.get = {};
    }
    // disable IE ajax request caching
    $httpProvider.defaults.headers.get['If-Modified-Since'] = '0';





    $stateProvider
        /* .state("login", {
             url: "",
             templateUrl: "templates/login.html",
             controller:"LoginCtrl"
         })*/

        .state("login", {
            url: "",
             templateUrl: "templates/login.html",
             controller:"LoginCtrl"
        })

        .state("home", {
            url: "/welcome",
            templateUrl: "templates/welcome.html",
            controller: "mapController"
        })
        .state("project_config", {
            url: "/project_config",
            templateUrl: "templates/project_configuration.html",
            controller: "config_controller"
        })

        .state("asset_config", {
            url: "/asset_config",
            templateUrl: "templates/asset_configuration.html",
            controller: "asset_controller"
        })

        .state("workflow_config", {
            url: "/workflow_config",
            templateUrl: "templates/workflow.html",
            controller: "uigridCtrl"
        })

        .state("sensor_config", {
            url: "/sensor_config",
            templateUrl: "templates/sensor_config.html",
            controller: "sensor_controller"
        })

		.state("graph", {
            url:"/graph",
            templateUrl: "templates/Graph.html",
            controller:"NewGraphController"
        })


});