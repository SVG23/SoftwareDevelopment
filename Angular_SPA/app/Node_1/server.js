var express=require('express');

var app=express();

app.use(express.static(__dirname+"/../Node_1"));

app.get('/',function (request,response) {

    response.redirect('/index.html');

});

app.listen(4000);

console.log('server started at port no.4000');
