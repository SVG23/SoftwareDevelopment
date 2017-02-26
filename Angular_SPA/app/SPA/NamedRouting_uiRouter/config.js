app.config(config);
config.$inject=['$stateProvider','$urlRouterProvider'];
function config($stateProvider,$urlRouterProvider) {

    $stateProvider.state('page_one',{

        url:'/page_one',
        views:{

            '':{

                templateUrl:'templates/page_one.html',
                controller:'page_one'
            },

            'left@page_one':{

                templateUrl:'templates/left.html',
                controller:'left'

            },

            'right@page_one':{

                templateUrl:'templates/right.html',
                controller:'right'

            }

        }

    });
}