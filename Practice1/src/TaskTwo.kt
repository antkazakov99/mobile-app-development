// Варианты решения второго задания практической работы №1

// В строке указано несколько неотрицательных чисел, раздленных пробелами (по одному пробелу между числами). Какое
// количество чисел удовлетворяет условию наличия повторяющихся цифр.
// Не подходит т.к. использует встроенные средства языка
fun taskTwo1()
{
    // Ввод набора целых неотрицательных чисел
    print("Введите набор целых чисел разделенных пробелом: ")
    val strOfNum: String? = readLine()

    // Проверка на null
    if (strOfNum != null)
    {
        // Обработка исклчения в случае если numbers не является числом
        try
        {
            var count = 0
            // Разбиение строки на массив строк
            val numbers: List<String> = strOfNum.split(' ').map { it.trim().toInt().toString() }

            // Перечисление чисел
            for(num: String in numbers)
            {
                if (num.groupingBy { it }.eachCount().filter { it.value > 1 }.count() > 0)
                {
                    count++
                }
            }

            println("Количество чисел удовлетворяющих условию наличия повторящихся чисел: $count")
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

// В строке указано несколько неотрицательных чисел, раздленных пробелами (по одному пробелу между числами). Какое
// количество чисел удовлетворяет условию наличия повторяющихся цифр.
// Неоптимально, необходимо использовать массив
// Вариант без использования встроенных средств
// Без выноса в отдельную функцию
fun taskTwo2()
{
    // Ввод набора целых неотрицательных чисел
    print("Введите набор целых чисел разделенных пробелом: ")
    val strOfNum: String? = readLine()

    // Проверка на null
    if (strOfNum != null)
    {
        // Количество чисел удовлетворяющих условию повторяющихся цифр
        var count = 0
        // Строка в которую будут записываться числа
        var num = ""

        for(sym in strOfNum)
        {
            if(sym != ' ')
            {
                num += sym
            }
            else
            {
                var searching = ""
                var repeated = false
                // Проверка на наличие повторов
                for(sym2 in num)
                {
                    for(sym3 in searching)
                    {
                        if(sym2 == sym3)
                        {
                            repeated = true
                        }
                        searching += sym2
                    }
                    searching += sym2
                }
                if (repeated)
                    count++
                num = ""
            }
        }
        // Проверка последнего числа
        if(num != "")
        {
            // Проверка на наличие повторов
            var searching = ""
            var repeated = false
            for(sym2 in num)
            {
                for(sym3 in searching)
                {
                    if(sym2 == sym3)
                    {
                        repeated = true
                    }
                    searching += sym2
                }
                searching += sym2
            }
            if (repeated)
                count++
        }

        println("Количество чисел удовлетворяющих условию повторяющихся чисел: $count")
    }
    else
    {
        println("Error: value is null")
    }
}

// Проверка наличия повторяющихся цифр в числе для второго задания
fun taskTwoSearching(num: String): Boolean
{
    var searching = ""
    // Проверка на наличие повторов
    for(sym2 in num)
    {
        for(sym3 in searching)
        {
            if(sym2 == sym3)
            {
                return true
            }
            searching += sym2
        }
        searching += sym2
    }
    return false
}

// В строке указано несколько неотрицательных чисел, раздленных пробелами (по одному пробелу между числами). Какое
// количество чисел удовлетворяет условию наличия повторяющихся цифр.
// Вариант без использования встроенных средств
// Проверка на наличиие повторений вынесена в отдельную функцию
fun taskTwo3()
{
    // Ввод набора целых неотрицательных чисел
    print("Введите набор целых чисел разделенных пробелом: ")
    val strOfNum: String? = readLine()

    // Проверка на null
    if (strOfNum != null)
    {
        // Количество чисел удовлетворяющих условию повторяющихся цифр
        var count = 0
        // Строка в которую будут записываться числа
        var num = ""

        for(sym in strOfNum)
        {
            if(sym != ' ')
            {
                num += sym
            }
            else
            {
                if(taskTwoSearching(num))
                    count++
                num = ""
            }
        }
        // Проверка последнего числа
        if(num != "")
        {
            // Проверка на наличие повторов
            if(taskTwoSearching(num))
                count++
        }

        println("Количество чисел удовлетворяющих условию повторяющихся чисел: $count")
    }
    else
    {
        println("Error: value is null")
    }
}

// В строке указано несколько неотрицательных чисел, раздленных пробелами (по одному пробелу между числами). Какое
// количество чисел удовлетворяет условию наличия повторяющихся цифр.
// Вариант без использования встроенных средств
// Вариант с использованием массива
fun taskTwo4()
{
    // Ввод набора целых неотрицательных чисел
    print("Введите набор целых чисел разделенных пробелом: ")
    val strOfNum: String? = readLine()

    // Проверка на null
    if (strOfNum != null)
    {
        try
        {
            // Количество чисел удовлетворяющих условию наличия повторяющихся чисел
            var count = 0
            // Массив для подсчета повторяющихся цифр в числе
            val countOfNum: Array<Int> = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

            for(sym: Char in strOfNum)
            {
                if(sym != ' ')
                {
                    countOfNum[sym.toString().toInt()]++
                }
                else
                {
                    // Индикатор наличия повторяющихся цифр
                    var repeated = false
                    // Проверка наличия повторяющихся цифр и обнуление массива
                    for((i, num) in countOfNum.withIndex())
                    {
                        if(countOfNum[i] > 1)
                        {
                            repeated = true
                        }
                        countOfNum[i] = 0
                    }
                    if (repeated)
                    {
                        count++
                    }
                }
            }
            // Индикатор наличия повторяющихся цифр
            var repeated = false
            // Проверка наличия повторяющихся цифр и обнуление массива
            for((i, num) in countOfNum.withIndex())
            {
                if(countOfNum[i] > 1)
                {
                    repeated = true
                }
                countOfNum[i] = 0
            }
            if (repeated)
            {
                count++
            }
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