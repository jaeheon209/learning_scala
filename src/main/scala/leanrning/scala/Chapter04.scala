package leanrning.scala

object Chapter04 {

  def main(args: Array[String]): Unit = {
    // 1.Functions
    def hi = "hi"

    println(hi)


    def multiplier(x: Int, y: Int): Int = {
      x * y
    }

    println(multiplier(6, 7))

    def safeTrim(s: String): String = {
      if (s == null) return null
      s.trim()
    }

    println(safeTrim("         Hellow W o r l d !"))

    // 2.Procedures (log1 == log2 == log3)
    def log1(d: Double) = println(f"Got value $d%.2f")

    def log2(d: Double): Unit = println(f"Got value $d%.2f")

    // :, Unit, =을 생략하고 { } 괄호로 사용
    def log3(d: Double) {
      println(f"Got value $d%.2f")
    }


    // 3.Function Invocation With Expression Blocks
    def formatEuro(amt: Double) = f"#$amt%.2f"

    println(formatEuro(3.4655))

    println(formatEuro {
      val rate = 1.32;
      0.235 + 0.7123 + rate * 5.32
    })

    // 4.Recursive Functions
    def power1(x: Int, n: Int): Long = {
      if (n >= 1) x * power1(x, n - 1)
      else 1
    }

    println(power1(2, 8))
    println(power1(2, 1))
    println(power1(2, 0))

    //Error power2 -> power3
    //    @annotation.tailrec
    //    def power2(x: Int, n: Int): Long = {
    //      if (n >= 1) x * power2(x, n - 1)
    //      else 1
    //    }


    @annotation.strictfp
    def power3(x: Int, n: Int): Long = {
      if (n < 1) 1
      else x * power3(x, n - 1)
    }

    // 5.Nested Functions
    def max(a: Int, b: Int, c: Int) = {
      def max(x: Int, y: Int) = if (x > y) x else y

      max(a, max(b, c))
    }

    println(max(42, 181, 19))




    // 6.Calling Functions WIth Named Parameters

    // 7.Parameters With Default Values

    // 8.VarArg Parameters

    // 9. Parameter Groups

    // 10. Type Parametersw

    // 11. Methods ad  Operators

    // 12. Writing Reabdfable Functions


  }


}
