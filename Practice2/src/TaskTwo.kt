// Задание 2 Практическая работа 2
// В программе сделанной в задании 1, вынести проверяемое условие в отдельную single-expression функцию

fun taskTwo()
{
    print("Введите число:\n> ")
    val num: String? = readLine()

    if (num != null)
    {
        try
        {
            println(taskTwoSingleExp(taskOnePartOneFun(num.toInt())))
        }
        catch (ex: NumberFormatException)
        {
            println("Error: Значение не является числом")
        }
    }
    else
    {
        println("Error: Значение равно null")
    }
}

// Single-expression функция
fun taskTwoSingleExp(result: Int?): String =
    if (result != null)
        "Наименьшая цифра кратная трем: $result"
    else
        "Отсутствуют цифры кратные трем"
