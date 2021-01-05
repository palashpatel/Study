$myarray = (2,7,8,3,4,11)
$sum = 0
for($i = 0; $i -lt 6; $i++){
    if($myarray[$i] % 2 -eq 0){
        $sum += $myarray[$i];
    }
}
write-host "sum of even numbers :- "$sum