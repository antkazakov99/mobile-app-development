fun main()
{
    print("Введите строку:\n> ")
    var str: String? = readLine()

    // Проверка на null
    if (str != null)
    {
        print(Regex("""^ *[I|i][F|f] *""" +
            """\( *[a-z|A-Z][0123456789|a-z|A-Z]* *(>|<|>=|<=|=|!=) *\".*\"\) *""" +
            """[T|t][H|h][E|e][N|n] *[a-z|A-Z][0123456789|a-z|A-Z]* *:= *([a-z|A-Z][0123456789|a-z|A-Z]*|[0123456789][0123456789]*) *""" +
            """((\+|-|\*|/) *([a-z|A-Z][0123456789|a-z|A-Z]*|[0123456789][0123456789]*) *)* *; *$""".trimMargin()).find(str) != null)
    }
    else
    {
        println("Error: value is null")
    }
}