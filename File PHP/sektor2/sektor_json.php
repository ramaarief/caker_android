<?php

include("config.php");



$sql = "SELECT * FROM sektor";
$result = array();
$query = mysqli_query($db, $sql);
 
while($row = mysqli_fetch_array($query)){
    array_push($result, array('id_sektor' => $row['id_sektor'],
    'nama_sektor' => $row['nama_sektor'],
));
}
echo json_encode(array("result" => $result));
?>
