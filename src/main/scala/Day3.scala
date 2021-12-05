object Day3 {
  def getBinaryDigitFrequency(values: Iterable[String]):Iterable[Map[Char, Int]] = {
    values.toList.
      flatMap(_.zipWithIndex).
      groupMap(_._2)(_._1).toList.sortBy(_._1).map(_._2).
      map(_.groupBy(identity).mapValues(_.size).toMap)
  }

  def gamaRate(iterator: Iterable[Map[Char, Int]]): String = {
    iterator.map(_.maxBy(_._2)._1).mkString("")
  }
  def epsilonRate(iterator: Iterable[Map[Char, Int]]): String = {
    iterator.map(_.minBy(_._2)._1).mkString("")
  }
  def binaryStringToInt(value: String):Int = Integer.parseInt(value, 2)

  def partOneSolution(values: Iterable[String]):Int = {
    val calc = getBinaryDigitFrequency(values)
    List(epsilonRate(calc), gamaRate(calc)).map(binaryStringToInt).product
  }
}
