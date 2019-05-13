package lectures.part2oop

object CaseClasses extends App {

  // equals, hashCode, toString

  case class Person(name: String, age: Int)

  //1. class parameters are fields
  val jim = Person("Jim", 34)
  println(jim.name)

  //2. Sensible toString
  //println(jim.toString) == println(jim) //Syntactic sugar
  println(jim/*.toString*/)

  //3. equals and hashCode implemented out-of-the-box
  val jim2 = Person("Jim", 34)
  println(jim == jim2) //true

  //4. CaseClasses have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim == jim3) //false

  //5. Case Classes have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23) //Call the apply method in the companion object

  //6. Case classes are serializable
  //Useful when working with Akka

  //7. Case classes have extractor patters = CCs can be used in PATTERN MATCHING
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }
}
