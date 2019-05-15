package exercises

abstract class MyList[+A] {

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](n: B): MyList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"

  //Higher order functions
  def map[B](transformer: A => B): MyList[B]

  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  def filter(predicate: A => Boolean): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]

}

case object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](n: B): MyList[B] = new Cons(n, Empty)

  override def printElements: String = ""

  override def map[B](transformer: Nothing => B): MyList[B] = Empty

  override def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  override def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](n: B): MyList[B] = new Cons(n, this)

  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  override def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  override def map[B](transformer: A => B): MyList[B] =
    new Cons[B](transformer(h), t.map(transformer))

  /*
    [1, 2].flatMap(n => [n, n + 1])
    = [1, 2] ++ [2].flatMap(n => [n, n+1])
    = [1, 2] ++ [2, 3] ++ Empty.flatMap(n => [n, n+1])
    = [1, 2] ++ [2, 3] ++ Empty
    = [1, 2, 2, 3]
   */
  override def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  /*
    [1,2] ++ [3, 4, 5]
    = new Cons(1, [2] ++ [3, 4, 5]
    = new Cons(1, new Cons(2, Empty ++ [3, 4, 5]))
    = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))
   */
  override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
}


object ListTest extends App {
//  val list : Cons[Int] = new Cons[Int](1, new Cons(2, new Cons(3, Empty)))
//  println(list.tail.head)
//  println(list.add(4).head)
//  println(list.isEmpty)
//  println(list.toString)

  val listOfIntegers: MyList[Int] = new Cons[Int](1, new Cons(2, new Cons(3, Empty)))
  val cloneOfListOfIntegers: MyList[Int] = new Cons[Int](1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons[Int](4, new Cons(5, Empty))
  val listOfStrings: MyList[String] = new Cons[String]("Hello", new Cons("Scala", new Cons("Rockstar", Empty)))
  println(listOfIntegers.toString)
  println(listOfStrings.toString)


  println(listOfIntegers.map(new Function1[Int, Int] {
    override def apply(elem: Int): Int = elem * 2
  }).toString) //[2 4 6]

  println(listOfIntegers.filter(new Function1[Int, Boolean] {
    override def apply(element: Int): Boolean = element % 2 == 0
  }).toString) //[2]

  println((listOfIntegers ++ anotherListOfIntegers).toString) // [1 2 3 4 5]

  println(listOfIntegers.flatMap(new Function1[Int, MyList[Int]] {
    override def apply(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem + 1, Empty))
  }).toString) //[1 2 2 3 3 4]

  println(cloneOfListOfIntegers == listOfIntegers) //true
}
