app.service('my_service',my_service);
my_service.$inject=['$http','$q'];
function my_service($http,$q) {

    var deffered=$q.defer();//Initialize the Asynch call
    this.fun_one=function () {

        return $http.get('http://www.w3schools.com/angular/customers.php').then(function (response) {

            return response;
            
        },function (response) {
            return response;
        });
    };
    
};