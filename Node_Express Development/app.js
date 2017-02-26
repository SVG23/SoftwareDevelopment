var express = require("express");// Invoking the instance of the express module
var app = express();// passing the functionality of express into app 
                    /* The app object conventionally denotes the Express application. 
                    Create it by calling the top-level express() function exported by the Express module:*/

var mongoose = require("mongoose");//Grabing the mongoose pacakage into the project
                                /* Mongoose allows us to have access to the MongoDB commands for CRUD simply and easily. 
                                To use mongoose, make sure that you add it to you Node project by using the 
                                following command: npm install mongoose --save */

var bodyParser = require("body-parser");//installing body-parser module to send or get data (Getting data from user to Node)
                                        /* In order to read HTTP POST data , we have to use "body-parser" node module. 
                                        body-parser is a piece of express middleware that reads a form's input and 
                                        stores it as a javascript object accessible through "req.body""
                                        In other words, body-parser extract the entire body portion of an incoming request stream and 
                                        exposes it on "req.body"" as something easier to interface with */
app.listen("1234",function(err){//creating a port
if(err){
console.log("Port not working");// Some message on the port 
}else{
    console.log("port is working on 1234");
}
});

// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: true }));
// parse application/json
app.use(bodyParser.json());

/*(function (){ //Self executed function-IIFE(Immediately Invoking Function Expression)
})();*/
var api = require("./api/user/api")();//Restful api-->User registration api
app.use("/user/register",api);//User registration api -- Main API
app.use(express.static(__dirname+"/public"));//Static page on the output (web page)
mongoose.connect("mongodb://srivinya:vinya1992@ds151059.mlab.com:51059/reservation",function(err){//connecting to a MongoDB database
if(err){
console.log("Database not working");
}else{
    console.log("Database is working");
}
});
