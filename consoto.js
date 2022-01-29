var exp = require('express');

var app = exp();

app.listen(8081,function(){			
	console.log("Server Started on port 8081");
});

app.get('/index',function(req,res){
	res.sendFile(__dirname+"/index.html");	
});

app.all('*',function(req,res){
	res.send("Invalid URL");		// if you use res.write("Invalid Url") you also have to use res.end() at end
});