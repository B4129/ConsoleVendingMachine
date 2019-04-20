package vendingmachine.machine

import com.example.vendingmachine.announce.Announce
import com.example.vendingmachine.machine.Calculator
import com.example.vendingmachine.machine.IMachine
import com.example.vendingmachine.valueobject.drink.Drink
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
            if (item.drink == selectDrink) {
                minusStock(item.drink)
                return@forEach
            }
        }
        return false
    }

    private fun minusStock(drink: Drink) {
        drink.price.value - 1
    }

    fun buttonExist(selectPosition:Int): Boolean {
        rack.drinks.forEach { item ->
            if (item.position.number == selectPosition) {
                selectDrink = item.drink
                return true
            }
        }
        announce.say("そこにボタンはありません")
        return false
    }

    fun selectItem(){
        var isFoundButton:Boolean
        while (true) {
            announce.say("商品を選んでください")

            for (drink in rack.drinks) {
                announce.say("${drink.drink.name.string} 番号:${drink.position.number}")
            }
            val selectPositionNumber = readLine()!!.toInt()

            isFoundButton =  buttonExist(selectPositionNumber)

            if (!isFoundButton) return
            onButtonClick()
        }
    }
}