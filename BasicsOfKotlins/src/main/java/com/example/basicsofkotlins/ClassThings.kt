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
open class Person constructor(name: String = "default", age: Int = 0) {
    var otherThings: Int? = null
    var name: String

    init { // init
        this.name = name
    }

    //second constructor
    constructor(year: Int) : this() {
        this.otherThings = year
    }

    open fun method(): Unit {
        return
    }
}

//inheritance
/*
alles was du ueberschreiben willst muss 'open' sein
 */
class Mann(name: String, age: Int, size: Short) : Person(name, age) {
    override fun method() {
        super.method()
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

//interface
interface IInterface {
    val value: String
    fun function(): String
    fun functionVoid()
    open fun toOverride() {
        print("something")
    }
}

class interImpl(override val value: String, override var variable: Any) : IInterface, AAbstract() {
    override fun function(): String = ""

    override fun functionVoid() {
    }

    override fun toOverride() {
    }

    override fun run() {
    }
}

abstract class AAbstract {
    abstract var variable: Any
    abstract fun run();
}

