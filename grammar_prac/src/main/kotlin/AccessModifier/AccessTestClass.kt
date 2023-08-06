package AccessModifier

open class AccessTestClass {
    // 기본적으로 public
    fun test() {
        println("public")
    }

    // 같은 클래스 내에서만 접근 가능
    private fun privateTest() {
        println("private")
    }

    // 같은 모듈 (패키지 포함) 내에서만 접근 가능
    internal fun internalTest() {
        println("internal")
    }

    // 하위 클래스에서만 접근 가능
    protected fun protectedTest() {
        println("protected")
    }
}