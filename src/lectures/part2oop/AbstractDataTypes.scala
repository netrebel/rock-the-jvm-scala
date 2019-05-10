package lectures.part2oop

object AbstractDataTypes extends App {

  //abstract
  abstract class Animal {
    val creatureType: String = "wild"

    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "canine"

    override def eat: Unit = println("crunch crunch")

  }

  //traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {

    override val creatureType: String = "crocodile"

    override def eat: Unit = "nomnomnom"

    override def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  //Traits vs abstract classes
  // 1. Traits do not have constructor parameters
  // 2. Multiple traits may be inherited by the same class
  // 3. traits = behavior, abstract class = type of thing


}
