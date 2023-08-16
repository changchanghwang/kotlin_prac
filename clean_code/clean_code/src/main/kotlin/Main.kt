import six.*

fun main(args: Array<String>) {
    val squre = Squre(10.0)
    val rectangle = Rectangle(10.0, 20.0)
    val circle = Circle(10.0)
    val geometry = Geometry()
    println(geometry.area(squre))
    println(geometry.area(rectangle))
    println(geometry.area(circle))
}