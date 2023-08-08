package lazyinitialization

class Student {
    lateinit var name: String // lateinit은 var만 가능하다.

    val age: Int by lazy {
        println("age init")
        10
    }

    var address: String? =
        null // !! non null assertion, ? optional , ?.optional chaining, ?: Elvis operator -> like ?? in typescript

    fun getName() {
        if (this::name.isInitialized) {
            println(this.name)
            println(this.age)
        } else {
            println("not initialized")
        }
    }

    fun getAddress() {
        println(this.address?.length)
        println(this.address?.length ?: 0)
    }
}