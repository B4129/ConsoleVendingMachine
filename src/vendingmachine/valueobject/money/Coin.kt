package vendingmachine.valueobject.money

import com.example.vendingmachine.valueobject.money.IMoney

class Coin(value: Int = 10) : IMoney {

    override val yen:Int = value
    override val valueArrayList: MutableList<Int> = mutableListOf(10, 50, 100, 500)

    init {
        require(value in valueArrayList){"存在しない硬貨です"}
    }


    override fun toInt(): Int {
        return yen
    }

}

