def adder(m: Int, n: Int): Int = m + n
val add2 = adder(2, _: Int)
add2(3)

def mul(x: Int)(y: Int): Int = x * y
val mul9 = mul(9) _
mul9(6)

val curriedAdd = (adder _).curried
val addTwo = curriedAdd(2)
addTwo(4)


def capitalizeAll(args: String*) = {
    args.map { _.capitalize }
}
