package lectures.part3fp

object TuplesAndMaps extends App {

  //tuples = finite order list
  val aTuple = new Tuple2(2, "Hello scala")
  val aTuple2 = Tuple2(2, "Hello scala")
  val aTuple3 = (2, "Hello scala")

  println(aTuple)
  println(aTuple._1)
  println(aTuple._2)

  println(aTuple.copy(_2  = "Bye"))
  println(aTuple.swap)

  //Maps
  val aMap: Map[String, Int] = Map()

  // a -> b is sugar for (a, b)
  val phoneBook = Map(("Jim", 555), "Mike" -> 789).withDefaultValue("-1")

  println(phoneBook)

  //maps ops
  println(phoneBook.contains("Jim"))
  println(phoneBook.contains("Jacob")) // -1
  println(phoneBook("Jim"))

  //add pairing
  val newPairing = "Mary" -> 678
  val newPhoneBook = phoneBook + newPairing //Reverse order doesn't work

  //Functionals on maps
  println(newPhoneBook.map(pair => pair._1.toLowerCase() -> pair._2))

  //Filter
  println(phoneBook.filterKeys(e => e.startsWith("J")))

  //mapValues
  println(phoneBook.mapValues (number => "555-" + number))

  //Conversions
  println(phoneBook.toList)
  println(List("Daniel" -> 111).toMap)

  //GroupBy
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))
  //Map(J -> List(James, Jim), A -> List(Angela), M -> List(Mary), B -> List(Bob), D -> List(Daniel))

}
