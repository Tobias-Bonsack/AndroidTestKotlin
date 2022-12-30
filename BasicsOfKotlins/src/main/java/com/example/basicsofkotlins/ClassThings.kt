package com.example.basicsofkotlins


fun main() {
    val person = Person("name", 12)
    val defaultValues = Person()

    // easy copy able
    val dataClass = DataClass(10, "10")
    dataClass.copy(id = 15)
    val (name) = dataClass
    print(name)
}

class ClassThings {}

//with constructors ... "constructor" is optional
class Person constructor(name: String = "default", age: Int = 0) {
    var otherThings: Int? = null
    var name: String

    init { // init
        this.name = name
    }

    //second constructor
    constructor(year: Int) : this() {
        this.otherThings = year
    }

    fun method(): Unit {
        return
    }
}

//setters and getter
class Car() {
    lateinit var owner: String

    var brand: String = "BWM"
        get() {
            return brand.lowercase()
        }
        set(value) {
            field = value.uppercase()
        }

    var maxSpeed = 0
        get() = field * 2
        private set

    init {
        owner = ""
    }
}

//data class
data class DataClass(val id: Int, val name: String)

