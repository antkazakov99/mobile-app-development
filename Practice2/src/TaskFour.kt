// Практическая работа 2 Задание 4
// Изменить программу сделанную в задании 3 практической работы 1:
// Вынести алгоритм в отдельную функцию, куда в качестве аргумента необходимо передовать лямбда функцию сравнения двух
// чисел, изменяя данную функцию, должна быть возможность получать информацию о самых коротких, либо самых длинных
// словах. Аналогичным способом в функцию должна передаваться функция отбора слов

// Практическая работа 1 задание 3
// Найди последний символ в первом самом коротком слове с четным числом символов в строке

fun taskFour()
{
    print("Введите строку:\n> ")
    var str: String? = readLine()

    if(str != null)
    {
        val result = taskFourFun(str)
        if(result != null)
        {
            println("Последний символ самого короткого слова с четным числом символов: \"$result\"\n")
        }
        else
        {
            println("В строке отсутствуют слова с четным количеством символов.")
        }
    }
    else
    {
        println("Error: значение равно null")
    }
}

// Основной алгоритм, в него передается алгоритм сравнения двух символов?
fun taskFourFun
    (
        string: String,
        lengthOfWords: (resultWordNum: Int, lastWordNum: Int) -> Boolean =
            {resultWordNum: Int, lastWordNum: Int -> resultWordNum <= lastWordNum},
        countOfSym: (num: Int) -> Boolean = { it % 2 == 0}
    )
{
    // Порядковый номер последнего слова в строке
    var numOfSym = 0
    // Последний введенный символ
    var lastSymbol: Char? = null
    // Порядковый символ последнего символа в самом коротком слове с четным числов символов
    var numOfResult = 0
    // Последний символ самого короткого слова с четным числом символов
    var symOfResult: Char? = null
    // Добавление пробела в конце строки для избежания необходимости отдельной проверки последнего слова
    var str = string + ' '
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
            if(countOfSym(numOfSym) && lastSymbol != null)
            {
                if(symOfResult == null || (lengthOfWords(numOfResult, numOfSym) && symOfResult != null))
                {
                    symOfResult = lastSymbol
                    numOfResult = numOfSym
                }
            }
            numOfSym = 0
            lastSymbol = null
        }
    }
}