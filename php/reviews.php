<?php

    if(isset($_POST['student_feedback']) && isset($_POST['subject_result']) && isset($_POST['paper_publication']) && isset($_POST['qualification']) && isset($_POST['fdps']) && isset($_POST['textbook_publication']) && isset($_POST['funds']) && isset($_POST['activity'])) {
        
        require_once "conn.php";
        require_once "total.php";
        require_once "aps.php";

        $faculty_id = $_POST['faculty_id']
        $student_feedback = total($_POST['student_feedback']); 
        $subject_result= total($_POST['subject_result']);
        $paper_publication = total($_POST['paper_publication']); 
        $qualification = total($_POST['qualification']); 
        $fdps = total($_POST['fdps']); 
        $textbook_publication = total($_POST['textbook_publication']); 
        $funds = = total($_POST['funds']); 
        $activity= total($_POST['activity']);
        $total = $_POST['total'];
        $ps_1 = $_POST['ps_1'];
        $ps_2 = $_POST['ps_2'];
        $ps_3 = $_POST['ps_3'];
        $aps = $_POST['aps'];
        $sql = "select * from reviews where faculty_id='$faculty_id' and student_feedback='$student_feedback' and subject_result='$subject_result' and paper_publication='$paper_publication' and qualification='$qualification' and fdps='$fdps' and textbook_publication='$textbook_publication' and funds='$funds' and activity='$activity' and total='$total' and ps_1='$ps_1' and ps_2='$ps_3' and ps_1='$ps_3' and aps='$aps';
        $result = $conn->query($sql);

        if($result->num_rows > 0) {
            echo "updated";
        }
        
        else {
            echo "not updated";
        }
    
    }

?>