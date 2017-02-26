
app.controller('ctrl',my_fun);
my_fun.$inject=['$scope'];
function my_fun($scope){
    $scope.var_one='I am from controller';

}
