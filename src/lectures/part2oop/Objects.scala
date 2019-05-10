package lectures.part2oop

object Objects extends App {

  //Scala does not have CLASS-LEVEL functionality ("static"), Instead we do

  object Person {
    //"static" class level functionality
    val N_EYES = 2

    def canFly: Boolean = true

    //Factory method, builds persons give parameters
    def apply(mother: Person, father: Person) : Person = new Person("Bob")
  }

  //COMPANIONS
  class Person(val name: String) {
    //instance level functionality
  }

  println(Person.N_EYES)
  println(Person.canFly)

  //Scala object = SINGLETON INSTANCE
  val person1 = Person
  val person2 = Person
  println(person1 == person2) //true

  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john) //false

  val bob = Person(mary, john) //Person.apply(mary, john)
  println(bob.name) //Bob

  // Scala applications == Scala objects with this method
  // def main(args: Array[string]): Unit

}
