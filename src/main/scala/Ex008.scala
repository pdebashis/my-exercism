
object Etl {
  def transform(scoreMap: Map[Int, Seq[String]]): Map[String, Int] = {
    scoreMap.flatMap{ case (score, letters) =>
      letters.map( char => (char.toLowerCase() -> score))
    }
  }
}


object Ex008 extends App {

  println(Etl.transform(Map(1 -> Seq("A", "E", "I", "O", "U"))))
}