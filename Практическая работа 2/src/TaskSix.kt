// Практическая работа 2 Задание 6
// Создайте функцию, которая по данным двум функциям с параметрами типа Int и результатами типа Int? возварщает
// новую функцию - минимум данных. Если результат хотя бы одной из исходных функций null, то и результат возвращаемой
// функции null

fun taskSix()
{
    println(taskSixFunc(7, {i: Int -> i + 150 }, {i: Int -> i * i}));
}

fun taskSixFunc(i: Int, fun1: (i: Int)-> Int?, fun2: (i: Int)-> Int?): Int?
{

    if(fun1(i) != null && fun2(i) != null)
    {
        if(fun1(i)!! <= fun2(i)!!)
        {
            return fun1(i)
        }
        else
        {
            return fun2(i)
        }
    }
    else
    {
        return null
    }
}