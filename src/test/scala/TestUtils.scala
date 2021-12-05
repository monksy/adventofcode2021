import Day2.{Down, DownWithAim, Forward, ForwardWithAim, Movement, Position, PositionWithAim, Up, UpWithAim}

import scala.reflect.ClassTag

object TestUtils {
  def convertStringToArray[B:ClassTag](data: String)(f: String=>B): Iterator[B] = {
    data.stripMargin.split('\n').map(_.trim).map(f).iterator
  }

  def stringToMovement(value: String): Movement[Position] = value.toLowerCase match {
    case "forward" => Forward
    case "up" => Up
    case "down" => Down
    case a => throw new UnsupportedOperationException(a)
  }
  def stringToMovementWithAim(value: String): Movement[PositionWithAim] = value.toLowerCase match {
    case "forward" => ForwardWithAim
    case "up" => UpWithAim
    case "down" => DownWithAim
    case a => throw new UnsupportedOperationException(a)
  }
}
