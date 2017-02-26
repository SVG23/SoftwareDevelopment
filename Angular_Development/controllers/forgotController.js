        app.controller("forgotController",forgotController);
        forgotController.$inject=["$scope","$location"];
        function forgotController($scope,$location){
            $scope.var_two="Welcome to Forgot Page";

            $scope.for_back=function(){
                $location.path("/login");
            };
        }

