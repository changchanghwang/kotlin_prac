import AccessModifier.AccessTestClass
import extendClass.Calculator
import extendClass.Chicken
import extendClass.Duck
import extendClass.Sparrow

fun main(args: Array<String>) {
//  grammarConsole()
    val c = Character2("arthur", 15)
    c.method()

    val chicken = Chicken("chicken")
    val sparrow = Sparrow("sparrow")
    val duck = Duck("duck")

    chicken.fly()
    sparrow.fly()
    duck.swim()

    val calculator = Calculator()
    println(calculator.add(1, 2))
    println(calculator.add(1.2, 2.3))

    val access = AccessTestClass()

    access.test()
    access.internalTest()
}

class Character(name: String, age: Int, height: Double) { // 한가지 생성자로만 사용할때
    var name: String = ""
    var age: Int = 0
    var height: Double = 0.0

    init {
        this.name = name
        this.age = age
        this.height = height
    }
}

class Character2 {
    var name: String = ""
    var age: Int = 0
    var height: Double = 0.0

    constructor(name: String, age: Int) { // 여러개의 생성자를 사용할때
        this.name = name
        this.age = age
    }

    constructor(name: String) { // 여러개의 생성자를 사용할때
        this.name = name
    }

    constructor(name: String, age: Int, height: Double) { // 여러개의 생성자를 사용할때
        this.name = name
    }

    fun method() {
        println("${name} ${age}")
    }

}

fun grammarConsole(): Unit { //Unit은 void와 같은 것 같음.
    println("Hello World!")
    var a = 1
    a = 2 // 재할당
    println(a)

    val b = 2
//    b=3 재할당 불가
    println(b)

    println(a + b) // 4
    println(a - b) // 0
    println(a * b) // 4
    println(a / b) // 1
    println(a % b) // 0

    a += 1
    println(a) // 3
    a -= 1
    println(a) // 2
    a *= 2
    println(a) // 4
    a /= 2
    println(a) // 2
    a %= 2
    println(a) // 0

    println(a++) // 0
    println(a) // 1
    println(++a) // 2

    println(a == b) // true
    println(a != b) // false
    println(a > b) // false
    println(a < b) // false
    println(a >= b) // true
    println(a <= b) // true

    if (a == b) {
        println("a == b")
    } else {
        println("a != b")
    }

    // switch랑 비슷함.
    when (a) {
        0 -> println("a == 0")
        1 -> println("a == 1")
        else -> println("a != 0 && a != 1")
    }

    for (i in 1..10) {
        println("${i}번째")
    }
    val list = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8)
    list.filter { it % 2 == 0 }.map { it * 2 }.forEach { println(it) }
}