import java.io.File
import java.util.*

const val fileName = "race.txt"

fun main() {

    prepareFileForWriting()

    val firstThread = RaceThread("A Thread", fileName)
    val secondThread = RaceThread("B Thread", fileName)

    firstThread.start()
    secondThread.start()
    firstThread.join()
    secondThread.join()

    println("\nThe Race is over. Check race.txt for result.")
}

private fun prepareFileForWriting() {
    val calendar = Calendar.getInstance()
    val file = File(fileName)
    val isNewFileCreating: Boolean = file.createNewFile()
    if (isNewFileCreating) println("${file.path} is created successfully")
    println("Race begin")
    file.writeText("Race begin\n" + calendar.time.toString() + "\n\n")
}