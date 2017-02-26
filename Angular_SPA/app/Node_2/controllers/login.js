app.controller('login',login);
login.$inject=['$scope','my_service'];
function login($scope,my_service) {

    $scope.user_login=function (data) {

        my_service.login_details(data).then(function (response) {

            console.log(response);
        });

    };

};