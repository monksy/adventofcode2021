import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.io.Source

class Day3Test extends AnyWordSpec with Matchers {

  "Day3Part1" should {

    "gamaRate" should  {
      "Test sample" in {
        val expected = "BC"
        val data = List(Map('A'->1, 'B'-> 2), Map('C'->3, 'D'-> 2))

        val actual = Day3.gamaRate(data)

        actual should be (expected)
      }
    }

    "episilonRate" should  {
      "Test sample" in {
        val expected = "AD"
        val data = List(Map('A'->1, 'B'-> 2), Map('C'->3, 'D'-> 2))

        val actual = Day3.epsilonRate(data)

        actual should be (expected)
      }
    }


    "fullSollution" should {
      "Should handle the sample" in {
        val data = """00100
                     |11110
                     |10110
                     |10111
                     |10101
                     |01111
                     |00111
                     |11100
                     |10000
                     |11001
                     |00010
                     |01010""".stripMargin.split("\n")

        val actual = Day3.partOneSolution(data)
        val expected= 198

        actual should be(expected)
      }

      "Should handle actual application" in {
        val data = Source.fromResource("day3").getLines().map(_.trim).filterNot(_.isEmpty).toList

        val actual = Day3.partOneSolution(data)
        val expected= 198

        actual should be(expected)
      }

    }
  }

}
