object TestUtils {
  def convertStringToIntArray(data: String): Iterator[Int] = {
    data.stripMargin.split('\n').map(_.trim).map(_.toInt).iterator
  }
}
