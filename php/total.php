<?php

    function total($total) {
        $tf = ($textbook_publication + $funds)/2;
        $total = (($student_feedback + $subject_result + $paper_publication + $qualification + $fdps + $tf + $activity)/100)*100;
        return $total;
    }
    
?>