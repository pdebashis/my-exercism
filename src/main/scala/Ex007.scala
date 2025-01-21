object Hamming {
  def distance(dnaStrandOne: String, dnaStrandTwo: String): Option[Int] = {
    if(dnaStrandOne.length != dnaStrandTwo.length) None
    else{
      Some(dnaStrandOne.zip(dnaStrandTwo).count{ case (x,y) => x != y})
    }
  }
}


object Ex007 extends App {
  println(Hamming.distance("GAGCCTACTAACGGGAT", "CATCGTAATGACGGCCT"))
}