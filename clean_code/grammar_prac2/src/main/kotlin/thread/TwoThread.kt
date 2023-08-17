package thread

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

class TwoThread {
    fun run(){
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

}