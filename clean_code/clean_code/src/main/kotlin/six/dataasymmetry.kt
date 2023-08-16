package six

//// 절차적인 도형 클래스
//class Squre (var side:Double)
//class Rectangle (var height:Double, var width:Double)
//class Circle (var radius:Double)
//
//class Geometry{
//    private val pi:Double = 3.141592653589793
//
//    fun area(shape:Any): Double {
//        if(shape is Squre){
//            return shape.side * shape.side
//        }
//        if(shape is Rectangle){
//            return shape.height * shape.width
//        }
//        if(shape is Circle){
//            return pi * shape.radius * shape.radius
//        }
//        throw IllegalArgumentException("Unknown shape")
//    }
//}

// 객체 지향적인 도형 클래스
interface Shape{
    fun area():Double
}

class Squre (var side:Double):Shape{
    override fun area(): Double = side * side
}
class Rectangle (var height:Double, var width:Double):Shape{
    override fun area(): Double = height * width
}
class Circle (var radius:Double):Shape{
    private val pi:Double = 3.141592653589793
    override fun area(): Double = pi * radius * radius
}

