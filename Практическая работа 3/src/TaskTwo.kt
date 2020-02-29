// В строке указано несколько неотрицательных чисел, раздленных пробелами (по одному пробелу между числами). Какое
// количество чисел удовлетворяет условию наличия повторяющихся цифр.

fun taskTwo()
{
    // Ввод набора целых неотрицательных чисел
    print("Введите набор целых чисел разделенных пробелом: ")
    val strOfNums: String? = readLine()

    // Проверка на null
    if (strOfNums != null)
    {
//        val strOfNum = "$strOfNums "
        try
        {
            val count = strOfNums.split(' ').count { it.groupingBy { it }.eachCount().filter { it.toPair().second > 1 }.isNotEmpty() }
            println("Количество чисел удовлетворяющих условию наличия повторяющихся цифр: $count")
        }
        catch (e: NumberFormatException)
        {
            println("Error: NumberFormatException")
        }
    }
    else
    {
        println("Error: value is null")
    }
}