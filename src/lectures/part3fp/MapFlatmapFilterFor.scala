package lectures.part3fp

object MapFlatmapFilterFor extends App {
  val list = List(1, 2, 3)
  println("Head: " + list.head)
  println("Tail: " + list.tail)

  //map
  println(list.map(e => e + 1)) //println(list.map(_ + 1))

  //Filter
  println(list.filter(i => i % 2 == 0))

  //flatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair)) //List(List(1, 2), List(2, 3), List(3, 4)) becomes List(1, 2, 2, 3, 3, 4)

  //print all combinations between two lists
  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("black", "white")

  for (num <- numbers) {
    for (ch <- chars) {
      println(ch + num.toString)
    }
  }

  val combinations = numbers.flatMap(n => colors.flatMap(color => chars.map(c => "" + c + n + "-" + color)))
  println(combinations)

  //foreach
  list.foreach(println)

  //for-comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color

  print(forCombinations)

  for {
    n <- numbers
  } println(n)

  //syntax overload
  val res = list.map { x =>
    x * 2
  }
  println(res)

}
