app.provider('my_service',my_service);

function my_service() {
    var name = 'old value';
    this.my_fun=function (data) {
        name=data;
        return name;
    }

    this.$get=function () {

        console.log('custom service will be called only once');
        return name;

    };
};
