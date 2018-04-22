package com.stewsters.visualNovel

/**
 * These are some functions to prototype a Kotlin DSL for visual novels.
 */

enum class Gender {
    MALE,
    FEMALE
}

data class Student(val name: String, val gender: Gender) {
    override fun toString(): String {
        return name
    }

    infix fun says(string: String) {
        println("${this.name}: $string")
        readLine()
    }

    infix fun asks(s: String): Question {
        println("${this.name}: $s")
        return Question()
    }

    infix fun looks(look: Appearance) {
        println("$name looks $look");
    }
}

data class Appearance(val name: String) {
    override fun toString(): String {
        return name
    }
}

data class Location(val name: String) {
    override fun toString(): String {
        return name
    }
}

fun scene(background: Location) {
    println("Background changes to ${background}")
}

class Question() {

    infix fun reply(options: Map<String, () -> Unit>) {

        var line = 1
        val optionMap = mutableMapOf<Int, () -> Unit>()

        options.forEach { key, value ->
            optionMap[line] = value;
            println("${line++}: $key")
        }

        while (true) {
            try {
                val option = readLine()
                var selection: Int? = option?.toInt()
                optionMap[selection]?.invoke();
                return

            } catch (e: NumberFormatException) {
                println("invalid number")
            }
        }

    }
}