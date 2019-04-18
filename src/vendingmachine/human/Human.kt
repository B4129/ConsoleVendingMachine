package com.example.vendingmachine.human

import com.example.vendingmachine.machine.Machine
import com.example.vendingmachine.valueobject.drink.IDrink
import com.example.vendingmachine.valueobject.money.Bill
import com.example.vendingmachine.valueobject.money.Coin
import com.example.vendingmachine.valueobject.money.IMoney
import com.example.vendingmachine.valueobject.money.Wallet

class Human(
    val wallet: Wallet
    //TODO 所持しているドリンク情報を持たせたい
) {


    fun drinkDrink(drink: IDrink) {
        //TODO ドリンクを飲む処理
    }

    fun buyWallet(wallet: Wallet) {
        //TODO 財布をグレードアップする処理
    }

    fun takeMoney() {
        //TODO お釣りを取る処理
    }

    fun scavengeMoney() {
        //TODO 自販機周辺でお金をあさる処理
    }

}