<?php

    function aps($aps) {
        require_once "total.php";
        
        if(ps_1==0 && ps_2==0 && ps_3==0) {
            $aps = $total;
        }
        elseif(ps_2==0 && ps_3==0) {
            $aps = ($total + ps_1)/2;
        }
        elseif(ps_3==0) {
            $aps = ($total + ps_1 + ps_2)/3;
        }
        else {
            $aps = ($total + $ps_1 + $ps_2 + $ps_3)/4;
        }
        return $aps;
    }
    
?>