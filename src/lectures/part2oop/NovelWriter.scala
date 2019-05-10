package lectures.part2oop

object NovelWriter extends App {

  val writer = new Writer("Miguel", "Reyes", 1981)
  val novel = new Novel("In my lifetime", 2003, writer)

  println(novel.authorAge)
  println(novel.isWrittenBy(writer))
  println(novel.copy(2013).authorAge)

}

class Writer(firstName: String, surName: String, val year: Int) {
  def fullName: String = s"$firstName $surName"
}

class Novel(name: String, releaseYear: Int, author: Writer) {
  def authorAge: Int = releaseYear - author.year

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(year: Int): Novel = new Novel(name, year, author)

}