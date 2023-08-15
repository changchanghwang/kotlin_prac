fun main(args: Array<String>) {
    println("4".toInt()==Integer.parseInt("4"))
    val birds = mutableListOf<Bird>()
    val sparrow = Sparrow("sparrow") as Bird
    sparrow.fly()

    birds.add(sparrow)
}

open class Bird(name:String){
    fun fly(){
        println("I can fly")
    }
}

class Sparrow(name:String):Bird(name){
}