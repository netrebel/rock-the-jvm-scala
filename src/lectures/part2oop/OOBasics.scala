package lectures.part2oop

object OOBasics extends App {
  val person = new Person("Miguel", 38)
  println(person.age)
  person.greet("Daniel")
  person.greet()
}

class Person(name: String, val age: Int = 0) {

  val x = 2

  println(1 + 3) //Gets printed first

  //method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  //overloading
  def greet(): Unit = println(s"Hi, I am $name")

  //multiple constructors
  def this(name: String) = this(name, 0) //This auxiliary constructor can be avoided by adding a default value for the parameter: class Person(name: String, val age: Int = 0) {
  def this() = this("John")

}

//Class parameters are NOT FIELDS