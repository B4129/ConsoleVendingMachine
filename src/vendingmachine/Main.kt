package vendingmachine


import vendingmachine.announce.Announce
import vendingmachine.human.Human
import vendingmachine.machine.Machine
import com.example.vendingmachine.valueobject.money.Bill
import vendingmachine.valueobject.money.Coin
import com.example.vendingmachine.valueobject.money.Frog
import com.example.vendingmachine.valueobject.money.Wallet

fun main() {
    val announce = Announce()
    val wallet = Wallet()
    val machine = Machine()
    val human = Human(wallet)
    var isEnd = false
    loop@ while (!isEnd) {

        announce.say("お金を投入してください")
        announce.say("(お金の種類 1:硬貨 2:紙幣 3:その他 4:入れるのをやめる) :")
        val selectNumber = readLine()!!.toInt()
        var selectValue = 0

        if (selectNumber == 1 || selectNumber == 2) {
            announce.say("金額 : ")
            selectValue = readLine()!!.toInt()
        }

        if ((selectNumber == 1 || selectNumber == 2 || selectNumber == 3) && machine.calculator.flogStack.isStackFlag) {
            announce.say("カエルが投入口に詰まっていて入れることができません")
            continue@loop
        }
        when (selectNumber) {
            1 -> machine.calculator.insertMoney(Coin(selectValue))
            2 -> machine.calculator.insertMoney(Bill(selectValue))
            3 -> machine.calculator.insertMoney(Frog())
            else -> {
                isEnd = !isEnd
            }
        }
    }
    machine.selectItem()
    isEnd = true
    /* announce.say("続けて購入しますか？")
     announce.say("はい:1 いいえ:2")
     val selectAnswer = readLine()!!.toInt()
     if (selectAnswer != 1) {
         break
     }*/

    announce.say("ご利用ありがとうございました")
}
