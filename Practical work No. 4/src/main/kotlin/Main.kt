// Проверка правильности оператора if, у которого условие имеет вид: <переменная><знак><строка> , при этом знак – это
// знак больше, меньше, больше или равно, меньше или равно, равно, не равно. Как в части then, так и в else (может быть
// опущен) указывается оператор присваивания, правая часть которого – выражение, содержащее переменные, целые и
// вещественные числа и знаки операций +,-,*,/

const val ifPattern = """[I|i][F|f]"""
const val thenPattern = """[T|t][H|h]][E|e][N|n]"""
const val elsePattern = """[E|e][L|l][S|s][E|e]"""
const val variablePattern = """[a-zA-Z_][a-zA-Z0-9_]*"""
const val stringPattern = """(''|[^'])*"""
const val conditionOperationsPattern = """(>|<|>=|<=|=|!=)"""
const val operationsPattern = """(\+|\-|\*|\/)"""
const val conditionPattern = """$variablePattern *$conditionOperationsPattern *'$stringPattern'"""
const val operatorPattern = """($variablePattern|-?\d+|-?\d+\.\d+(e[-\+]?\d+)?)"""
const val expressionPattern = """$variablePattern *:= *$operatorPattern( +$operationsPattern +$operatorPattern)*"""
const val ifCondition = """$ifPattern *\($conditionPattern\) *$thenPattern +$expressionPattern( +$elsePattern *$expressionPattern)?"""

fun main(args: Array<String>) {
    val str: String? = readlnOrNull()

    if (str != null) {
        println(
            Regex("""^ *$ifCondition *$""").find(str) != null
        )
    } else {
        println("Error: failed to read string")
    }
}