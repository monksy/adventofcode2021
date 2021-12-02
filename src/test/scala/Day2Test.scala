import Day2.{Down, Forward, Up}
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
}
/*
forward 5
down 5
forward 8
up 3
down 8
forward 2
 */
