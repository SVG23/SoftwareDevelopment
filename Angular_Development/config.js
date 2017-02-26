app.run(run).config(config);
run.$inject=["$rootScope","$localStorage","$location"];
function run($rootScope,$localStorage,$location){
    $rootScope.$on("$stateChangeStart",function(e,toState,toParams,fromState,fromParams){
        if(!($localStorage.user_details)){
            $location.path("/login");
        }
    });
}


    config.$inject=["$stateProvider","$urlRouterProvider"];
    function config($stateProvider,$urlRouterProvider) {
        $urlRouterProvider.otherwise("/login");

        $stateProvider.state("login", {
            url: "/login",
            templateUrl: "templates/login.html",
            controller: "loginController"
        })
            .state("home", {
                url: "/home",
                templateUrl: "templates/home.html",
                controller: "homeController"
            })

            .state("login.register",{
                url:"/register",
                templateUrl:"templates/register.html",
                controller:"registerController"
        })

            .state("login.forgot",{
                url:"/forgot",
                templateUrl:"templates/forgot.html",
                controller:"forgotController"
        })

            .state("home.about",{
                url:"/about",
                templateUrl:"templates/about.html",
                controller:"aboutController"
        })

            .state("home.contact",{
                url:"/contact",
             templateUrl:"templates/contact.html",
             controller:"forgotController"
        });
    }
