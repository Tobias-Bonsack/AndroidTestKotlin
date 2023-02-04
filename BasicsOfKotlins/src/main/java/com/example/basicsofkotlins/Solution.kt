package com.example.basicsofkotlins

import java.util.*
import java.io.*
import java.math.*

val directions = arrayOf(arrayOf(0, -1), arrayOf(-1, 0), arrayOf(0, 1), arrayOf(1, 0))
val visited = mutableSetOf<Cell>()

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val R = input.nextInt()
    val C = input.nextInt()
    val T = input.nextInt()

    val field = Array(R) { i -> Array(C) { j -> Cell(i, j) } }

    val queue = LinkedList<Cell>()
    queue.addFirst(field[0][0])
    visited.add(field[0][0])

    var result = 0
    while (!queue.isEmpty()) {
        val nextCell = queue.pollFirst()
        result++

        val allowedSteps = getSteps(nextCell, T, field)
        queue.addAll(allowedSteps)
    }

    println(result)
}

fun getSteps(nextCell: Cell, robot: Int, field: Array<Array<Cell>>): List<Cell> {
    val result = mutableListOf<Cell>()
    for (direction in directions) {
        try {
            val newCell = field[nextCell.hor + direction[0]][nextCell.ver + direction[1]]
            if (!visited.contains(newCell) && robot >= newCell.sum) {
                visited.add(newCell)
                result.add(newCell)
            }
        } catch (e: Exception) { //Ignore
        }
    }

    return result
}

class Cell(hor: Int, ver: Int) {
    val hor: Int
    val ver: Int
    var sum: Int

    init {
        this.hor = hor
        this.ver = ver
        this.sum = getValue()
    }

    private fun getValue(): Int {
        return getSumOfDigits(hor) + getSumOfDigits(ver)
    }

    private fun getSumOfDigits(number: Int): Int {
        var number = number
        var sum = 0
        while (number > 0) {
            val r = number % 10
            sum += r
            number /= 10
        }
        return sum
    }
}
