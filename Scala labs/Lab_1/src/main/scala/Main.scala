package main.scala
import scala.annotation.tailrec

object Main {
  def main(args: Array[String]): Unit = {
    val intList = List[Int](3, 8, 1, 66, 277, 12)
    println(getListSumTailrec(intList))
    println(getListSum(intList))

    val sequenceOfNumbers = List[Int](3, 8, 1, 66, 277, 12)
    println(getIndexIncSequenceTailrec(sequenceOfNumbers))
    println(getIndexIncSequence(sequenceOfNumbers))
  }

  // first task with recursion
  def getListSumTailrec(ints: List[Int]): Int = {
    @tailrec
    def helper(ints: List[Int], accumulator: Int): Int = {
      ints match {
        case x :: tail => helper(tail, accumulator + x)
        case Nil => accumulator
      }
    }
    helper(ints, 0)
  }


  // first task without recursion
  def getListSum(ints: List[Int]): Int = {
    val sizeOfList = ints.length

    def accumulator(ints: List[Int], sizeOfList: Int): Int = {
      if (sizeOfList != 0)
        ints(sizeOfList - 1) + accumulator(ints, sizeOfList - 1)
      else
        0
    }
    accumulator(ints, sizeOfList)
  }

  // second task with recursion
  def getIndexIncSequenceTailrec(sequenceOfNumbers: List[Int]): Int = {
    val sizeOfList = sequenceOfNumbers.length

    def getDifference(firstParam: Int, secondParam: Int): Int = {
      secondParam - firstParam
    }

    @tailrec
    def findMaxSequence(sequenceOfNumbers: List[Int], sizeOfList: Int, minIndex: Int,
                        maxDifference: Int, currentIndex: Int, currentMinIndex: Int): Int = {
      if (currentIndex != sizeOfList) {
        if (sequenceOfNumbers(currentIndex) < sequenceOfNumbers(currentIndex - 1)) {
          val difference = getDifference(sequenceOfNumbers(currentMinIndex), sequenceOfNumbers(currentIndex - 1))

          if (difference > maxDifference)
            findMaxSequence(sequenceOfNumbers, sizeOfList, currentMinIndex, difference, currentIndex + 1, currentIndex)
          else
            findMaxSequence(sequenceOfNumbers, sizeOfList, minIndex, maxDifference, currentIndex + 1, currentIndex)
        } else
          findMaxSequence(sequenceOfNumbers, sizeOfList, minIndex, maxDifference, currentIndex + 1, currentMinIndex)
      } else if (getDifference(sequenceOfNumbers(currentMinIndex), sequenceOfNumbers(currentIndex - 1)) > maxDifference)
        currentMinIndex
      else if (getDifference(sequenceOfNumbers(currentMinIndex), sequenceOfNumbers(currentIndex - 1)) > maxDifference)
        currentMinIndex
      else
        minIndex
    }
    findMaxSequence(sequenceOfNumbers, sizeOfList, 0, 0, 1, 0)
  }

  // second task without recursion
  def getIndexIncSequence(sequenceOfNumbers: List[Int]): Int = {
    val sizeOfList = sequenceOfNumbers.length

    def getDifference(firstParam: Int, secondParam: Int): Int = {
      secondParam - firstParam
    }

    def findMaxSequence(sequenceOfNumbers: List[Int], sizeOfList: Int, minIndex: Int,
                        maxDifference: Int, currentIndex: Int, currentMinIndex: Int, acc: Int): Int = {
      if (currentIndex == sizeOfList) {
        -acc
      } else if (sequenceOfNumbers(currentIndex) < sequenceOfNumbers(currentIndex - 1)) {
        if (maxDifference < getDifference(sequenceOfNumbers(currentMinIndex), sequenceOfNumbers(currentIndex - 1))) {
          1 + findMaxSequence(sequenceOfNumbers, sizeOfList, currentMinIndex,
            getDifference(sequenceOfNumbers(currentMinIndex), sequenceOfNumbers(currentIndex - 1)), currentIndex + 1,
            currentIndex, currentIndex - currentMinIndex)
        } else {
          1 + findMaxSequence(sequenceOfNumbers, sizeOfList, currentMinIndex,
            maxDifference, currentIndex + 1,
            currentIndex, acc + 1)
        }
      } else if (currentIndex == sizeOfList - 1) {
        if (maxDifference < getDifference(sequenceOfNumbers(currentMinIndex), sequenceOfNumbers(currentIndex))) {
          1 + findMaxSequence(sequenceOfNumbers, sizeOfList, currentMinIndex,
            getDifference(sequenceOfNumbers(currentMinIndex), sequenceOfNumbers(currentIndex)), currentIndex + 1,
            currentIndex, currentIndex - currentMinIndex)
        } else {
          1 + findMaxSequence(sequenceOfNumbers, sizeOfList, currentMinIndex,
            maxDifference, currentIndex + 1,
            currentMinIndex, acc + 1)
        }
      } else {
        1 + findMaxSequence(sequenceOfNumbers, sizeOfList, currentMinIndex,
          maxDifference, currentIndex + 1,
          currentMinIndex, acc + 1)
      }
    }
    findMaxSequence(sequenceOfNumbers, sizeOfList, 0, 0, 1, 0, 1)
  }
}



import main.scala.Main
import org.scalatest._

class MainTests extends FlatSpec with Matchers {


  it should "one word" in {
    val string = "a0b1c2d3"
    val answer = "aZerobOnecTwodMany"
    val result = Main.numToString(string)
    assert(result === answer)
  }

  it should "string" in {
    val string = "a 1 b 7"
    val answer = "a One b Many"
    assert(Main.numToString(string) === "a One b Many")
  }

  //it should "index of the beginning interval tailrec" in {
  //val sequenceOfNumbers = List[Double](10.0, 6.4, 2.3)
  //Main.getIndexIncSequenceTailrec(sequenceOfNumbers) should be (0)
  //}
}