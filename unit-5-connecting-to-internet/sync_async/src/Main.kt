//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import kotlinx.coroutines.*
import kotlinx.coroutines.NonCancellable.cancel
import kotlin.system.*

fun main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            println(getWeatherReport())
            println("Have a good day at last!")
        }
        println("Finished")
    }
    println("Execution time: ${time / 1000.0} seconds")
}

suspend fun getWeatherReport() = coroutineScope {
    val forecast = async { getForecast() }
    val temperature = async {
        try {
            getTemperature()
        } catch (e: AssertionError) {
            println("Caught exception $e")
            "{ No temperature found }"
        }
    }
    forecast.cancel()
    "${forecast.await()} ${temperature.await()}"
}

suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

suspend fun getTemperature(): String {
    delay(1000)
    throw AssertionError("Temperature is invalid")
    return "30\u00b0C"
}