var mysql = require('mysql');
var express = require('express');
var bodyParser = require('body-parser')
var app = express();

app.use( bodyParser.json() );       // to support JSON-encoded bodies
app.use(bodyParser.urlencoded({     // to support URL-encoded bodies
  extended: true
})); 


var con = mysql.createConnection({
    host: 'ec2-54-144-242-152.compute-1.amazonaws.com',
    user: 'root',
    password: 'team6',
    database: 'Team6'
});

con.connect(function(err){
  if(err){
    console.log('Error connecting to Db');
    return;
  }
  console.log('Connection established');
});

app.get('/projects', function (req, res) {
    var query = "SELECT DISTINCT Project FROM Project";

    con.query(query, function(err, rows){
	if (err) throw err;
	
	res.send(rows);
    });
});

app.get('/projects/:name', function(req, res){
    var query = "SELECT CardNames FROM Project WHERE Project = '" + req.params.name + "'";

    con.query(query, function(err, rows){
	if (err) throw err;
	
	res.send(rows);
    });
});

app.post('/add', function(req, res){
    var projectName = req.body.projectname;
    var card1 = req.body.card1;
    var card2 = req.body.card2;
    var card3 = req.body.card3;

    var query = "INSERT INTO Project VALUE ('" + projectName + "','" + card1 + "'),('" + projectName + "','" + card2 + "'),('" + projectName + "','" + card3 + "')";

    con.query(query, function(err, rows){
	if(err) throw err;
	res.send({'status': 'insert successfully'});
    });
});

app.listen(3000, function(){
    console.log("Listening on port 3000...");
});
