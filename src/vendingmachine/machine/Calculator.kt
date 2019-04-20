package com.example.vendingmachine.machine

import com.example.vendingmachine.announce.Announce
import com.example.vendingmachine.valueobject.money.*
import vendingmachine.valueobject.money.Coin
import vendingmachine.valueobject.wallet.Storage

class Calculator {

    val storage = Storage()
    val thisTimeStorage = Storage()
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
        if (money is Coin) {
            //追加しないといけない
            storage.coinl.coinList["${money.yen}"] = 1
            thisTimeStorage.coinl.coinList["${money.yen}"] = 1
        }
        if (money is Bill) {
            storage.bills.billList["${money.yen}"] = 1
            thisTimeStorage.bills.billList["${money.yen}"] = 1
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


        putBillFromStorage(drinkPrice)
        putCoinFromStorage(drinkPrice)
        destroyThisMoney()
        return outMoney
    }

    private fun destroyThisMoney() {
        thisTimeStorage.coinl.coinList.values.clear()
    }


    private fun putBillFromStorage(drinkPrice: Int) {
        val billList = storage.bills.list
        val putSumMoney = thisTimeStorage.sumValue() - drinkPrice

        billList.forEach { bill ->
            if(billList[bill.key]!! <= 0){
                announce.say("${billList[bill.key]}は機械の中に存在しないのでお釣りは没収します")
                return@forEach
            }
            if (putSumMoney / bill.key.toInt() >= 1){

                billList[bill.key]!!.minus(  1)
                print(1)
            }
        }
    }

    private fun putCoinFromStorage(drinkPrice: Int) {
        val coinList = storage.coinl.coinList
        val keys = coinList.keys
        for (number in coinList.size downTo 1) {
            if (number == 0) return
//            if (keys.first { it == coinList[number - 1] } / storage.sumValue() >= 1)
//                coinList[number - 1]!! - 1
        }
    }


}