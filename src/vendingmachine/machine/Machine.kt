package vendingmachine.machine

import com.example.vendingmachine.announce.Announce
import vendingmachine.IMachine
import vendingmachine.valueobject.drink.Drink
import vendingmachine.valueobject.Rack

class Machine : IMachine {

    private val rack = Rack()
    // TODO: 2019/04/18  多分良くない
    private val announce = Announce()
    override val calculator = Calculator()
    private var selectDrink: Drink? = null

    override fun onButtonLight() {
        val rightOnDrinks = rack.drinks
        rightOnDrinks.forEach { drink ->
            if (drink.drink.price.value <= calculator.storage.sumValue()) {
                announce.say(" ${drink.drink.name.string}のライトが点灯しました")
            }
        }

    }

    override fun offButtonLight() {
        announce.say("ライトが消灯しました")
    }


    override fun onButtonClick(): Boolean {
        val isNotEnoughMoney = checkInsertMoney()
        if (isNotEnoughMoney) return false
        offButtonLight()

        val isChangedStock = changeStock()
        if (isChangedStock) {
            //お釣りを出す
            calculator.outputMoney(selectDrink!!.price.value)
            return true
        }
        return false
    }

    private fun checkInsertMoney(): Boolean {
        if (calculator.storage.sumValue() < selectDrink!!.price.value) {
            announce.say("金額が不足しています")
            return true
        }
        return false
    }


    private fun changeStock(): Boolean {
        var changedStock = false

        //rack.drinks.first { it.drink == selectDrink }]
        //で値が取れる場合はchangedStockをfalseにしてもいいかも
        rack.drinks.forEach { item -> if (item.drink.name == selectDrink!!.name) changedStock = minusStock(item.drink) }
        return changedStock
    }

    private fun minusStock(drink: Drink): Boolean {
        if (drink.price.value <= 0) {
            announce.say("在庫はないので商品は吐き出しませんでした")
            return false
        }
        drink.price.value - 1
        announce.say("${selectDrink!!.name.string}が購入できました")
        return true
    }

    private fun buttonExist(selectPosition: Int): Boolean {
        rack.drinks.forEach { item ->
            if (item.position.number == selectPosition) {
                selectDrink = item.drink
                return true
            }
        }
        announce.say("そこにボタンはありません")
        return false
    }

    fun selectItem() {
        var isFoundButton: Boolean
        while (true) {
            val insertMoney = calculator.thisTimeStorage.sumValue()
            announce.say("商品を選んでください(投入金額:${insertMoney}円)")


            for (drink in rack.drinks) {
                val drinkName = drink.drink.name.string
                val drinkPrice = drink.drink.price.value
                val drinkNumber = drink.position.number
                announce.say("$drinkName(${drinkPrice}円) 番号:$drinkNumber")
            }
            val selectPositionNumber = readLine()!!.toInt()

            isFoundButton = buttonExist(selectPositionNumber)

            if (isFoundButton) break
        }
            onButtonClick()
    }
}