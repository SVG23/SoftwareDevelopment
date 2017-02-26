        app.controller("registerController",registerController);
        registerController.$inject=["$scope","$location"];
        function registerController($scope,$location){
            $scope.var_three="Welcome to Register Page";

            $scope.reg_back=function(){
                $location.path("/login");
            };
        }

