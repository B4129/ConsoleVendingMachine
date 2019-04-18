package vendingmachine


import com.example.vendingmachine.announce.Announce
import com.example.vendingmachine.human.Human
import com.example.vendingmachine.machine.Machine
import com.example.vendingmachine.valueobject.money.Bill
import com.example.vendingmachine.valueobject.money.Coin
import com.example.vendingmachine.valueobject.money.Frog
import com.example.vendingmachine.valueobject.money.Wallet

class Main  {
    private val announce = Announce()
    private val wallet = Wallet()
    private val machine = Machine()
    private val human = Human(wallet)
    fun main() {

        announce.say("お金を投入してください")
        //コンソールで数字を入力する
        val selectNumber = 1
        val selectValue = 1000

        val insertItem = when (selectNumber) {
            1 -> Bill(selectValue)
            2 -> Coin(selectValue)
            else -> Frog("アマガエル")
        }
        machine.insertMoney(insertItem)

        announce.say("商品を選んでください")
        //商品選ぶ処理
        //購入の場合
        //ユーザが商品の購入を行う
        machine.onButtonClick(1)

    }
}
