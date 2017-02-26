     app.controller("homeController",homeController);
     homeController.$inject=["$scope","$location","$localStorage"];
     function homeController($scope,$location,$localStorage){
         $scope.var_one="Welcome to Home Page";

         $scope.logout=function(){
             delete $localStorage.user_details;
             $location.path("/login");
         };
     }
