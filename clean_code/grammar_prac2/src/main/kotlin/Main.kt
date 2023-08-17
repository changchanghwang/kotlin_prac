import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main(args: Array<String>) {
    thread (start= true){
        for (i in 1..10) {
            println("Thread1 : $i")
            runBlocking {
                launch {
                    delay(1000L)
                }
            }
        }
    }

    thread (start= true){
        for (i in 50..60) {
            println("Thread2 : $i")
            runBlocking {
                launch {
                    delay(1000L)
                }
            }
        }
    }
}
