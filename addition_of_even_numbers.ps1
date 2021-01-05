<# this is for comment#>

$myarray1=(2,8,9,6,7,2)

$total=0

for($i=0;$i -lt $myarray1.Length;$i++){
    if($myarray1[$i] % 2 -eq 0){
    $total+=$myarray1[$i]
    }
}

write-host "Total of even $total"