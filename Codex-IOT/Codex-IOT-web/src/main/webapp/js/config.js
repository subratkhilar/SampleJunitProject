 app.config(function ($stateProvider, $urlRouterProvider) {

 //$urlRouterProvider.when("", "#/login");


$stateProvider
        .state("login", {
            url: "",
            templateUrl: "templates/login.html",
            controller:"LoginCtrl"
        })
        
        .state("home", {
            url:"/welcome",
            templateUrl: "templates/welcome.html",
            controller:"mapController"  
        })
        .state("alerts", {
            url:"/welcome/alerts",
            templateUrl: "templates/alerts.html",
            controller : "sysalertCtrl"
        })
        .state("reports", {
            url: "/welcome/reports",
            templateUrl: "templates/reports.html",
            controller:"reportCtrl"
        })
        .state("siteview", {
            url:"/welcome/detailedDashBoard",
            templateUrl: "templates/detailedDashBoard.html",
            controller:"locationDashBoardCntl"

        });
       
 });