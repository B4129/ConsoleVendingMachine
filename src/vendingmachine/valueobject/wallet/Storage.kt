package vendingmachine.valueobject.wallet

import com.example.vendingmachine.valueobject.money.Bill
import com.example.vendingmachine.valueobject.money.IStorage
import vendingmachine.valueobject.money.Coin


class Storage(
    override val coins: MutableMap<Coin, Int> = mutableMapOf(
        Coin(10) to 0,
        Coin(50) to 0,
        Coin(100) to 0,
        Coin(500) to 0
    ),
    override val bills:  MutableMap<Bill, Int> = mutableMapOf(
        Bill(1000) to 0,
        Bill(5000) to 0,
        Bill(10000) to 0
    )

) : IStorage {
    override fun sumValue(): Int {
        var sum = 0
        coins.forEach { coin -> sum += coin.key.yen * coin.value }
        bills.forEach { bill -> sum += bill.key.yen * bill.value }
        return sum
    }
}