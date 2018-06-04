
import jdk.nashorn.internal.ir.WhileNode
import org.scalatest.FunSuite

class MainTests extends FunSuite {

 test("First task test"){
  val string = "a0b1c2d3"
  val answer = "aZerobOnecTwodMany"
  assert(Main.numToString(string) === answer)
 }

 test("Second task test#1"){
  val seaweed = new Seaweed("seaweed")

  assert(Main.feedAnimal(new Fish("fish")).food === seaweed.food)
 }

 test("Second task test#2"){
  val corn = new Corn("corn")

  assert(Main.feedAnimal(new Bird("bird")).food === corn.food)
 }

 test("Second task test#3"){
  val wiskas = new Wiskas("wiskas")

  assert(Main.feedAnimal(new Cat("cat")).food === wiskas.food)
 }
}


