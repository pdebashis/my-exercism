class Robot {
  private var _name = ""
  reset()
  def name = _name
  def reset() = _name = Robot.allocateName
}

object Robot {

  private val alphas = Stream.concat(Stream.from('A').take(26), Stream.from('a').take(26)).map {
    _.toChar
  }

  private val names = {
    val s = for {
      x <- alphas
      y <- alphas
      serial <- Stream.from(0)
    } yield f"$x$y${serial}%03d".format(x, y, serial)
    s.iterator
  }

  def allocateName = names.next

}