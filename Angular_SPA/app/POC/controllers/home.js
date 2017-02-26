app.controller("home",home);
home.$inject=['$scope','$location'];
function home($scope,$location) {

    $scope.var_two="Welcome to Home Page";

    $scope.logout=function () {
        $location.path("/login");

    }
}