<?php

    require_once('connection.php');

    if($_SERVER['REQUEST_METHOD']=='POST'){
        
		$name = $_POST['name'];
		$merk = $_POST['merk'];
		$model = $_POST['model'];
        $year = $_POST['year'];
		
        $sql = "INSERT INTO vizyan (nama, merk, model, year) VALUES ('$name', '$merk', '$model', '$year')";
			
		if(mysqli_query($con, $sql)){
            echo json_encode(array('result'=>'Berhasil Menambah Mobil'));
		}else{
            echo json_encode(array('result'=>'Gagal Menambah Mobil'));
		}
		
		mysqli_close($con);
	}

?>