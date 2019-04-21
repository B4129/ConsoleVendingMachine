package vendingmachine.valueobject.wallet

import com.example.vendingmachine.valueobject.money.IStorage
import vendingmachine.valueobject.money.Bills
import vendingmachine.valueobject.money.Coins

class Storage(
    override val coinl: Coins = Coins(),
    override val billl: Bills = Bills()
    ) : IStorage {
    val coins = coinl
    val bills = billl
    private var sum: Int = 0
    override fun sumValue(): Int {
        sum = 0
        coins.coinList.forEach { coin -> sum += coin.key.toInt() * coin.value }
        bills.billList.forEach { bill -> sum += bill.key.toInt() * bill.value }
        return sum
    }
}