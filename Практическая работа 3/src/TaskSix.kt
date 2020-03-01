// По данному натуральному числу n найдите наименьшее простое число, большее n

fun taskSix()
{
    // Ввод целого неотрицательного числа
    print("Введите число:\n> ")
    val str: String? = readLine()

    // Проверка является ли num числом
    try
    {
        // Проверка на null
        if (str != null)
        {
            // Без понятия зачем здесь функции высшего порядка
            var num = str.toInt()
            var simple = false
            while(!simple)
            {
                num++
                simple = true
                var i = 1
                while(i < num - 1)
                {
                    i++
                    if ((num % i) == 0)
                    {
                        simple = false
                    }
                }
            }
            println("Наименьшее простое число: $num")
        }
        else
        {
            println("Error: value is null")
        }
    }
    catch (e: NumberFormatException)
    {
        println("Error: value is not a Number")
    }

}
