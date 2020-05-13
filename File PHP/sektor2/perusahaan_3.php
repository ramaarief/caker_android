<?php

include("config.php");


$sql = "SELECT sektor.nama_sektor AS nama ,id,nama_perusahaan,sektor_id,pekerjaan,lokasi,gaji,deskripsi,syarat,no_hp,website FROM perusahaan LEFT JOIN sektor ON sektor.id_sektor = perusahaan.sektor_id WHERE id = 3";
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
?>
