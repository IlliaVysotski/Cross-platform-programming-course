import org.scalatest.{FlatSpec, Matchers}
import scala.collection.mutable

class MainTests extends FlatSpec with Matchers{

  "changeNeighborsInList in the list" should "returns {1,0,3,2}" in {
    Main.changeNeighborsInList(List(0,1,2,3)) should be(mutable.MutableList(1,0,3,2))
  }

  it should " returns {}" in{
    Main.changeNeighborsInList(List()) should be(mutable.MutableList())
  }

  it should "returns {1}" in{
    Main.changeNeighborsInList(List(1)) should be(mutable.MutableList(1))
  }

  "contains" should "returns false" in{
    Main.contains(List(0,1,2,2), 5) should be(false)
  }

  "contains" should "returns true" in{
    Main.contains(List(0,1,2,2), 1) should be(true)
  }


  "Deleting same keys" should "returns Map(4->5, 3->4, 2->4, 1->1)" in {
    Main.deleteSameKeys(Map(1->1,2->4,3->4,4->5)) should be(Map(4->5, 3->4, 2->4, 1->1))
  }

  it should "returns  Map()" in {
    Main.deleteSameKeys(Map()) should be(Map())
  }

  it should "returns Map(4 -> 9, 3 -> 16, 1 -> 1)" in {
    Main.deleteSameKeys(Map(1->1,2->1,3->16,4->9)) should be(Map(4 -> 9, 3 -> 16, 1 -> 1))
  }
}

