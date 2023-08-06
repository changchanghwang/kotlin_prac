package extendClass

interface WaterBehavior {
    fun swim()
}

open class Bird(name: String) {
    var name: String

    open fun fly() {
        println("${this.name} can fly.")
    }

    init {
        this.name = name
    }
}

class Chicken(name: String) : Bird(name) {
    override fun fly() {
        println("${this.name} can't fly.")
    }
}


class Sparrow(name: String) : Bird(name)

class Duck(name: String) : Bird(name), WaterBehavior {
    override fun swim() {
        println("${this.name} can swim.")
    }
}