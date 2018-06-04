

  //Заменить цифры в строке на слова. То есть "0" заменить на "Zero", "1" заменить на
  //"One" и так далее. Цифры больше 3 заменить на "Many"

  /* Реализовать абстрактный класс Animal и три наследника: Fish, Cat, Bird.
 Реализовать абстрактный класс Food и три наследника: Seaweed, Wiskas, Corn.
 Реализовать функцию feedAnimal, в которой животному выдаётся еда, которую он
 ест.
 */
  object Main {
    def main(args: Array[String]): Unit = {
      val string = "To Those 1 23Who Wil0l Never13 Exist"
      println(numToString(string))
    }


    def feedAnimal(obj: Animal): Food = {
      obj match {
        case _: Fish => new Seaweed("seaweed")
        case _: Cat => new Wiskas("wiskas")
        case _: Bird => new Corn("corn")
      }
    }


    def numToString(str: String): String = {

        if (str == "") ""
        else {
          (str.charAt(0) match {
            case '0' => "Zero"
            case '1' => "One"
            case '2' => "Two"
            case x if (Character.isDigit(x)) => "Many"
            case y => y
          }) + numToString(str.substring(1))
        }
      }








  }
