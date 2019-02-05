import kotlin.system.measureTimeMillis
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val elapsed = measureTimeMillis {
    	val result = parallelDecomp()
    	println("Returns $result")
    }
    println("Elapsed time: $elapsed")
}

//sampleStart
suspend fun parallelDecomp(): Int = coroutineScope {
    val v1 = async { delayAndReturn(6) }
    val v2 = async { delayAndReturn(2) }
    v1.await() + v2.await()
}
//sampleEnd

suspend fun delayAndReturn(n: Int): Int {
    delay(200)
    return n
}
