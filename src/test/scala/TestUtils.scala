import Day2.{Down, Forward, Movement, Up}

object TestUtils {
  def convertStringToIntArray(data: String): Iterator[Int] = {
    data.stripMargin.split('\n').map(_.trim).map(_.toInt).iterator
  }

  def stringToMovement(value: String): Movement = value.toLowerCase match {
    case "forward" => Forward
    case "up" => Up
    case "down" => Down
    case a => throw new UnsupportedOperationException(a)
  }
}
