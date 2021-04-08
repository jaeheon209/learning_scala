package leanrning.scala

object Chapter05 {

  def main(args: Array[String]): Unit = {
    // 1.Function Types and Values
    def double(x: Int): Int = {
      x * 2
    }

    println(f"double: ${double(5)}")
    // 함수 시그니처는 이름, 입력, 출력 이므로,
    // 함수 타입은 입력과 출력이여야 한다.
    // double의 함수 타입은 Int => Int 이다.

    //x: Int 가 연상 된다.
    //myDouble: Int
    //myDOuble: type 타입에 함수타입을 넣은 것.
    val myDouble: (Int) => Int = double
    println(f"myDouble: ${myDouble(10)}")

    val myDoubleCopy = myDouble
    println(f"myDoubleCopy: ${myDouble(15)}")

    //언더스코어를 사용한 타입 생략 _
    //미래의 함수 초출에 대한 자리표시자 역할
    // 결국 매개변수 이름이 없는 함수 정의의 형태이다.
    val myDouble2 = double _
    println(f"myDouble2: ${myDouble2(20)}")

    //매개변수가 2개 일때 예시
    def max(a: Int, b: Int) = if (a > b) a else b

    val maximize: (Int, Int) => Int = max
    println(f"maximize: ${maximize(50, 30)}")

    //Unit 타입 예시
    def logStart() = "=" * 50 + "\nStarting Now\n" + "=" * 50

    val start1: () => String = logStart // 책이랑 다르다.
    val start2: String = logStart
    println(start1)
    println(start2)


    // 2.Higher-Order Functions
    def safeStringOp(s: String, f: String => String) = {
      if (s != null) f(s) else s
    }

    def reverser(s: String) = s.reverse

    println(f"safeStringOp1: ${safeStringOp(null, reverser)}")
    println(f"safeStringOp2: ${safeStringOp("Ready", reverser)}")
    // 함수가 매개변수로 사용될떄는 () 괄호가 들어가니까 unspecified 발생
    //    println(f"safeStringOp3: ${safeStringOp("Ready", reverser())}")

    // 3.Function Literals
    // 최종 적으로 함수 타입의
    /*
    def double (x: Int): Int = {
      x * 2
    }
     */
    val doubler = (x: Int) => x * 2
    val doubled = doubler(22)
    println(doubled)
    // 여기서 헷깔린다 => 사용하는 케이스
    // case 1) 함수 타입 : f:(Int, Int) => Int - 함수의 입력과 출력 타입
    // case 2) 함수 리터럴    : (x: Int) => x * 2 - 함수의 입력과 매개변수를 받은 내부 로직

    val greeter = (name: String) => s"Hello, $name"

    val hi = greeter("World")

    def max(a: Int, b: Int) = if (a > b) a else b

    val maximize1: (Int, Int) => Int = max
    // 위의 maximize는 아래와 같은 것
    // val name: String = "myName"
    // val <valueName>: <type> = <expression>

    //max를 함수 리터럴로 표시 - 함수의 출력 리턴이 생략되고 내부 로직이 바로 들어온다.
    val maximize2 = (a: Int, b: Int) => if (a > b) a else b
    println(f"maximize2: ${maximize2(84, 96)}")

    def logStart2() = "=" * 50 + "\nStarting Now\n" + "=" * 50

    var start = () => "=" * 50 + "\nStarting Now\n" + "=" * 50
    // "logStart2() =" 이 부분이 "start = () =>" 이렇게
    // 함수의 () 인풋은 그대로 사용
    // => 함수 내용 입력
    // 이 구절이 함수리터럴이고 이게 변수에 선언됨~
    // 함수 리터럴을 통해 변수에 함수명없이 바로 함수가 선언 가능하다.

    // 함수리터럴을 사용해서 매개변수에 anonymous 함수 넣기

    def safeStringOp2(s: String, f: String => String) = {
      if (s != null) f(s) else s
    }

    println(f"safeStringOps null: ${safeStringOp2(null, (s: String) => s.reverse)}")
    println(f"safeStringOps null: " + safeStringOp2(null, (s: String) => s.reverse))
    println(f"safeStringOps Ready: " + safeStringOp2("Ready", (s: String) => s.reverse))


    // 4.Placeholder Syntax
    val doubler3: Int => Int = _ * 2
    // (x: Int) => Int = x * 2의 형식에서 와일드카드 _를 사용하면서 x를 생략

    def safeStringOp3(s: String, f: String => String) = {
      if (s != null) f(s) else s
    }

    safeStringOp3(null, _.reverse)
    safeStringOp3("Ready", _.reverse)

    def combination(x: Int, y: Int, f: (Int, Int) => Int) = {
      f(x, y)
    }

    combination(23, 12, _ * _)

    def tripleOp(a: Int, b: Int, c: Int, f: (Int, Int, Int) => Int) = f(a, b, c)

    tripleOp(23, 92, 14, _ + _ * _)

    def tripleOp2[A, B](a: A, b: A, c: A, f: (A, A, A) => B) = f(a, b, c)

    tripleOp2[Int, Int](1, 2, 3, _ + _ + _)


    // 5.Partially-Applied Functions And Currying : 부분 적용 함수 및 커링
    def factorOf(x: Int, y: Int) = y % x == 0

    val f = factorOf _
    val x = f(7, 20)

    val multipleOf3 = factorOf(3, _: Int)
    val x2 = multipleOf3(6)

    def factorOf2(x: Int)(y: Int) = y % x == 0

    val isEven = factorOf2(2) _
    val z = isEven(32)


    // 6.By-Name Parameters
    def doubles6(x: => Int) = x * 2

    def doubles7(x: => Int) = x * 2
    // (x: => Int) = x * 2 처음보는 타입이다.
    // 입력 받는 함수의 반환 값은 Int로하고
    // 입력 받는 함수의 파라미터 x는 어떤 타입인지 신경 안쓰겠다 라는건가?
    // 입력 받는 함수가 함수타입알고 명시하는 것인데
    // 입력 받는 함수의 입력 타입을 Int로 넣어주면 에러가 발생하고 안넣어주면 된다.
    // 이름으로 함수를 받아 쓰는 입장에서는 받아쓰는 input이 의미가 없어서?
    // 아니면 어차피 함수에 표현되니까 인트인지 스트링인지 무엇인지는 f(8) 이렇게 그래서 생략인가?

    def f(i: Int) = {
      println(s"Hello From f($i)")
      i
    }

    def s(i: String) = {
      s"Hello From f($i)"
      2
    }

    doubles6(f(8))
    doubles6(s("a"))
    doubles7(f(8))
    doubles7(s("a"))


    // 7.Partial Functions 부분 함수
    // 입력 매개 변수가 필요 없다.
    val statusHandler: Int => String = {
      case 200 => "Okay"
      case 400 => "Your Error"
      case 500 => "Our Error"
    }
    // 조금 헷깔리내 - 보통은 = 에 함수를 넣어주고
    //    val asdfasdf: Int => Int = {x * 2} // error
    //    def ddd(x: Int): Int =  { x * 2}
    //    val asdfasdf: Int => Int = ddd


    // 8.Invoking Higher-Order Functions WIth Function Literal Blocks
    def safeStringOp8(s: String, f: String => String) = {
      if (s != null) f(s) else s
    }

    val uuid = java.util.UUID.randomUUID().toString
    val timedUUID = safeStringOp8(uuid, { s =>
      val now = System.currentTimeMillis
      val timed = s.take(24) + now
      timed.toUpperCase
    })

    def safeStringOp9(s: String)(f: String => String) = {
      if (s != null) f(s) else s
    }

    val uuid2 = java.util.UUID.randomUUID().toString
    val timedUUID = safeStringOp9(uuid2) { s =>
      val now = System.currentTimeMillis
      val timed = s.take(24) + now
      timed.toUpperCase
    }

    /* 이해 불가
    scala> def timer[A](f: => A): A = {                                         (1)
     |   def now = System.currentTimeMillis                                 (2)
     |   val start = now; val a = f; val end = now
     |   println(s"Executed in ${end - start} ms")
     |   a
     | }
     timer: [A](f: => A)A

     scala> val veryRandomAmount = timer {                                       (3)
     |   util.Random.setSeed(System.currentTimeMillis)
     |   for (i <- 1 to 100000) util.Random.nextDouble                      (4)
     |   util.Random.nextDouble
     | }
     Executed in 13 ms
     veryRandomAmount: Double = 0.5070558765221892
     */


  }


}
