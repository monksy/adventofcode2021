import Day2.{Down, DownWithAim, Forward, ForwardWithAim, Up, UpWithAim}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.io.Source


class Day2Test extends AnyWordSpec with Matchers {

  "Day2Test- PartOne" should {
    "Handle the sample test" in {
      val data = Iterator(Forward -> 5, Down -> 5, Forward -> 8, Up -> 3, Down -> 8, Forward -> 2)

      val expected = 150
      val actual = Day2.totalMovement(data)

      actual should be(expected)
    }

    "Actual data" in {
      //We're assuming this file content is good
      val data = Source.fromResource("daytwo").getLines()
        .map(_.trim).filterNot(_.isEmpty).map(_.split(" "))
        .map(l=> (TestUtils.stringToMovement(l(0)), l(1).toInt))

      val expected = 2120749
      val actual = Day2.totalMovement(data)

      actual should be(expected)
    }
  }

  "Day2Part2" should {
    "handle the sample test" in {
      /*

    forward 5 adds 5 to your horizontal position, a total of 5. Because your aim is 0, your depth does not change.
    down 5 adds 5 to your aim, resulting in a value of 5.
    forward 8 adds 8 to your horizontal position, a total of 13. Because your aim is 5, your depth increases by 8*5=40.
    up 3 decreases your aim by 3, resulting in a value of 2.
    down 8 adds 8 to your aim, resulting in a value of 10.
    forward 2 adds 2 to your horizontal position, a total of 15. Because your aim is 10, your depth increases by 2*10=20 to a total of 60.

After following these new instructions, you would have a horizontal position of 15 and a depth of 60. (Multiplying these produces 900.)
       */
      val data = Iterator(ForwardWithAim -> 5, DownWithAim -> 5, ForwardWithAim -> 8, UpWithAim -> 3, DownWithAim -> 8, ForwardWithAim -> 2)

      val expected = 900
      val actual = Day2.totalMovementWithAim(data)

      actual should be(expected)
    }

    "Actual data" in {
      //We're assuming this file content is good
      val data = Source.fromResource("daytwo").getLines()
        .map(_.trim).filterNot(_.isEmpty).map(_.split(" "))
        .map(l=> (TestUtils.stringToMovementWithAim(l(0)), l(1).toInt))

      val expected = 2138382217
      val actual = Day2.totalMovementWithAim(data)

      actual should be(expected)
    }
  }
}
/*
forward 5
down 5
forward 8
up 3
down 8
forward 2
 */
