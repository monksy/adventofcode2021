import org.scalactic.source.Position

object Day2 {

  def totalMovement(instructions: Iterator[(Movement[Position], Int)]): Int = {
    val result = instructions.foldLeft(zero)((r,a)=> a._1.move(r)(a._2))
    result._1*result._2
  }

  def totalMovementWithAim(instructions: Iterator[(Movement[PositionWithAim], Int)]): Int = {
    val result = instructions.foldLeft(zeroWithAim)((r,a)=> a._1.move(r)(a._2))
    result._1*result._2
  }



  type Position= (Int, Int)
  val zero:Position = (0,0)
  type PositionWithAim = (Int, Int, Int)
  val zeroWithAim: PositionWithAim = (0,0, 0)

  sealed trait Movement[T] { def move(position: T)(amount: Int): T }
  object Forward extends Movement[Position] {
    override def move(position: Position)(amount: Int): (Int, Int) = position.copy(_1 = position._1+amount)
  }
  object Down extends Movement[Position] {
    override def move(position: Position)(amount: Int): (Int, Int) = position.copy(_2 = position._2+amount)
  }
  object Up extends Movement[Position] {
    override def move(position: Position)(amount: Int): (Int, Int) = position.copy(_2 = position._2-amount)
  }

  object ForwardWithAim extends Movement[PositionWithAim] {
    override def move(position: PositionWithAim)(amount: Int): PositionWithAim = position.copy(_1 = position._1+amount, _2 = position._2+(position._3*amount))
  }
  object DownWithAim extends Movement[PositionWithAim] {
    override def move(position: PositionWithAim)(amount: Int): PositionWithAim = position.copy(_3 = position._3+amount)
  }
  object UpWithAim extends Movement[PositionWithAim] {
    override def move(position: PositionWithAim)(amount: Int): PositionWithAim = position.copy(_3 = position._3-amount)
  }


/*

    down X increases your aim by X units.
    up X decreases your aim by X units.
    forward X does two things:
        It increases your horizontal position by X units.
        It increases your depth by your aim multiplied by X.

Again note that since you're on a submarine, down and up do the opposite of what you might expect: "down" means aiming in the positive direction.

 */

}
