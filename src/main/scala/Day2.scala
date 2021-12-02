object Day2 {

  def totalMovement(instructions: Iterator[(Movement, Int)]): Int = {
    val result = instructions.foldLeft(zero)((r,a)=> a._1.move(r)(a._2))
    result._1*result._2
  }
  //In position the 1st value is the horizontal movement, 2nd value is the depth
  type Position= (Int, Int)
  val zero:Position = (0,0)

  sealed trait Movement { def move(position: Position)(amount: Int): Position }
  object Forward extends Movement {
    override def move(position: (Int, Int))(amount: Int): (Int, Int) = position.copy(_1 = position._1+amount)
  }
  object Down extends Movement {
    override def move(position: (Int, Int))(amount: Int): (Int, Int) = position.copy(_2 = position._2+amount)
  }
  object Up extends Movement {
    override def move(position: (Int, Int))(amount: Int): (Int, Int) = position.copy(_2 = position._2-amount)
  }

}
