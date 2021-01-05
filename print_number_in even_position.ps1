$a=(2,4,1,3,9,6,5,8)

for($i = 0;$i -lt $a.Length; $i++){
    if($i % 2 -eq 0){
    write-host $a[$i];}
}