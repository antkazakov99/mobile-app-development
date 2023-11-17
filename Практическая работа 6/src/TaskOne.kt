fun taskOne()
{
    val newFun = min<String>({ i -> i.toIntOrNull()}, {j -> (j+100).toIntOrNull()})
    if (newFun != null) {
        println(newFun("f"))
    }
    else
    {
        println("null")
    }
}

fun<T> min(fun1: (T) -> Int?, fun2:(T) -> Int?): ((T)->Int?)
{
    return { T ->
        if (fun1(T) == null || fun2(T) == null)
        {
            null
        }
        else
        {
            if(fun1(T)!! < fun2(T)!!) fun1(T) else fun2(T)
        }
    }
}