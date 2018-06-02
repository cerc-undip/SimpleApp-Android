<?php

    require_once('connection.php');

    if($_SERVER['REQUEST_METHOD']=='POST'){
        
		$name = $_POST['name'];
		$merk = $_POST['merk'];
		$model = $_POST['model'];
        $year = $_POST['year'];
		
        $sql = "INSERT INTO vizyan (nama, merk, model, year) VALUES ('$name', '$merk', '$model', '$year')";
			
		if(mysqli_query($con, $sql)){
			echo 'Berhasil Menambah Mobil';
		}else{
			echo 'Gagal Menambahkan Mobil';
		}
		
		mysqli_close($con);
	}

?>