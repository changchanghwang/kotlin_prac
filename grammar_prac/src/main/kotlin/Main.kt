fun main(args: Array<String>) {
    println("Hello World!")
    var a = 1
    a = 2 // 재할당
    println(a)

    val b = 2
//    b=3 재할당 불가
    println(b)

    println(a+b) // 4
    println(a-b) // 0
    println(a*b) // 4
    println(a/b) // 1
    println(a%b) // 0

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

    if ( a == b ) {
        println("a == b")
    } else {
        println("a != b")
    }

    // switch랑 비슷함.
    when(a) {
        0 -> println("a == 0")
        1 -> println("a == 1")
        else -> println("a != 0 && a != 1")
    }

    for(i in 1..10) {
        println("${i}번째")
    }
    val list = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8)
    list.filter{ it % 2 == 0}.map{ it * 2 }.forEach{ println(it) }
}