    app.directive('navDirective',navDirective);
    function navDirective() {
        return {
            restrict: 'A',
            templateUrl: 'templates/nav.html',
            controller: 'navController'
        }
    }
