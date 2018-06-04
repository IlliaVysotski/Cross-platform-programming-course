import scala.annotation.tailrec
import scala.collection.mutable.MutableList


object Main {
  def main(args: Array[String]): Unit = {
    val listOfNumbers = List[Int](3, 8, 1, 66, 277, 12)
    val map = Map(1->1,2->1,3->16,4->9)
    val x = 1

    println(changeNeighborsInList(listOfNumbers))
    if(contains(listOfNumbers, x)) println("The list contains an element = " + x)
    else println("The list doesn't contain an element = " + x)
    //println(deleteSameKeys(map))
  }


  def changeNeighborsInList(firstList : List[Int]) : MutableList[Int] =
  {
    @tailrec
    def tailChange(firstList:List[Int], resultList : MutableList[Int], index:Int) : MutableList[Int] =
    {
      if(index < firstList.size)
      {
        resultList += firstList(index)
        tailChange(firstList,resultList += firstList(index-1),index+2)
      }
      else
      {
        if(firstList.size == resultList.size)
        {
          resultList
        }
        else
        {
          resultList += firstList.last
        }
      }
    }
    tailChange(firstList,MutableList(),1)
  }

  def contains(list: List[Int], x: Int): Boolean = {
    val check = list.fold(0)((m: Int, n: Int) => {
      if(n == x) m + 0
      else m + n }
    )
    if(list.sum != check) true
    else false
  }


  def deleteSameKeys(map : Map[Int,Int]) : Map[Int,Int] =
    map.foldRight(Map[Int,Int]())((x, acc) => acc+((x._2,x._1))).foldLeft(Map[Int,Int]())((acc, x) => acc+((x._2,x._1)))

}
