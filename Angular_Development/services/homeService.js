app.service("homeService",homeService);
homeService.$inject=["$http"];
function homeService($http) {

    this.fun_one=function(){
        return $http.post("/home/home",{token:"home"}).then(function(response){
            return response.data.home;
        });
    }
}