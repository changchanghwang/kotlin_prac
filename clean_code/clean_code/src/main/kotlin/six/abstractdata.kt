package six

class BasicPoint(var x:Double, var y:Double)

class AbstractPoint(private var x:Double, private var y:Double){
    fun getX():Double = x
    fun getY():Double = y
    fun setCartesian(x:Double, y:Double){
        this.x = x
        this.y = y
    }
    fun setPolar(rho:Double, theta:Double){
        x = rho * Math.cos(theta)
        y = rho * Math.sin(theta)
    }
}