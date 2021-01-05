$var1 = "Zahraa"
$var2 = 32
$var1.GetType()
$var2.GetType()

$var1 = 5
$var2 = 2
$var3 = $var1 + $var2
write-host "Total: "$var3

$var1 = 10
$var2 = 3
$var3 = $var1 / $var2
$var4 = $var1 % $var2
write-host "division: "$var3
write-host "Reminder: "$var4

$var1 = 1
$var2 = 1
$var1 -eq $var2

$myarray = ("a", "z", "m")
$array = (9, 8, 2)
write-host "First element of first array "$myarray[0]
write-host "First element of second array " $array[0]