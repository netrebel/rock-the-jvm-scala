package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  def aParameterLessFunction(): Int = 42

  println(aFunction("1", 2))
  println(aParameterLessFunction())
  println(aParameterLessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if(n == 1) aString
    else
      aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))
}
