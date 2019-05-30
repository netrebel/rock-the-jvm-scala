package lectures.part3fp

import java.util.Random

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)

  //Work with unsafe APIs
  def unsafeMethod(): String = null

  val result = Option(unsafeMethod()) //Some or None
  println(result)

  //chained methods
  def backupMethod(): String = "A valid response"

  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  //DESIGN unsafe APIs.
  def betterUnsafeMethod(): Option[String] = None

  def betterBackupMethod(): Option[String] = Some("A valid result")

  val betterChainedResult = betterUnsafeMethod().orElse(betterBackupMethod())

  //Functions or Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) //Unsafe! - DO NOT USE THIS

  //Map, flatMap, filter
  println(myFirstOption.map(_ * 2)) //Some(8)
  println(myFirstOption.filter(x => x > 10)) // None
  println(myFirstOption.flatMap(x => Option(x * 10))) // Some(40)


  //for-comprehensions

  val config: Map[String, String] = Map(
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected"
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  val host: Option[String] = config.get("host")
  val port: Option[String] = config.get("port")

  /*
    if(h != null)
      if(p != null)
        return Connection.apply(h, p)
    return null
  */
  val connection: Option[Connection] = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))

  /*
    if (c != null)
      return c.connect
    return nullf
   */
  val connectionStatus: Option[String] = connection.map(c => c.connect)

  // if (connectionStatus == null) println(None) else print (Some(connectionStatus.get))
  println(connectionStatus)

  /*
    if (status != null)
      println(status)
   */
  connectionStatus.foreach(println)


  //chained calls
  config.get("host")
    .flatMap(h => config.get("port")
      .flatMap(p => Connection(h, p)))
    .map(connection => connection.connect)
    .foreach(println)

  //for comprehensions
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect

  println(forConnectionStatus)

}
