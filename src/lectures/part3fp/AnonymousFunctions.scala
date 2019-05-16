package lectures.part3fp

object AnonymousFunctions extends App {

  //anonymous function (LAMBDA)
  val doubler: Int => Int = (x: Int) => x * 2

  //Multiple params in lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  //No params
  val doSomething: () => Int = () => 3

  //careful
  println(doSomething) //Prints function itself
  println(doSomething()) //Call

  //curly braces with Lambdas
  val stringToInt = { str: String =>
    str.toInt
  }

  //More syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 //Equivalent to (x: Int) => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ //Equivalent to (a, b) => a + b
}
