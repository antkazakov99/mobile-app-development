// С клавиатуры вводится несколько целых значений через
// пробел. Найдите (без учета тех чисел, где соответствующей цифры нет)
// Побитовое исключающее ИЛИ первой цифры всех чисел

fun taskFour()
{
    print("Введите набор целых чисел разделенных пробелом: ")
    val strOfNums: String? = readLine()

    // Проверка на null
    if (strOfNums != null)
    {
        // Проверка является ли num числом
        try
        {
            print(strOfNums.split(' ').filter { it.length > 0 }.fold(0) { total, next -> total xor next[0].toString().toInt()})
        }
        catch (e: NumberFormatException)
        {
            println("Error: value is not a Number")
        }
    }
    else
    {
        println("Error: value is null")
    }
}
