app.config(config);
config.$inject=["$stateProvider","$urlRouterProvider"];
function config($stateProvider,$urlRouterProvider) {

    $urlRouterProvider.otherwise("/login");

    $stateProvider.state("login",{

        url: "/login",
        views: {

            "sri":{

                templateUrl: "templates/login.html",
                controller: "login"
            }
        }

    })
        .state("home",{

            url: "/home",
            templateUrl: "templates/home.html",
            controller: "home"

        });


}