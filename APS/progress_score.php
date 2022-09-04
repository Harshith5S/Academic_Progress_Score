<?php
    require_once "conn.php";
    require_once "reviews.php";
    require_once "total.php";
    $query = mysql_query("select * from reviews", $conn);
    echo $row1['$total'];
    mysql_close($conn);
?>