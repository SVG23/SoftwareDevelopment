app.service('my_service',my_service);
my_service.$inject=['$http'];
function my_service($http) {
    this.getData=function () {
       return $http.get('http://test-routes.herokuapp.com/test/hello').then(function (response) {

            return response.data.message;
        });
    };
};