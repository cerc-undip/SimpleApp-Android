<?php 

	require_once('connection.php');
	
	$sql = "SELECT * FROM vizyan";
	
	$r = mysqli_query($con, $sql);
	
	$result = array();
	
	while($row = mysqli_fetch_array($r)){
		
		array_push($result, array(
			"id"=>$row['id'],
			"name"=>$row['nama'],
            "merk"=>$row['merk'],
            "model"=>$row['model'],
            "year"=>$row['year']
		));
	}
	
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>