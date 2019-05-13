package lectures.part2oop

object AnonymousClasses extends App {

  abstract class /*or just a trait*/ Animal {
    def eat: Unit
  }

  //Anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("I'm a funny animal")
  }

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name. How can I help?")
  }

  //Anonymous classes work with non-abstract classes as well
  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim. How can I be of service?")
  }

}
