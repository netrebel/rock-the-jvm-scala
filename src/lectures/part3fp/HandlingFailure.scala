package lectures.part3fp

import java.util.Random

import scala.util.{Failure, Success, Try}

object HandlingFailure extends App {
  //create success and failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("Super failure"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("No string for you")

  //Try objects via the apply method
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  //Syntax sugar
  val anotherPotentialFailure = Try {
    //code that might throw error
  }

  //utilities
  println(potentialFailure.isSuccess)
  println(potentialFailure.isFailure)

  //orElse
  def backupMethod(): String = "A valid result"

  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println(fallbackTry)

  //If you design an API
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)

  def betterBackupMethod(): Try[String] = Success("A valid result")

  val betterFallback = betterUnsafeMethod().orElse(betterBackupMethod())
  println(betterFallback)

  //map, flatMap, filter
  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10))
  println(aSuccess.filter(_ < 10))

  //for-comprehensions Exercise
  val host = "localhost"
  val port = "8080"

  def renderHtml(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection interrupted")
    }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection = {
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")
    }

    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }

  //If you get the Html page from the connection, print it to the console. i.e. call renderHtml
  val triedConnection = HttpService.getSafeConnection(host, port)
  val possibleHtml = triedConnection.flatMap(connection => connection.getSafe("/home"))
  possibleHtml.foreach(renderHtml)

  //Short version
  HttpService.getSafeConnection(host, port)
    .flatMap(connection => connection.getSafe("/home"))
    .foreach(renderHtml)

  //for-comprehension
  for {
    connection <- HttpService.getSafeConnection(host, port)
    html <- connection.getSafe("/home")
  } renderHtml(html)
}
