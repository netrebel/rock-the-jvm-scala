package lectures.part2oop

object Counter extends App {

  val counter = new Counter(0)
  println(counter.count) //0
  println(counter.increment.increment.increment.count) //1
  println(counter.increment(2).count)
//  println(counter.count) //0
//  println(counter.decrement.count) //-1
//  println(counter.count) //-1
//  println(counter.count)
//  println(counter.decrement(2).count)
//  println(counter.count)
}

class Counter(val count: Int) {

  def increment: Counter =  {
    println("incrementing")
    new Counter(count + 1)
  }

  def decrement: Counter = new Counter(count - 1)

  def increment(n: Int): Counter = {
    if (n <= 0) this
    else increment.increment(n - 1)
  }

  def decrement(n: Int): Counter = {
    if (n <= 0) this
    else decrement.decrement(n - 1)
  }
}