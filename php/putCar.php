<?php 

    require_once('connection.php');
		
    if($_SERVER['REQUEST_METHOD']=='POST'){
        
		$id = $_POST['id'];
		$name = $_POST['name'];
		$merk = $_POST['merk'];
		$model = $_POST['model'];
        $year = $_POST['year'];
		
		$sql = "UPDATE vizyan SET nama = '$name', merk = '$merk', model = '$model', year = '$year' WHERE id = $id;";
		
		if(mysqli_query($con, $sql)){
			echo json_encode(array('result'=>'Berhasil Mengubah Mobil'));
		}else{
            echo json_encode(array('result'=>'Gagal Mengubah Mobil'));
		}
		
		mysqli_close($con);
	}
?>