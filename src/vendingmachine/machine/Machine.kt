package com.example.vendingmachine.machine

import com.example.vendingmachine.announce.Announce
import com.example.vendingmachine.valueobject.drink.Drink
import vendingmachine.valueobject.Rack
import com.example.vendingmachine.valueobject.money.*
import vendingmachine.valueobject.money.Coin
import vendingmachine.valueobject.wallet.Storage

class Machine : IMachine {

    private val rack = Rack()
    // TODO: 2019/04/18 Sakai_Yuji 多分良くない
    private val announce = Announce()
    override val calculator = Calculator()
    private var selectDrink: Drink? = null

    override fun onButtonLight() {
        val rightOnDrinks = rack.drinks
        rightOnDrinks.forEach { drink ->
            if (drink.third.price.value <= calculator.storage.sumValue()) {
                announce.say(" ${drink.third.name.string}のライトが点灯しました")
            }
        }

    }

    override fun offButtonLight() {
        announce.say("ライトが消灯しました")
    }


    override fun onButtonClick() {
        offButtonLight()
        if (calculator.storage.sumValue() < selectDrink!!.price.value) {
            announce.say("金額が不足しています")
            return
        }
        //商品を出す
        putDrink()
        //在庫処理
        changeStock()
        //お釣りを出す
        calculator.outputMoney(selectDrink!!.price.value)


    }

    private fun putDrink() {
        announce.say("${selectDrink!!.name.string}が購入できました")
    }

    private fun changeStock(): Boolean {
        rack.drinks.forEach { item ->
            if (item.third == selectDrink) {
                minusStock(item.third)
                return@forEach
            }
        }
        return false
    }

    private fun minusStock(drink: Drink) {
        drink.price.value - 1
    }

    fun buttonExist(row: Int, column: Int): Boolean {
        rack.drinks.forEach { item ->
            if (row == item.first && column == item.second) {
                selectDrink = item.third
                return true
            }
        }
        announce.say("そこにボタンはありません")
        return false
    }


}