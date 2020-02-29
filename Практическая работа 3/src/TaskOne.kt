// Минимальная цифра, кратная трем
// Try Catch вариант
fun taskOne()
{
    // Ввод целого неотрицательного числа
    print("Введите число:\n> ")
    val num: String? = readLine()

    //  Проверка на null
    if (num != null)
    {
        // Проверка является ли num числом
        try
        {
            val num2 = num.filter {it.toString().toInt() % 3 == 0}.min()

            // Без учета 0
            //val num2 = num.filter {it.toString().toInt() % 3 == 0 && it.toString().toInt() != 0}.min()

            // Вывод результата
            if (num2 == null)
            {
                println("Отсутствуют числа кратные трем")
            }
            else
            {
                println("Наименьшее число кратное трем: $num2")
            }

        }
        catch (e: NumberFormatException)
        {
            println("Error: value is not a Number")
        }
    }
    else
    {
        println("Error: value is Null")
    }
}