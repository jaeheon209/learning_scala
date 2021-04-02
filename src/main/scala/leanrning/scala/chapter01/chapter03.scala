package leanrning.scala.chapter01

object chapter03 {

  //P10
  /*
    scala> val x: Int = 5
    val x: Int = 5

    scala> x
    val res0: Int = 5

    scala> x * 2
    val res1: Int = 10

    scala> x / 5
    val res2: Int = 1

    scala> res0 * res1
    val res3: Int = 50

   */

  //P17
  /*
   1) small -> big is ok

    scala> val b: Byte = 10
    val b: Byte = 10

    scala> val s: Short = b
    val s: Short = 10

    scala> val d: Double = s
    val d: Double = 10.0

   2)  big -> small is X
    scala> val l: Long = 20
    val l: Long = 20

    scala> val i: Int = l
                        ^
           error: type mismatch;
            found   : Long
            required: Int

    scala> val i: Int = l.toInt
    val i: Int = 20
   */

  def main(args: Array[String]): Unit = {
    //P20
    val greeting = "Hello, " + "World"
    println(greeting) // Hello. World

    val matched = (greeting == "Hello, World")
    println(matched) // true

    val theme = "Na " * 5 + "Batman!"
    println(theme) //  Na Na Na Na Na Batman!

    // 파이픈이 안먹는다 |...
    val greeting2 =
      """She suggested reformatting the file
by replaceing tabs (\t) with newlines (\n);
"Why do that?", he asked."""
    println(greeting2)

    val approx = 355 / 113f
    println(approx)
    println("Pi, using 355/113, is about " + approx + ".")
    println(s"Pi, using 355/113, is about $approx.")

    val item = "apple"
    println(s"How do you like them ${item}s?")
    println(s"Fish n chips n vinegar, ${"pepper " * 3}salt")

    println(f"I wrote a new $item%.3s today")
    println(f"Enjoying this $item ${355 / 113.0}%.5f times today")

    //matches
    val matches_ex = "Froggy went a' courting" matches ".*courting"
    println(matches_ex) //true

    val replaceAll_ex = "milk, tea, muck" replaceAll("m[^ ]+k", "coffee")
    println(replaceAll_ex) // m??k to coffee

    val replaceFirst_ex = "milk, tea, muck" replaceFirst("m[^ ]+k", "coffee")
    println(replaceFirst_ex) // first


    val input = "Enjoying this apple 3.14159 times today"
    val pattern = """.*apple ([\d.]+) times .*""".r
    val pattern(amountText) = input
    val amount = amountText.toString
    println(amount)

    //ASC! Char
    val c = 'A'
    val i: Int = c
    val t: Char = 116
    println(s"c : $c, i: $i, t: $t")

    val info = (5, "Korben", true)
    println(info)
    println(info._2) //Korben

    val red = "red" -> "0xff0000"
    println(red)

    val reversed = red._2 -> red._1
    println(reversed)

    //연습문제
    // 일반적은 escape는 \을 사용 $의 경우는 $$ 2개를 사용
    val money = 2.7255
    println(s"You own $$${money}")

    val a = 128
//    val b: Char = a
//    val c: String = a
    val d: Double = a
    val d2: Int = d.toInt

    println(f"$a, $d, $d2")

  }


}
