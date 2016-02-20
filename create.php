<?php
$con=mysqli_connect("ec2-54-144-242-152.compute-1.amazonaws.com","root","team6");
$sql="CREATE DATABASE my_db";
if (mysqli_query($con,$sql))
{
   echo "Database my_db created successfully";
}
?>