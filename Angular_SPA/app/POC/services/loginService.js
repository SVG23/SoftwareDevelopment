app.service("loginService",loginService);
loginService.$inject=['$http','$q'];
function loginService($http,$q) {
    
    this.authenticate=function (data) {

        var uname = data.u_name;
        var upwd = data.u_pwd;

        if(uname=='admin' && upwd=='admin'){

            return 'Success';

        } else{

            return 'Failure';
        }
    }
}