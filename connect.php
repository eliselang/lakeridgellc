<?php
//connection to the database

$username = root
$password = password!
$hostname = jdbc:mysql://127.0.01:3306/445

//mysql_connect is the name of the funciton to connect to MySQL

$dbhandle = mysql_connect($hostname, $username, $password)
	or die("Connection Failed");
echo "Connection Successful <br>";

//select the database to connect to

//$selected = mysql_db("Business", $dbhandle)
//	or die("Could not select database");

//execute the SQL query and return te records

//$records = mysql_query("SELECT business_name, business_area, business_phone,
//	business_ address, contact_name, beenApproved FROM Business");

//display the records



//close the connection

mysql_close($dbhandle);

?>

