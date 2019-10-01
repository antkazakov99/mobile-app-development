// Варианты рещения третьего задания практической работы №1


// Найдите последний символ в первом самом коротком слове в строке с четным числом символов (в строке указываются
// только слова разделенные одним или несколькими пробелами).
// То как должна звучать задача:
// В строке, найдите последний символ в первом самом коротким слове с четным числом символов (в строке указываются
// только слова разделенные одним или несколькими пробелами).
// !!! Добавить проверку на четное число символов
fun taskThree1()
{
    print("Введите строку: ")
    val str: String? = readLine()

    if(str != null)
    {
        // Порядковый номер текущего символа в слове
        var numOfSym = 0
        // Последный введенный символ
        var lastSymbol: Char? = null
        // Порядковый номер последнего символа в самом коротком слове
        var numOfShortest = 0
        // Последний символ самого короткого слова
        var symOfShortest: Char? = null

        for(sym: Char in str)
        {
            if(sym != ' ')
            {
                numOfSym++
                lastSymbol = sym
                println("$numOfSym - $sym")
            }
            else
            {
                if (numOfShortest != 0)
                {
                    if(numOfShortest > numOfSym)
                    {
                        symOfShortest = lastSymbol
                        numOfShortest = numOfSym
                    }
                }
                else
                {
                    symOfShortest = lastSymbol
                    numOfShortest = numOfSym
                }
                numOfSym = 0
                println()
            }
        }
        // Проверка последнего слова
        if((symOfShortest == null || (numOfShortest > numOfSym && numOfSym != 0)))
        {
            symOfShortest = lastSymbol
            numOfShortest = numOfSym
        }

        println("\nПоследний символ первого самого короткого слова в строке: $symOfShortest\n" +
                "Порядковый номер символа: $numOfShortest")
    }
    else
    {
        println("Error: value is null")
    }
}


// В строке, найдите последний символ в первом самом коротким слове с четным числом символов (в строке указываются
// только слова разделенные одним или несколькими пробелами).
// Вариант с проверкой количества символов в слове
fun taskThree2()
{
    print("Введите строку: ")
    val str: String? = readLine()

    if(str != null)
    {
        // Порядковый номер текущего символа в слове
        var numOfSym = 0
        // Последный введенный символ
        var lastSymbol: Char? = null
        // Порядковый номер последнего символа в самом коротком слове
        var numOfShortest = 0
        // Последний символ самого короткого слова
        var symOfShortest: Char? = null

        for(sym: Char in str)
        {
            if(sym != ' ')
            {
                numOfSym++
                lastSymbol = sym
                println("$numOfSym - $sym")
            }
            else
            {
                if (numOfShortest != 0)
                {
                    if(numOfShortest > numOfSym && numOfSym % 2 == 0)
                    {
                        symOfShortest = lastSymbol
                        numOfShortest = numOfSym
                    }
                }
                else
                {
                    if(numOfSym % 2 == 0)
                    {
                        symOfShortest = lastSymbol
                        numOfShortest = numOfSym
                    }
                }
                numOfSym = 0
                println()
            }
        }
        // Проверка последнего слова
        if((symOfShortest == null || (numOfShortest > numOfSym && numOfSym != 0)) && numOfSym % 2 == 0)
        {
            symOfShortest = lastSymbol
            numOfShortest = numOfSym
        }

        println("\nПоследний символ первого самого короткого слова c четным количеством символов в строке: $symOfShortest\n" +
                "Порядковый номер символа: $numOfShortest")
    }
    else
    {
        println("Error: value is null")
    }
}