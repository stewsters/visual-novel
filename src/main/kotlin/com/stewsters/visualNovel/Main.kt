package com.stewsters.visualNovel

// Scenes
val convenienceStore = Location("convenience store")
val school = Location("school")
val beach = Location("beach")

// Looks
val embarrased = Appearance("embarrased")
val dejected = Appearance("dejected")

// Characters
val tom = Student("Tom", Gender.MALE)
val rachael = Student("Rachael", Gender.FEMALE)
val ann = Student("Ann", Gender.FEMALE)


fun main(args: Array<String>) {

    scene(school)

    tom says "Hi, $rachael"
    rachael says "Whats up, $tom?"

    ann asks "Aren't you guys going to go out already?" reply mapOf(
            "Uh, yeah, lets do it!" to {
                rachael looks embarrased
                ann says "Awesome"
            },
            "No, gross." to {
                rachael looks dejected
                ann says "I'm sorry."
            }
    )

    ann asks "Do you guys want to go to the 7 eleven?" reply mapOf(
            "Sure" to {
                scene(convenienceStore)
            },
            "Nah, lets go to the beach." to {
                scene(beach)
            }
    )


}


