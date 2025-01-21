object Bearing extends Enumeration {
  val North, South, West, East = Value
}

case class Robot(val bearing: Bearing.Value, val coordinates: (Int, Int)) {

  def turnRight :Robot = {
    val newBearing = Map( Bearing.North -> Bearing.East,
      Bearing.East -> Bearing.South,
      Bearing.South -> Bearing.West,
      Bearing.West -> Bearing.North,
    ).apply(bearing)
    Robot(newBearing, coordinates)
  }

  def turnLeft :Robot = {
    val newBearing = Map( Bearing.North -> Bearing.West,
      Bearing.East -> Bearing.North,
      Bearing.South -> Bearing.East,
      Bearing.West -> Bearing.South,
    ).apply(bearing)
    Robot(newBearing, coordinates)
  }

  def advance = bearing match {
    case Bearing.East => val newCords = (coordinates._1+1,coordinates._2)
      Robot(bearing, newCords)
    case Bearing.West =>  val newCords = (coordinates._1-1,coordinates._2)
      Robot(bearing, newCords)
    case Bearing.North => val newCords = (coordinates._1,coordinates._2+1)
      Robot(bearing, newCords)
    case Bearing.South => val newCords = (coordinates._1,coordinates._2-1)
      Robot(bearing, newCords)
    case _ => this
  }

  def simulate(str: String) :Robot = {
    str.foldLeft(this){ (robot, curr) =>
      curr match {
        case 'R' => robot.turnRight
        case 'A' => robot.advance
        case 'L' =>  robot.turnLeft
        case _ => robot
      }
    }
  }

}

object Ex010 extends App {
  println(Robot(Bearing.South, (0, 0)).turnRight.bearing)
}