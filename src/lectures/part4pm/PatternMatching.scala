package lectures.part4pm

object PatternMatching extends App {

  case class Person(name: String, age: Int)

  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(n, a) if a < 21 => println(s"Hi, my name is $n and I can't drive")
    case Person(n, a) => println(s"Hi, my name is $n and I'm $a years old")
    case _ => "Unknown"
  }

  /*
  * 1. cases are matched in order
  * 2. what if no cases match? MatchError
  * 3. Type of a PM expression? Unified types of all the types in all the cases.
  * 4. PM works really well with case classes
  * */

  //PM on sealed hierarchies

  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("chihuahua")
  animal match {
    case Dog(somebreed) => println(s"Matched dog with some breed $somebreed")
  }

}
