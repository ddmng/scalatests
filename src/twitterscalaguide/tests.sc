import scala.annotation.tailrec

object w1 extends App {

    def factorial(n: Int): Int = 
        if (n==0) 1 else n * factorial(n-1)
    

    def main (args: String*) {
        println (factorial(20))
        println (tailfactorial(20))
    }



    def tailfactorial(n: Int): Int = tf(n, 1)

    @tailrec
    def tf(n: Int, p: Int): Int = 
        if (n==0) p else tf(n-1, p*n)


}
