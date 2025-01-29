
object ReverseString {
  def reverse(str: String): String = {
    str.toCharArray.foldRight(""){ case (curr, acc) =>
      acc + curr
    }
  }
}

object Ex009 extends App {

  println(ReverseString.reverse("Palindrome"))
}