app.controller("login",login);
login.$inject=['$scope','loginService','$location'];//To maintain the order of the modules
function login($scope,loginService,$location) {
    var x =10;//private memeory,local variable
    this.x
    $scope.login_details=function (data) {
        if ((loginService.authenticate(data))=='Success'){

            $location.path("/home");

        }else{

            alert("Invalid Username or Password");

        }

            ;


    }
}