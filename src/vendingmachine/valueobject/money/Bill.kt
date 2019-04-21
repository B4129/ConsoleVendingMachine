package com.example.vendingmachine.valueobject.money

class Bill(value: Int):IMoney {

    override val valueArrayList:MutableList<Int> = mutableListOf(10000,5000,1000)
    override val yen:Int = value
    init {
        require(value in valueArrayList){"存在しない紙幣です"}
    }



    override fun toInt(): Int {
        return yen
    }
}