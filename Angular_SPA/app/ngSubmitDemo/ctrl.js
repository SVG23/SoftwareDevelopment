app.controller('ctrl',ctrl);
ctrl.$inject=['$scope'];
function ctrl($scope){

    $scope.logic=function(data) {

        alert(data.key1+"....."+data.key2);
    }

}
