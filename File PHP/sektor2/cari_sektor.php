<?php

include("config.php");

if ( isset($_POST['keyword']) ){

    $keyword = $_POST['keyword']; 

    $sql = "SELECT sektor.nama_sektor AS nama ,id,nama_perusahaan,sektor_id,pekerjaan,lokasi,gaji,deskripsi,syarat,no_hp,website FROM perusahaan LEFT JOIN sektor ON sektor.id_sektor = perusahaan.sektor_id WHERE sektor.nama_sektor LIKE '%" .$keyword."%' OR nama_perusahaan LIKE '%" .$keyword."%' OR pekerjaan LIKE '%" .$keyword."%' OR lokasi LIKE '%" .$keyword."%' OR gaji LIKE '%" .$keyword."%'";
     
    $result = array();
    $query = mysqli_query($db, $sql);
     
    while($row = mysqli_fetch_array($query)){
        array_push($result, array('id' => $row['id'],
        'nama_perusahaan' => $row['nama_perusahaan'],
        'sektor_id' => $row['sektor_id'],
        'pekerjaan' => $row['pekerjaan'],
        'lokasi' => $row['lokasi'],
        'nama_sektor' => $row['nama'],
        'gaji' => $row['gaji'],
        'deskripsi' => $row['deskripsi'],
        'syarat' => $row['syarat'],
        'no_hp' => $row['no_hp'],
        'website' => $row['website'],
    ));
    }
    echo json_encode(array("result" => $result));
}else {
    $sql = "SELECT sektor.nama_sektor AS nama ,id,nama_perusahaan,sektor_id,pekerjaan,lokasi,gaji,deskripsi,syarat,no_hp,website FROM perusahaan LEFT JOIN sektor ON sektor.id_sektor = perusahaan.sektor_id";

    $result = array();
    $query = mysqli_query($db, $sql);
     
    while($row = mysqli_fetch_array($query)){
        array_push($result, array('id' => $row['id'],
        'nama_perusahaan' => $row['nama_perusahaan'],
        'nama_sektor' => $row['nama'],
        'sektor_id' => $row['sektor_id'],
        'pekerjaan' => $row['pekerjaan'],
        'lokasi' => $row['lokasi'],
        'gaji' => $row['gaji'],
        'deskripsi' => $row['deskripsi'],
        'syarat' => $row['syarat'],
        'no_hp' => $row['no_hp'],
        'website' => $row['website'],
    ));
    }
    echo json_encode(array("result" => $result));
}
?>
