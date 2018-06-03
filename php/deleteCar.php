<?php 

    require_once('connection.php'); 

    $id = $_GET['id'];
    
    $sql = "DELETE FROM vizyan id = $id;";

    if(mysqli_query($con, $sql)){
        echo json_encode(array('result'=>'Berhasil Menghapus Mobil'));
    }else{
        echo json_encode(array('result'=>'Gagal Menghapus Mobil'));
    }
 
    mysqli_close($con);
 ?>