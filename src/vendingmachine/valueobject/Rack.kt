package vendingmachine.valueobject

import com.example.vendingmachine.valueobject.drink.*
import vendingmachine.valueobject.drink.*
import vendingmachine.valueobject.position.Position

class Rack {
    //TODO ジュースを作る処理を工場クラスに入れたい
    private val makedrink1 = Drink(Status("HOT"), Name("コカコーラ"), Price(160), Amount(5), Size(350), Type("PET"))
    private val makedrink2 = Drink(Status("COOL"), Name("牛乳"), Price(130), Amount(8), Size(500), Type("CAN"))
    private val makedrink3 = Drink(Status("COOL"), Name("リアルゴールド"), Price(130), Amount(2), Size(500), Type("PET"))
    private val makedrink4 = Drink(Status("COOL"), Name("抹茶"), Price(160), Amount(0), Size(350), Type("CAN"))

    //TODO 棚の位置数を生成するなんかをここにかく
    val potision1 = Position(1, 1, 1)
    val potision2 = Position(2, 1, 2)
    val potision3 = Position(3, 2, 1)
    val potision4 = Position(4, 2, 2)

    val drinks = mutableListOf(
        Drinks(potision1, makedrink1),
        Drinks(potision2, makedrink2),
        Drinks(potision3, makedrink3),
        Drinks(potision4, makedrink4)
    )
}
