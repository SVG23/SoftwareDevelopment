//Import the ExpressJS
var express=require('express');

//Create the instance for the ExpressJS
var app=express();

//Link the "Node_2" to the "app"
app.use(express.static(__dirname+"/../Node_2"));

//Set the MIME Type
var bodyparser=require('body-parser');
app.use(bodyparser.json());

//Set the default output
app.get('/',function (request,response) {

    request.redirect('/index.html');
});

//Create the URL to Accept & Send the data to the angular application
app.post('/api/login',function (request,response) {

    var uname=request.body.U_name;
    var upwd=request.body.U_pwd;

    if(uname=='admin' && upwd=='admin'){
        response.send({login:'success'});

    }else{

        response.send({login:'failure'});
    }

});

//Assign the port number to the server
app.listen(3000);
console.log('server started on port number.3000');
