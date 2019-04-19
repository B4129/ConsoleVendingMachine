package com.example.vendingmachine.machine

import com.example.vendingmachine.announce.Announce
import vendingmachine.valueobject.Rack
import com.example.vendingmachine.valueobject.money.*
import vendingmachine.valueobject.money.Coin
import vendingmachine.valueobject.wallet.Storage

class Calculator {

    val storage = Storage()
    // TODO: 2019/04/18 Sakai_Yuji 多分良くない
    private val announce = Announce()

    private fun countMoney(money: Any) {
        if (isCheckMoney(money)) {
            announce.say("お金を投入しました")
            announce.say("投入金額:${(money as IMoney).yen}")
            announce.say("合計金額:${storage.sumValue()}")
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
        if (money is Coin) storage.coins.coinList[money.yen] = 1
        if (money is Bill) storage.bills.billList[money.yen] = 1
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


        putBillFromStrage(drinkPrice)
        putCoinFromStrage(drinkPrice)

        return outMoney
    }


    private fun putBillFromStrage(drinkPrice: Int) {
        val coinList = storage.coins.coinList
        val keys = coinList.keys
        for (number in storage.bills.billList.size downTo 1) {
            if (number == 0) return
            if (keys[number - 1].toInt / drinkPrice >= 1)
                storage.bills.billList[number - 1]!! - 1
        }
    }

    private fun putCoinFromStrage(drinkPrice: Int) {
        val coinList = storage.coins.coinList
        for (number in coinList.size downTo 1) {
            if (number == 0) return
            if (coinList[number - 1]!! / drinkPrice >= 1)
                coinList[number - 1]!! - 1
        }
    }
}