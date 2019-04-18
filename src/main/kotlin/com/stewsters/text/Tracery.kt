package com.stewsters.text

import org.apache.commons.lang3.StringUtils
import java.util.*

// WIP

fun main() {
    val data = mapOf(
            "name" to listOf("Arjun", "Yuuma", "Darcy", "Mia", "Chiaki", "Izzi", "Azra", "Lina"),
            "animal" to listOf("unicorn", "raven", "sparrow", "scorpion", "coyote", "eagle", "owl", "lizard", "zebra", "duck", "kitten"),
            "mood" to listOf("vexed", "indignant", "impassioned", "wistful", "astute", "courteous"),
            "story" to listOf("<hero> traveled with her pet <heroPet>.  <hero> was never <mood>, for the <heroPet> was always too <mood>."),
            "origin" to listOf("#[hero:#name#][heroPet:#animal#]story#")
    )


    println(trace(data))

}

val r = Random()
fun random(corpus: List<String>) = corpus.get(r.nextInt(corpus.size))
fun <K, T> randomKey(map: Map<K, T>): K = map.keys.toList().get(r.nextInt(map.size))


fun trace(data: Map<String, List<String>>) {

    val stories = data["story"]!!

    val story = random(stories)

    // elaborate story.  Find pieces demarked by # and run against them
    println(expand(story, data))

}

fun expand(string: String, data: Map<String, List<String>>) {
    StringUtils.substringBetween(string, "<", ">");


    val parts = string.split('#')
    println(parts)

}

