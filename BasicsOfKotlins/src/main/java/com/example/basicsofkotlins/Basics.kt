package com.example.basicsofkotlins

fun main() {/*
    zusaetzliche visibilities
    internal -> nur innerhalb des moduls
    open -> erlaubt das override und vererben
     */
    print("Hello Mama")

    // immutable variable
    val nonChangeAble = "Try it!1"

    // variable
    var variable = "String variable"

    //Numbers
    var aByte: Byte = Byte.MAX_VALUE // 8 bit
    val aShort: Short = Short.MAX_VALUE // 16 bit
    val aInt: Int = Int.MAX_VALUE // 32 bit
    val aLong: Long = Long.MAX_VALUE // 64 bit

    val aFloat: Float = 13.37f
    val aDouble: Double = 13.37

    //Boolean
    val aBoolean: Boolean = true

    //character
    val aChar: Char = 'A'

    //Stringthings
    val firstChar = variable[0]
    val lastChar = variable[variable.length - 1]
    val aTemplate = "String: $variable, Operations: ${variable.length}, Number: $aByte"

    // null references
    var nullableOne: String? = null
    val len = nullableOne ?: 1
    val len3 = nullableOne?.length ?: 1
    val len2 = nullableOne!!.length // force

    //typecasting
    val obj3: Any = "String"
    val obj2: String? = obj3 as? String
    println(obj2?.length ?: "")

    //if
    if (aByte is Byte) { // check for class
    } else if (false) {
    } else {
    }

    //when
    when (aInt) {
        1 -> print("is 1")
        2 -> {
            print("more lines")
        }
        in 3..5 -> println("range")
        in 9 downTo 6 -> print("down range")
        10, 11, 12 -> print("one of this")
        is Int -> print("check for class")
        else -> print("else")
    }

    val result = when (aInt) {
        is Int -> "is int"
        else -> "is else"
    }

    //while
    while (aByte is Byte) {
        break
    }

    do {
        break
    } while (true)

    //for
    for (num in 1..10) { // in range 1-10
        continue
    }
    for (num in 1 until 10) { // in range 1-9
    }
    for (num in 1 downTo -10 step -2) { // in range 1 to -10 by steps -2
    }

    // try catch
    try {
    } catch (e: Exception) {
        throw e
    } finally {
    }
}

//function
fun aVoid(a: Int, b: String) {
    return
}

fun withReturn(): Boolean {
    return true
}
