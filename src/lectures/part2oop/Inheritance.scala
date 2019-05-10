package lectures.part2oop

object Inheritance extends App {

  //Single class inheritance

  sealed class Animal {
    val creatureType = "wild"
    /*protected*/ def eat = println("eating") //protected can only be called from classes that extend Animal
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch")
    }
  }

  val cat = new Cat
  cat.crunch //cannot call cat.eat because .eat is protected

  //constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name/*, age*/)

  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType: String = "domestic" //can be overriden in the constructor
    override def eat: Unit = {
      super.eat
      println("dog crunch")
    }

  }

  val dog = new Dog("k9")
  dog.eat
  println(dog.creatureType)

  //Type substitution (Polymorphism)
  val unknownAnimal : Animal = new Dog("K9")
  unknownAnimal.eat

  //super see #L31

  //preventing overrides
  // 1. use 'final' on a method #L9
  // 2. use 'final' on a class
  // 3. 'sealed' the class = only extends the classes in THIS file, but prevents extension in other files.

}
