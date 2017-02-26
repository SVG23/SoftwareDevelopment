app.config(config);
config.$inject=['my_serviceProvider'];
function config(my_serviceProvider) {
    my_serviceProvider.my_fun('New value');

}