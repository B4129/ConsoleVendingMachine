package vendingmachine

import vendingmachine.machine.Calculator


interface IMachine {
    val calculator: Calculator
    fun onButtonLight()
    fun offButtonLight()
    fun onButtonClick():Boolean
}
