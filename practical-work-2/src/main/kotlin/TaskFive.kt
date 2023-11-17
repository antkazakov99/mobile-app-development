import java.awt.List

// Практическая работа 2 Задание 5
// Создать функцию, которая реализует алгоритм второго задания первой практической работы, в которую все числа,
// слова или пары (в зависимости от варианта) передаются в аргументах функции.

// Практическая работа 1 Задание 2
// В строке указано несколько неотрицательных чисел, разделенных пробелами. Какое количество чисел удовлетворяет
// условию наличия повторяющихся чисел?

fun taskFive()
{
    // Ввод набора целых неотрицательных чисел
    print("Введите набор целых чисел разделенных пробелом: ")
    val str: String? = readLine()

    if(str != null)
    {
        val nums = str.split(' ')
        println("Количество чисел удовлетворяющих условию наличия повторяющихся цифр: ${taskFiveFunc(*nums.toTypedArray())}")
    }
    {
        println("Error: Value is null")
    }
}

fun taskFiveFunc(vararg nums: String): Int
{
    var count = 0
    for(num in nums)
    {
        val countOfNum: Array<Int> = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        for (sym in num.toString())
        {
            countOfNum[sym.toString().toInt()]++
        }
        var repeated = false
        for(i in countOfNum)
        {
            if(i > 1) repeated = true
        }
        if(repeated) count++
    }
    return count
}