app.service('my_service',my_service);
my_service.$inject=['$http'];
function my_service($http) {

    this.login_details=function (data) {

       return $http.post('/api/login',data).then(function (response) {

           return response.data.login;
       });

    };
};