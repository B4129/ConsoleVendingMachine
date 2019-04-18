package vendingmachine


import com.example.vendingmachine.announce.Announce
import com.example.vendingmachine.human.Human
import com.example.vendingmachine.machine.Machine
import com.example.vendingmachine.valueobject.money.Bill
import vendingmachine.valueobject.money.Coin
import com.example.vendingmachine.valueobject.money.Frog
import com.example.vendingmachine.valueobject.money.Wallet

fun main() {
    val announce = Announce()
    val wallet = Wallet()
    val machine = Machine()
    val human = Human(wallet)
    announce.say("お金を投入してください")
    announce.say("(お金の種類 1:硬貨 2:紙幣) :")
    val selectNumber = readLine()!!.toInt()
    var selectValue = 0
    if (selectNumber == 1 || selectNumber == 2) {
        announce.say("金額 : ")
        selectValue = readLine()!!.toInt()
    }
    machine.insertMoney(
        when (selectNumber) {
            1 -> Coin(selectValue)
            2 -> Bill(selectValue)
            else -> Frog()
        }
    )

    announce.say("商品を選んでください")
    val selectItem = readLine()!!.toInt()
    announce.say("商品番号 :$selectItem")
    //商品選ぶ処理
    //購入の場合
    //ユーザが商品の購入を行う
    machine.onButtonClick(1)

}
