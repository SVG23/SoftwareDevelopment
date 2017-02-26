app.controller("navController",navController);
navController.$inject=["$scope","$location"];
function navController($scope,$location){

    $scope.logout=function(){
        delete $localStorage.user_details;
        $location.path("/login");
    };
    $scope.home=function(){
        $location.path("/home");
    };
    $scope.about=function(){
        $location.path("/about");
    };
    $scope.contact=function(){
        $location.path("/contact");
    };
}

