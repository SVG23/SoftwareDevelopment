var express=require("express");
var user=require("./userSchema");
var Cryptr = require('cryptr'),
    cryptr = new Cryptr('srivinya');
module.exports=function (){
var router = express.Router();


/* ****Start post ****
Syntax: app.post(path, callback [, callback ...])
Description: Routes HTTP POST requests to the specified path with the specified callback functions.
URL: http://localhost:1234/user/register/add */
router.post("/add",function(request, response){
var name=request.body.name;//This is for post method; ----- request.query.name;-->this is for get method
var email=request.body.email;
var userName=request.body.username;
var password=request.body.password;
var phoneNumber=request.body.phoneNumber;
var encryptedPassword = cryptr.encrypt(password);

var userAdd=new user({
//Inserting data into database (Schema)
    dbName:name,
    dbEmail:email,
    dbPhoneNumber:phoneNumber,
    dbUserName: userName,
    dbPassword:encryptedPassword
});
userAdd.save(function(err){ //"save" is a predefined method in mongoose.
if(err){
    response.send(err);
}else{
    response.send("successfully created Schema");
}
});
/* When we want multiple responses, better use JSON format.
response.json({"name":name,"email":email,"phoneNumber":phoneNumber});-->Response in JSON format
output: {
name: "Sri",
email: "dgdsajhg@gmail.com",
phoneNumber: "123445566"
} */
});
//****End Post****

/**** Start Get ****
Syntax: app.get(path, callback [, callback ...])
Description: Routes HTTP GET requests to the specified path with the specified callback functions.
URL: http://localhost:1234/user/register/getusers */
router.get("/getusers",function(request, response){
    var name = request.query.name;
    user.find({dbName:name},function (err, data){
if(err){
response.send(err);
}else{
    response.send(data);
}
    });
});
//****End getusers data****

/* *** Start Delete ****
Syntax: app.delete(path, callback [, callback ...])
Description: Routes HTTP DELETE requests to the specified path with the specified callback functions.
URL: http://localhost:1234/user/register/deleteuser (Deleting records)*/
router.delete("/deleteuser",function (request, response){
    var id = request.query.id;
    user.findByIdAndRemove(id, function (err, data){
        if(err){
response.send(err);
        }else{
            var result={
                message:"Successfully deleted",
                status:"200",
                userID:data._id
            }
            response.send(result);
            
        }
    });
});
// ****End delete****

/**** Start Update ****
Syntax: app.put(path, callback [, callback ...])
Description: Routes HTTP PUT requests to the specified path with the specified callback functions.
URL: http://localhost:1234/user/register/updateuser */
router.put("/updateuser",function(request, response){
var name=request.body.name;
var email=request.body.email;
var phoneNumber=request.body.phoneNumber;
var id=request.body.id;
user.findById(id, function(err, data){
data.dbName=name;
data.dbEmail=email;
data.dbPhoneNumber=phoneNumber;
data.save(function (err){
if(err){
    response.send(err);
}else{
    response.send("Successfully updated");
}
});
}); 
});
//****End Update****

//**login API */
router.post("/login",function(request, response){
    var username = request.body.username;
     var password = request.body.password;
     var encryptedPassword = cryptr.encrypt(password);
    user.find({dbUserName:username,dbPassword:encryptedPassword},function (err, data){
if(err){
response.send(err);
}else{
    response.send(data);
}
    });
});

return router;
};


