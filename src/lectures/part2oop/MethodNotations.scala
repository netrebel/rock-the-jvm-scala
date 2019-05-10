package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickname: String): Person = new Person(s"${this.name} (the $nickname)", this.favoriteMovie)

    def unary_! : String = s"$name, what the heck!"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(n: Int): String = s"${this.name} watched ${this.favoriteMovie} $n times"

    def learns(lang: String): String = s"${this.name} learns $lang"
    def learnsScala(): String = learns("Scala")

  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") //infix operation or operator notation. Only for methods with one parameter --> Syntactic sugar

  //"Operators" in Scala

  val tom = new Person("Tom", "Fight club")
  println(mary + tom)
  println(mary.+(tom))

  //All operators are methods
  println(1 + 2)
  println(1.+(2))

  //Akka actors have ! (tell) ? (ask)

  //Prefix notation
  val x = -1 // - is a unary operator
  val y = 1.unary_-

  //unary_ prefix only works with - + ~ !
  print(!mary)

  //Postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary()) //Whenever we call a Class as a function, apply() gets called.

  //1. Overload + operator
  println((mary + "the rockstar").name)
  println((mary + "the rockstar")())
  println((mary + "the rockstar").apply())

  //2. Add age to the Person class with default 0 value and add Unary + operator => new Person with the age + 1
  println((+mary).age)

  //3. Add a "learns" method in the Person class => Mary learns Scala
  println(mary.learns("Scala"))

  // Add 'learnsScala' method that doesn't receive any parameters and calls the 'learns' method with "Scala" as a parameter
  // Use it in Postfix notation
  println(mary learnsScala)

  //Overload the apply method and returns a string
  println(mary.apply(2))
  println(mary(2))

}
