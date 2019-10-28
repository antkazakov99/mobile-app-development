// Варианты рещения третьего задания практической работы №1


// В строке, найдите последний символ в первом самом коротким слове с четным числом символов (в строке указываются
// только слова разделенные одним или несколькими пробелами).
// Вариант с проверкой количества символов в слове
fun taskThree()
{
    print("Введите строку:\n> ")
    var str: String? = readLine()

    // Порядковый номер последнего слова в строке
    var numOfSym = 0
    // Последний введенный символ
    var lastSymbol: Char? = null
    // Порядковый символ последнего символа в самом коротком слове с четным числов символов
    var numOfShortest = 0
    // Последний символ самого короткого слова с четным числом символов
    var symOfShortest: Char? = null

    if(str != null)
    {
        // Добавление пробела в конце строки для избежания необходимости отдельной проверки последнего слова
        str += ' '
        // Проход всех символов строки
        for(sym: Char in str)
        {
            // Проверка на пробел
            if(sym != ' ')
            {
                numOfSym++
                lastSymbol = sym
            }
            else
            {
                // Проверка на четность символов строки, а также проверка на то является ли пробел первым
                if(numOfSym % 2 == 0 && lastSymbol != null)
                {
                    if(symOfShortest == null || (numOfShortest > numOfSym && symOfShortest != null))
                    {
                        symOfShortest = lastSymbol
                        numOfShortest = numOfSym
                    }
                }
                numOfSym = 0
                lastSymbol = null
            }
        }
        if(symOfShortest != null)
        {
            println("Последний символ самого короткого слова с четным числом символов: \"$symOfShortest\"\n" +
                    "Длина самого короткого слова: $numOfShortest")
        }
        else
        {
            println("В строке отсутствуют слова с четным количеством символов.")
        }
    }
    else
    {
        println("Error: value is null")
    }
}