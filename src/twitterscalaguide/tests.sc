def adder(m: Int, n: Int): Int = m + n
adder(1,3)

val add2 = adder(2, _: Int)
add2(3)

def mul(x: Int)(y: Int): Int = x * y
val mul9 = mul(9)

mul9(6)