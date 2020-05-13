var express = require('express');
var mysql = require('mysql');
var bodyParser = require('body-parser');

//connect to MySQL
var con = mysql.createConnection({
	host:'localhost',
	user:'root',
	password:'',
	database:'loker2'
});

//create RESTFul
var app=express();
var publicDir=(__dirname+'/public/');
app.use(express.static(publicDir));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:true}));

//GET ALL PERUSAHAAN
app.get("/perusahaan",(req,res,next)=>{
	con.query('SELECT sektor.nama_sektor AS nama ,id,nama_perusahaan,sektor_id,pekerjaan,lokasi,gaji,deskripsi,syarat,no_hp,website FROM perusahaan LEFT JOIN sektor ON sektor.id_sektor = perusahaan.sektor_id', function(error,result,fields){
		con.on('error', function(err){
			console.log('[MYSQL]ERROR',err);
		});
		if(result && result.length)
		{
			res.end(JSON.stringify(result));
		}
		else{
			res.end(JSON.stringify('No Perusahaan here'));
		}
	});
});

app.post("/search",(req,res,next)=>{

	var post_data = req.body;
	var name_search = post_data.search;

	var query = "SELECT sektor.nama_sektor AS nama ,id,nama_perusahaan,sektor_id,pekerjaan,lokasi,gaji,deskripsi,syarat,no_hp,website FROM perusahaan LEFT JOIN sektor ON sektor.id_sektor = perusahaan.sektor_id WHERE sektor.nama_sektor LIKE '%" +name_search+"%' OR nama_perusahaan LIKE '%" +name_search+"%' OR pekerjaan LIKE '%" +name_search+"%' OR lokasi LIKE '%" +name_search+"%' OR gaji LIKE '%" +name_search+"%'"

	con.query(query, function(error,result,fields){
		con.on('error', function(err){
			console.log('[MYSQL]ERROR',err);
		});
		if(result && result.length)
		{
			res.end(JSON.stringify(result));
		}
		else{
			res.end(JSON.stringify('No Perusahaan here'));
		}
	});
});

app.listen(3000,()=>{
	console.log('port 3000');
})