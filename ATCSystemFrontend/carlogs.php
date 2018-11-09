
<!DOCTYPE html>
<html>

<head>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>

<body>



<?php

include("functions/functions.php");
include("includes/db.php");

?>





<?php

include("header.php");

?>


    <!-- end of menu tab -->
    <div class="crumb_navigation"> Navigation: <span class="current">Car Logs</span>
    

    <?php
    
    if(isset($_GET['cat'])){
    
    $get_id = $_GET['cat'];
    
    $query = "select cat_title from categories where cat_id='$get_id'";
    $run_query = mysqli_query($con,$query);
    
    $row = mysqli_fetch_array($run_query);
    
    $cat = $row['cat_title'];
    
    echo"<span class=current>>$cat</span>";
    
    }
    
    ?>


 </div>







    <div class="left_content">
      <div class="title_box">Categories</div>
      <ul class="left_menu">
        
 <?php 
     getcats(); 
     

 ?>
        
      </ul>
     



 

 <br>
 <br>

     
     <!-- <div class="banner_adds"> <a href="#"><img src="images/bann2.jpg" alt="" border="0" /></a> </div>-->
      
           <br>
 <br>
 <br>
     
 

    </div>



     </div>
    <!-- end of left content -->
    <div class="center_content">
      <div class="center_title_bar">All Car Logs</div>


<?php  



$get_carlog = "select * from tolllog INNER JOIN car INNER JOIN driver INNER JOIN drivercar
ON tolllog.Driver_id = driver.id AND tolllog.Car_id = car.id ORDER BY tolllog.id DESC;";
    $run_pro = mysqli_query($con,$get_carlog);
    


    


echo"<table>
 <tr>
    <th>Serial No.</th>
    <th>Passing Time</th>
    <th>License Plate No. </th>
    <th>option</th>
    <th>RFID NO</th>
  </tr>";
  while ($row_pro = mysqli_fetch_array($run_pro)){
        $carlog_id = $row_pro['tolllog.id'];
        $carlog_time = $row_pro['tolllog.tolled_at'];
        $car_no_plate = $row_pro['car.no_plate'];
        $car_RFID = $row_pro['car.rfid'];
        $car_id = $row_pro['drivercar.Driver_id'];

       
      // echo "Carlog ID: " . $carlog_id . " - time: " . $carlog_time. "- Car ID: " . $car_id. "<br>";

 

echo "<tr>";
echo "<td>" . $row_pro['tolllog.id'] . "</td>";
echo "<td>" . $row_pro['tolllog.tolled_at'] . "</td>";
echo "<td>" . $row_pro['car.no_plate'] . "</td>";
echo "<td> <a href='details.php?pro_id=$car_id'> Details</a> </td>";
echo "<td>" . $row_pro['car.rfid'] . "</td>";
echo "</tr>";
}
echo "</table>";

mysqli_close($con);
?>


  


 
  </div>
    <!-- end of left content -->
    
    <!-- end of center content -->



  <!-- end of main content -->
  <div class="footer">
    <div class="left_footer">  </div>
    <div class="center_footer">. All Rights Reserved 2018<br />
      
      <img src="images/payment.gif" alt="" /> </div>
  
  </div>
</div>
<!-- end of main_container -->
</body>
</html>