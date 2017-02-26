//Grab the things we need
var mongoose=require("mongoose");
var userSchema=mongoose.Schema;//schema is a class in mongoose
/*Defining your schema:
 Everything in Mongoose starts with a Schema. 
Each schema maps to a MongoDB collection and defines the shape of the documents within that collection.*/
var userSchemaObj=new userSchema({ //creating an userSchema object
    dbName:String,
    dbEmail:String,
    dbPhoneNumber:String,
    dbUserName:String,
   dbPassword: String 
});
/* The schema is useless so far. we need to create a model using it
Creating a model:
To use our schema definition, we need to convert our userSchemaObj into a Model we can work with. 
To do so, we pass it into mongoose.model(modelName, schema): */
module.exports=mongoose.model("userSchemaClass",userSchemaObj);
