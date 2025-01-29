
object Bob {
  def response(statement: String): String = {
    val cleanStatement = statement.replaceAll("\\d", "").strip
    cleanStatement match {
      case s if s.isEmpty => "Fine. Be that way!"
      case s if (s.exists(_.isLetter) && s == s.toUpperCase && s.endsWith("?")) => "Calm down, I know what I'm doing!"
      case s if (s.exists(_.isLetter) && s == s.toUpperCase) => "Whoa, chill out!"
      case s if s.endsWith("?") => "Sure."
      case _ => "Whatever."
    }
  }
}


object Ex006 extends App {
  println(Bob.response("WATCH OUT!"))
}