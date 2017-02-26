     app.controller("loginController",loginController);
     loginController.$inject=["$scope","$location","loginService","$localStorage"];
     function loginController($scope,$location,loginService,$localStorage){
         $scope.login_details=function(data){
           loginService.authenticate(data).then(function(response){
               if(response=="success"){
                   $localStorage.user_details=response;
                   $location.path("/home");
               }else{
                   alert("Invalid Details !");
               }
           });
         };

         $scope.forgot=function() {
             $location.path("/forgot");
         };

         $scope.register=function() {
             $location.path("/register");
         };

     }