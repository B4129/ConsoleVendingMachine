package vendingmachine.machine

import com.example.vendingmachine.valueobject.money.Frog
import vendingmachine.announce.Announce
import vendingmachine.IMachine
import vendingmachine.flog.FlogStack
import vendingmachine.valueobject.drink.Drink
import vendingmachine.valueobject.Rack

class Machine : IMachine {

    private val rack = Rack()
    private val announce = Announce()
    override val calculator = Calculator()
    private var selectDrink: Drink? = null

    override fun onButtonLight() {
        val rightOnDrinks = rack.drinks
        rightOnDrinks.forEach { drink ->
            val drinkName = drink.drink.name.string
            val drinkPrice = drink.drink.price.value
            val insertMoney = calculator.thisTimeStorage.sumValue()
            if (drinkPrice <= insertMoney) {
                announce.say(" ${drinkName}のライトが点灯しました")
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