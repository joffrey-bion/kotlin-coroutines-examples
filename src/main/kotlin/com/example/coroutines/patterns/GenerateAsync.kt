import kotlin.system.measureTimeMillis
import kotlinx.coroutines.async
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

//sampleStart
fun main() = runBlocking {
    val values = startGenerationAsync()
    println("Printed immediately")
    for (v in values) {
        println("Value $v was produced")
    }
}

fun CoroutineScope.startGenerationAsync(): ReceiveChannel<Int> = produce {
    for (i in 0..5) {
        delay(100)
        send(i * i)
    }
}
//sampleEnd
