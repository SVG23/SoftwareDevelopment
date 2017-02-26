    app.service("registerService",registerService);
    registerService.$inject=["$http","$q"];
    function registerService($http,$q) {
        this.registerUser = function (data) {
            var uname = data.u_name;
            var upwd = data.u_pwd;

        }

    }
