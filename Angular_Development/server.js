//Import the Express
var express=require("express");

//Create the Instance for the ExpressJS
var app=express();

//Import the Body Parser
var bodyparser=require("body-parser");


//Link the POC to the Node Application
app.use(express.static(__dirname+"/../app"));


//Set the JSON MIME Type
app.use(bodyparser.json());


//Default Output
app.get("/",function(request,response){
    response.redirect("/index.html");
});


app.post("/api/login",function(request,response){

    var uname=request.body.u_name;
    var upwd=request.body.u_pwd;

    if(uname=="admin5" && upwd=="admin5"){
        response.send({login:"success"});
    }else{
        response.send({login:"failure"});
    }

});


app.post("/home/home",function(request,response){

    var msg = request.body.token;

    if(msg=="home"){
        response.send({home:'Data From MySql DB....'});
    }else{
        response.send({home:"Authentication Failed"});
    }
});


app.listen(3000);

console.log("Server Listening the Port No.3000");


