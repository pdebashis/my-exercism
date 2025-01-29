
class School {
  type DB = Map[Int, Seq[String]]

  private var database: DB = Map.empty

  def add(name: String, g: Int) = {
    val names : Seq[String] = grade(g) :+ name
    database = database + (g -> names)
  }

  def db: DB = database

  def grade(g: Int): Seq[String] = database.getOrElse(g, Seq.empty)

  def sorted: DB = database.mapValues(_.sorted).toSeq.sortBy(_._1).toMap

}



object Ex005 extends App {
  val school = new School
  println(school.db)

  school.add("Aimee", 2)
  println(school.db)
}