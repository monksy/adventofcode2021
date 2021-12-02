import org.scalatest._
import org.scalatest.matchers.should.Matchers
import wordspec._

import scala.io.Source

class Day1Test extends AnyWordSpec with Matchers {
  "Day1Test" should {
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

      val expected = 7
      val actual = Day1.countIncreases(data)

      actual should be(expected)
    }

    "Actual data" in {
      val data = Source.fromResource("dayone.txt").getLines().map(_.trim).filterNot(_.isEmpty).map(_.toInt).toSeq
      val expected = 1759
      val actual = Day1.countIncreases(data)

      actual should be(expected)
    }
  }

  private def convertStringToIntArray(data: String): Seq[Int] = {
    data.stripMargin.split('\n').map(_.trim).map(_.toInt).toSeq
  }
}
