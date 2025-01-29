
object Leap {
  def leapYear(year: Int): Boolean = year match {
    case yr if (year%400 == 0) => true
    case yr if (year%100 == 0) => false
    case yr if (year%4 == 0) => true
    case _ => false
  }
}

object Ex003 extends App {
  println(Leap.leapYear(2025))
}