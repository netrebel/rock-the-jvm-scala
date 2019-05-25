package lectures.part3fp

object Sequences extends App {

  //Seq
  val aSequence = Seq (1, 2, 3, 4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++  Seq(7, 6, 5))
  println(aSequence.sorted)

  //Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  (1 to 10).foreach(x => println("Hello:" + x) )

  //Lists
  val aList = List(1, 2, 3)
  val prepended = 42 :: aList // 42 +: aList
  println(prepended)
  val appended = prepended :+ "52"
  println(appended)

  val apple5 = List.fill(5)("apple")
  println(apple5)

  println(aList.mkString("-|-"))

  //Arrays
  val numbers = Array(1, 2, 3, 4)
  val threeElems = Array.ofDim[Int](3)
  println(threeElems)
  threeElems.foreach(println)

  //mutation
  numbers(2) = 0
  println(numbers.mkString(" "))

  //arrays and seq
  val numbersSeq: Seq[Int] = numbers //Valid! Implicit conversion
  println(numbersSeq)



}
