$myarray = (2,7,8,3,4,11)
$sum = 0
for($i = 0; $i -lt $myarray.Length; $i++){
    if($myarray[$i] % 2 -ne 0){
        $sum += $myarray[$i];
    }
}
write-host "sum of odd numbers :- "$sum