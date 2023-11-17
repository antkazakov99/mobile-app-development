fun taskThree() {

    print("Введите строку:\n> ")
    var str: String? = readlnOrNull()

    // Порядковый номер последнего символа в слове
    var numOfSym = 0
    // Последний прочитанный символ
    var lastSymbol: Char? = null
    // Длина самого короткого слова с четным числов символов
    var numOfShortest = 0
    // Последний символ самого короткого слова с четным числом символов
    var symOfShortest: Char? = null

    if (str != null) {
        // Проход всех символов строки
        for (sym: Char in str) {
            // Проверка на пробел
            if (sym != ' ') {
                numOfSym++
                lastSymbol = sym
            } else {
                // Проверка на четность символов строки, а также проверка на то является ли пробел первым
                if ((numOfSym % 2) == 0 && lastSymbol != null) {
                    if (symOfShortest == null || (numOfShortest > numOfSym)) {
                        symOfShortest = lastSymbol
                        numOfShortest = numOfSym
                    }
                }
                numOfSym = 0
                lastSymbol = null
            }
        }

        if ((numOfSym % 2) == 0 && lastSymbol != null) {
            if (symOfShortest == null || (numOfShortest > numOfSym)) {
                symOfShortest = lastSymbol
                numOfShortest = numOfSym
            }
        }

        if (symOfShortest != null) {
            println(
                "Последний символ самого короткого слова с четным числом символов: \"$symOfShortest\"\n" +
                        "Длина самого короткого слова: $numOfShortest"
            )
        } else {
            println("В строке отсутствуют слова с четным количеством символов.")
        }
    } else {
        println("Error: value is null")
    }
}