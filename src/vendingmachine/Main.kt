package vendingmachine


import com.example.vendingmachine.announce.Announce
import com.example.vendingmachine.human.Human
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
    while (!isEnd) {
        announce.say("お金を投入してください")
        announce.say("(お金の種類 1:硬貨 2:紙幣 3:その他 4:入れるのをやめる) :")
        val selectNumber = readLine()!!.toInt()
        var selectValue = 0
        if (selectNumber == 1 || selectNumber == 2) {
            announce.say("金額 : ")
            selectValue = readLine()!!.toInt()
        }

        when (selectNumber) {
            1 -> machine.calculator.insertMoney(Coin(selectValue))
            2 -> machine.calculator.insertMoney(Bill(selectValue))
            3 -> machine.calculator.insertMoney(Frog())
            else -> isEnd = !isEnd
        }
    }
    machine.selectItem()




}
