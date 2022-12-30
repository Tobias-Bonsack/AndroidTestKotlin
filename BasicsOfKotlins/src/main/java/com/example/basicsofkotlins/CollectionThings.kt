package com.example.basicsofkotlins

import java.util.LinkedList

fun main() { // Arrays
    val numbers: IntArray = intArrayOf(1, 2, 3)
    val booleans = booleanArrayOf(true, true, false)
    val strings = arrayOf("s", "t", "r")
    val tests = arrayOf(Test(1), Test(2))
    println(numbers.contentToString())

    for (i in booleans) {
        val i1 = numbers[0]
    }
    for (i in strings.indices) { // alle indices
    }

    //lists etc.
    val stringList2 = listOf("a", "b")
    val stringList = mutableListOf("a", "b")
    stringList.add("c")
    stringList.remove("c")

    val set1 = setOf("a", "b", "a")
    val set2 = mutableSetOf("a", "b", "a")

    val map1 = mapOf(1 to "a", 2 to "b")
    val map2 = mutableMapOf(1 to "a", 2 to "b")
    for (key in map1.keys) {
    }

    val test: LinkedList<String> = LinkedList(stringList)

    //lambdas
    val sum: (Int, Int) -> Int = { a: Int, b: Int -> a + b }
    val sum2 = { a: Int, b: Int -> println(a + b) }
    val sum3 = { a: Int, b: Int ->
        {
            val message = a + b
            println(message)
        }
    }
}

data class Test(val i: Int)