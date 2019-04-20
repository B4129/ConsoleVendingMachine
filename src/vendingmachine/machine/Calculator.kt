package com.example.vendingmachine.machine

import com.example.vendingmachine.announce.Announce
import com.example.vendingmachine.valueobject.money.*
import vendingmachine.valueobject.money.Coin
import vendingmachine.valueobject.wallet.Storage

class Calculator {

    val storage = Storage()
    private val thisTimeStorage = Storage()
    // TODO: 2019/04/18 Sakai_Yuji 多分良くない
    private val announce = Announce()

    private fun countMoney(money: Any) {
        if (isCheckMoney(money)) {
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
        registerMoney(money)
    }

    private fun registerMoney(money: Any) {
        if (money is Coin) {
            val yen = money.yen
            storage.coinl.coinList["$yen"] = 1
            thisTimeStorage.coinl.coinList["$yen"] = 1
        }
        if (money is Bill) {
            val yen = money.yen
            storage.bills.billList["$yen"] = 1
            thisTimeStorage.bills.billList["$yen"] = 1
        }
    }

    private fun isCheckMoney(money: Any): Boolean {
        if (money is Coin) {
            registerMoney(money)
            return true
        }
        if (money is Bill) {
            registerMoney(money)
            return true
        }
        if (money is Frog) {
            announce.say("投入口に${money.name}が詰まってしまいました")
            return false
        }
        announce.say("正しい通貨を入れて下さい")
        return false
    }

    fun outputMoney(drinkPrice: Int): Int {
        val outMoney = storage.sumValue() - drinkPrice
        putMoneyFromStorage(drinkPrice)
        destroyThisMoney()
        return outMoney
    }

    private fun destroyThisMoney() {
        thisTimeStorage.coinl.coinList.values.clear()
    }

    private fun putMoneyFromStorage(drinkPrice: Int) {
        val billList = storage.bills.list
        val coinList = storage.coins.list
        putFromStorage(drinkPrice, billList)
        putFromStorage(drinkPrice, coinList)
    }

    private fun putFromStorage(drinkPrice: Int, moneyList: MutableMap<String, Int>) {
        val putSumMoney = thisTimeStorage.sumValue() - drinkPrice

        moneyList.forEach {
            if (moneyList[it.key]!! <= 0) {
                announce.say("${moneyList[it.key]}円は機械の中に存在しません")
                return@forEach
            }
            if (putSumMoney / it.key.toInt() >= 1) moneyList[it.key]!!.minus(1)
        }
    }
}