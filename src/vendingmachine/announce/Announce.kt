package vendingmachine.announce

import vendingmachine.machine.IAnnounce


class Announce: IAnnounce {
    override fun say(message:String){
        println(message)
    }
}