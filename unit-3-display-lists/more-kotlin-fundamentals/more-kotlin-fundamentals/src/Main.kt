import Quiz.StudentProgress.printProgressBar
import Quiz.StudentProgress.progressText

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val question1 = Question<String>("Name of the city", "Colombo", Difficulty.Easy)
    val question2 = Question<Boolean>("Name of the city is Colombo", false, Difficulty.Normal)
    val question3 = Question<Int>("Population of the city", 10, Difficulty.Hard)
//    println(question1)
//    println(question2)
//    println(question3)
//
//    println("${StudentProgress.answered} of ${StudentProgress.total} answered.")
//
//    println("${Quiz.answered} of ${Quiz.total} answered.")
//
//    println(Quiz.progressText)
//

    println(Quiz2().printQuiz())

    // apply
    Quiz2().apply {
        printQuiz()
    }



    Quiz.printProgressBar()
    Quiz2().printProgressBar()
}




// Interfaces
interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

class Quiz2: ProgressPrintable {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.Easy)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.Normal)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.Hard)

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }


    override val progressText: String
        get() = "${answered} of ${total} answered"

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(Quiz.progressText)
    }

    // Scope Functions
    //Eliminate repetitive object references with scope functions
    fun printQuiz() {
        question1.let {
            println(it.question)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.question)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.question)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }
}


// Singleton & Extension
class Quiz {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.Easy)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.Normal)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.Hard)

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3

        val Quiz.StudentProgress.progressText: String
            get() = "${answered} of ${total} answered"

        fun Quiz.StudentProgress.printProgressBar() {
            repeat(Quiz.answered) { print("▓") }
            repeat(Quiz.total - Quiz.answered) { print("▒") }
            println()
            println(Quiz.progressText)
        }
    }
}



// Generics & Enum & Data Classes
enum class Difficulty {Easy, Normal, Hard}

data class Question<T> (
    val question: String,
    val answer: T,
    val difficulty: Difficulty
)

class FillInTheBlankQuestion(
    val questionText: String,
    val answer: String,
    val difficulty: String
)

class TrueOrFalseQuestion(
    val questionText: String,
    val answer: Boolean,
    val difficulty: String
)

class NumericQuestion(
    val questionText: String,
    val answer: Int,
    val difficulty: String
)

object StudentProgress {
    var total: Int = 10
    var answered: Int = 3
}