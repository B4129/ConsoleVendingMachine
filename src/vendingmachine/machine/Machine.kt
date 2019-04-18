package com.example.vendingmachine.machine

import com.example.vendingmachine.announce.Announce
import com.example.vendingmachine.valueobject.Rack

class Machine:IMachine {

    val rack= Rack()
    // TODO: 2019/04/18 Sakai_Yuji 多分良くない
    private val announce=Announce()
    override fun countMoney(money: Any) {
        if(isCheckMoney(money)) {
            //お金を数える処理
        }

    }

    override fun insertMoney(money: Any) {
       receiveMoney(money)
    }

    override fun receiveMoney(money: Any) {
        countMoney(money)
        onButtonLight()
    }

    private fun isCheckMoney(money:Any):Boolean{
        if (/*Money型以外の場合*/true) {
            announce.say("正しい通貨を入れて下さい")
            return false
        }
        return true
    }

    override fun outputMoney(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onButtonLight() {
        //Storage内の金額より低い金額の商品のライトを点灯
        announce.say(" のライトが点灯しました")
    }

    override fun offButtonLight() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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