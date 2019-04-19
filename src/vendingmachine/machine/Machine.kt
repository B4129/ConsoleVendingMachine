package com.example.vendingmachine.machine

import com.example.vendingmachine.announce.Announce
import com.example.vendingmachine.valueobject.Rack
import com.example.vendingmachine.valueobject.money.*
import vendingmachine.valueobject.money.Coin
import vendingmachine.valueobject.wallet.Storage

class Machine : IMachine {

    private val rack = Rack()
    private val storage = Storage()
    // TODO: 2019/04/18 Sakai_Yuji 多分良くない
    private val announce = Announce()

    override fun countMoney(money: Any) {
        if (isCheckMoney(money)) {
            announce.say("お金を投入しました")
            announce.say("投入金額:${(money as IMoney).yen}")
            announce.say("合計金額:${storage.sumValue()}")
        }

    }

    override fun insertMoney(money: Any) {
        receiveMoney(money)
    }

    override fun receiveMoney(money: Any) {
        countMoney(money)
        registerMoney(money)
        onButtonLight()
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


    override fun outputMoney(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onButtonLight() {
        val rightOnDrinks = rack.drinks
        rightOnDrinks.forEach { drink ->
            if (drink.third.price.value <= storage.sumValue()) {
                announce.say(" ${drink.third.name.string}のライトが点灯しました")
            }
        }

    }

    override fun offButtonLight() {
        announce.say("ライトが消灯しました")
    }


    override fun onButtonClick(buttonNumber: Int) {
        offButtonLight()
        //自販機が数えた金額が押したボタンの金額以上の場合
        //商品の在庫を減らす
        //商品を出す
        //お釣りを出す
        //自販機が数えた金額が押したボタンの金額以下の場合
        //お金を入れる処理に戻す(return)
        //自販機が取り消し処理を行う
    }


}