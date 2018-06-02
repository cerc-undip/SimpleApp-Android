<?php

    require_once('connection.php');

    $id = $_GET['id'];
	
	$sql = "SELECT * FROM vizyan WHERE id=$id";
	
	$r = mysqli_query($con, $sql);
	
	$result = array();
	$row = mysqli_fetch_array($r);
	array_push($result,array(
			"id"=>$row['id'],
			"name"=>$row['nama'],
			"merk"=>$row['merk'],
			"model"=>$row['model'],
            "year"=>$row['year']
		));

	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>