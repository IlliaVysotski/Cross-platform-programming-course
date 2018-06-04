import main.scala.Main
import org.scalatest._

class MainTests extends FlatSpec with Matchers {

  "The result of getListSum" should "equals to the result of getListSumTailrec" in {
    val listOfNumbers = List[Int](11, 4, 5, -7)
    assert(Main.getListSum(listOfNumbers) === Main.getListSumTailrec(listOfNumbers))
  }

  "The result of getIndexIncSequence" should "equals to the result of getIndexIncSequenceTailrec" in {
    val sequenceOfNumbers = List[Int](11, 4, 5, -7)
    assert(Main.getIndexIncSequence(sequenceOfNumbers) === Main.getIndexIncSequenceTailrec(sequenceOfNumbers))
  }

  "Sum elements of the list" should "equals to 13" in {
    val listOfNumbers = List[Int](11, 4, 5, -7)
    Main.getListSum(listOfNumbers) should be (13)
  }

  "An empty list" should "have sum of elements = 0" in {
    val listOfNumbers = List[Int]()
    Main.getListSum(listOfNumbers) should be (0)
  }

  "Sum elements of the list" should "equals to 13 in tailrec" in {
    val listOfNumbers = List[Int](11, 4, 5, -7)
    Main.getListSumTailrec(listOfNumbers) should be (13)
  }

  "An empty list" should "have sum of elements = 0 in tailrec" in {
    val listOfNumbers = List[Int]()
    Main.getListSumTailrec(listOfNumbers) should be (0)
  }

  "Index of the beginning of the maximum interval" should "equals to 5" in {
    val sequenceOfNumbers = List[Int](12, 14, 17, 14, 22, 18, 22, 100, 12, 15)
    Main.getIndexIncSequence(sequenceOfNumbers) should be (5)
  }

  "Index of the beginning of the maximum interval" should "equals to -1 without inc sequence" in {
    val sequenceOfNumbers = List[Int](10, 6, 2)
    Main.getIndexIncSequence(sequenceOfNumbers) should be (-1)
  }

  "Index of the beginning of the maximum interval" should "equals to -1 without inc sequence in tailrec" in {
    val sequenceOfNumbers = List[Int](10, 6, 2)
    Main.getIndexIncSequenceTailrec(sequenceOfNumbers) should be (0)
  }
}
