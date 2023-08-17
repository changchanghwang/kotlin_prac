package coroutines

import kotlinx.coroutines.*

class CoruotinesExample {

    fun runGlobal(){
        println("메인쓰레드시작")
        val job = GlobalScope.launch {
            delay(1000L)
            println("메인 스코프 코루틴")// 코루틴은 비동기로 실행되기때문에 메인쓰레드가 끝나서 실행이 안될 수 있다.
        }

        runBlocking {
            job.join() // 코루틴이 끝날때까지 기다린다.
        }

        println("메인쓰레드종료")
    }

    fun runDefaultScope(){
        println("메인쓰레드시작")
        val job = CoroutineScope(Dispatchers.Default).launch{
            delay(1000L)
            println("디폴트 스코프 코루틴")// 코루틴은 비동기로 실행되기때문에 메인쓰레드가 끝나서 실행이 안될 수 있다.
        }
        runBlocking {
            job.join() // 코루틴이 끝날때까지 기다린다.
        }
        println("메인쓰레드종료")

        job.cancel() // 임시 사용이기때문에 마지막에 코루틴을 취소한다.
    }

    fun runCoroutines(){
        println("메인 쓰레드 시작")
        val job = CoroutineScope(Dispatchers.Default).launch {
            val fileDownloadCoroutine = async(Dispatchers.IO) {
                delay(5000L)
                "파일 다운로드 완료"
            }
            val databaseConnectionCoroutine = async(Dispatchers.IO) {
                delay(3000L)
                "데이터베이스 연결 완료"
            }
            println(fileDownloadCoroutine.await())
            println(databaseConnectionCoroutine.await())
        }
        runBlocking {
            job.join()
        }
        println("메인 쓰레드 종료")
        job.cancel()
    }
}
