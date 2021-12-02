import TestUtils.convertStringToIntArray
import org.scalatest._
import org.scalatest.matchers.should.Matchers
import wordspec._

import scala.io.Source

class Day1Test extends AnyWordSpec with Matchers {
  "Day1Test- PartOne" should {
    "Handle the sample test" in {
      val data = TestUtils.convertStringToIntArray("""199
200
208
210
200
207
240
269
260
263""")

      val expected = 7
      val actual = Day1.countIncreases(data)

      actual should be(expected)
    }

    "Actual data" in {
      val data = Source.fromResource("dayone.txt").getLines().map(_.trim).filterNot(_.isEmpty).map(_.toInt)
      val expected = 1759
      val actual = Day1.countIncreases(data)

      actual should be(expected)
    }
  }

  "Day1Part2" should {
    "Handle the sample test" in {
      val data = convertStringToIntArray("""199
200
208
210
200
207
240
269
260
263""")

      val expected = 5
      val actual = Day1.countIncreasesByThree(data)

      actual should be(expected)
    }

    "Actual data" in {
      val data = Source.fromResource("dayone.txt").getLines().map(_.trim).filterNot(_.isEmpty).map(_.toInt)
      val expected = 1805
      val actual = Day1.countIncreasesByThree(data)

      actual should be(expected)
    }
  }

}
