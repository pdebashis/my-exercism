
object Twofer {
  def twofer(name: String): String = s"One for ${name}, one for me."
  def twofer(): String = "One for you, one for me."
}


object Ex002 extends App {
  println(Twofer.twofer())
  println(Twofer.twofer("Alice"))
}