import java.io.File

class RaceThread(val threadName: String, fileName: String): Thread() {

    @Volatile
    var file = File(fileName)

    var count: Int = 0

    override fun run() {
        println(threadName + " has run." )
        synchronized(this) {
            do {
                count++
                file.appendText("$threadName current count: $count\n")

            } while (count < 100)

            if (file.readLines().get(file.readLines().lastIndex - 1).contains("$threadName current count: 100")) {
                file.appendText("$threadName is wins\n")
            }
            else {
                file.appendText("$threadName is loses\n")
            }
        }
    }
}