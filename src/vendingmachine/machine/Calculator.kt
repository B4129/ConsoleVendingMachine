package vendingmachine.machine

import vendingmachine.announce.Announce
import com.example.vendingmachine.valueobject.money.*
import vendingmachine.flog.FlogStack
import vendingmachine.valueobject.money.Coin
import vendingmachine.valueobject.wallet.Storage

class Calculator {

    val storage = Storage()
    val thisTimeStorage = Storage()
    val flogStack = FlogStack()
    // TODO: 2019/04/18 Sakai_Yuji 多分良くない
    private val announce = Announce()

    private fun countMoney(money: Any) {
        if (isCheckMoney(money)) {
            register(money)
            announce.say("お金を投入しました")
            announce.say("投入金額:${(money as IMoney).yen}")
            announce.say("合計金額:${thisTimeStorage.sumValue()}")
        }
    }

    fun insertMoney(money: Any) {
        receiveMoney(money)
    }

    private fun receiveMoney(money: Any) {
        countMoney(money)

    }

    private fun register(money: Any) {
        when (money) {
            is Coin -> {
                val yen = money.yen
                val insertMoney = thisTimeStorage.coins.list["$yen"]!!
                storage.coins.list["$yen"] = insertMoney + 1
                thisTimeStorage.coins.list["$yen"] = insertMoney + 1
            }
            is Bill -> {
                val yen = money.yen
                val insertMoney = thisTimeStorage.bills.list["$yen"]
                storage.bills.list["$yen"] = insertMoney!! + 1
                thisTimeStorage.bills.list["$yen"] = insertMoney + 1
            }
        }
    }

    private fun isCheckMoney(money: Any): Boolean {
        if (money is Coin) {
            return true
        }
        if (money is Bill) {
            return true
        }
        if (money is Frog) {
            announce.say("投入口に${money.name}が詰まってしまいました")
            flogStack.isStackFlag = true
            return false
        }
        announce.say("正しい通貨を入れて下さい")
        return false
    }

    fun outputMoney(drinkPrice: Int) {
        putMoneyFromStorage(drinkPrice)
        destroyThisMoney()
    }

    private fun destroyThisMoney() {
        thisTimeStorage.coins.list.values.clear()
    }

    private fun putMoneyFromStorage(drinkPrice: Int) {
        val billList = storage.bills.list
        val coinList = storage.coins.list
        var realPutMoney = 0
        realPutMoney += putFromStorage(drinkPrice, billList)
        realPutMoney += putFromStorage(drinkPrice, coinList)
        val putSumMoney = thisTimeStorage.sumValue() - drinkPrice
        if (realPutMoney < putSumMoney) announce.say("合計${putSumMoney}円吐き出す予定でしたが在庫が無かったため")
        announce.say("合計${realPutMoney}円を吐き出しました")
    }

    private fun putFromStorage(drinkPrice: Int, moneyList: MutableMap<String, Int>): Int {
        val putSumMoney = thisTimeStorage.sumValue() - drinkPrice
        var realPutMoney = 0
        moneyList.forEach {
            val yen = it.key
            //機械内にお釣りとなる紙幣/硬貨が存在する場合吐き出す
            while (realPutMoney < putSumMoney) {
                if (moneyList[yen]!! <= 0) {
                    announce.say("${yen}円は機械の中に存在しません")
                    break
                }
                val putMoney = moneyList[yen]
                if ((putSumMoney / yen.toInt()) < 1) break
                moneyList[yen] = putMoney!! - 1
                realPutMoney += yen.toInt()
                announce.say("${yen}円を吐き出しました")
                if ((putSumMoney / yen.toInt()) == 1) break
            }
        }
        return realPutMoney
    }


}