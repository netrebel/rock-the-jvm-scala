package lectures.part3fp

object WhatsAFunction extends App {

  //DREAM: use functions as first class citizens
  //Problem: OOP

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(2))

  val stringToIntConverter = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder: Function2[Int, Int, Int] = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  //With Single Abstract Method
  val adder2: Function2[Int, Int, Int] = (v1: Int, v2: Int) => v1 + v2

  //With syntactic sugar for the return type
  val adder3: (Int, Int) => Int = (v1: Int, v2: Int) => v1 + v2

  //With syntactic sugar 2
  val adder4 = (v1: Int, v2: Int) => v1 + v2

  //Function types Function2[A, B, R] === (A, B) => R

  //ALL SCALA FUNCTIONS ARE OBJECTS, or instances of classes deriving from FunctionX

  println(adder4(1, 2))

  val concatenator = (v1: String, v2: String) => {
    v1.concat(v2)
  }

  println(concatenator("hello ", "world"))


  val specialFunction: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }

  val specialFunction2: Function1[Int, Function1[Int, Int]] = (v1: Int) => new Function1[Int, Int] {
    override def apply(v2: Int): Int = v1 + v2
  }

  val specialFunction3: Function1[Int, Function1[Int, Int]] = (v1: Int) => (v2: Int) => v1 + v2
  val specialFunction4: (Int) => Function1[Int, Int] = (v1: Int) => (v2: Int) => v1 + v2
  val specialFunction5: (Int) => ((Int) => Int) = (v1: Int) => (v2: Int) => v1 + v2
  val specialFunction6: Int => Int => Int = (v1: Int) => (v2: Int) => v1 + v2

  println(specialFunction6(9)(9))
}


trait MyFunction[A, B] {
  def apply(element: A): B
}