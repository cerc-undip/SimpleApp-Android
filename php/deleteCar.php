<?php 

    require_once('connection.php'); 

    $id = $_GET['id'];
    
    $sql = "DELETE FROM vizyan id = $id;";

    if(mysqli_query($con, $sql)){
        echo 'Berhasil Menghapus Mobil';
    }else{
        echo 'Gagal Menghapus Mobil';
    }
 
    mysqli_close($con);
 ?>