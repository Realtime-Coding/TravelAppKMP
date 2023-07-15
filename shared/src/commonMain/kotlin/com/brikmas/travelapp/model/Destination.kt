package com.brikmas.travelapp.model

import com.brikmas.travelapp.SharedRes
import dev.icerock.moko.resources.ImageResource

data class Destination(
    val id: Int,
    val thumbnail: ImageResource,
    val title: String,
    val description: String,
    val rating: Float,
    val location: String,
    val price: String,
    val type: String,
    val image: List<ImageResource>
)

val destinations = arrayListOf<Destination>().apply {
    add(
        Destination(
            id = 1,
            thumbnail = SharedRes.images.destination_thumbnail,
            title = "Rinjani Mountain",
            description = "The mighty Rinjani mountain of Gunung Rinjani is a massive volcano which towers over the island of Lombok. A climb to the top is one of the most exhilarating experiences you can have in Indonesia. At 3,726 meters tall, Gunung Rinjani is the second highest mountain in Indonesia...",
            rating = 4.7f,
            location = "Lombok, Indonesia",
            price = "$48",
            type = "Person",
            image = arrayListOf(
                SharedRes.images.destination1,
                SharedRes.images.destination2,
                SharedRes.images.destination3,
                SharedRes.images.destination4
            )
        )
    )
    add(
        Destination(
            id = 1,
            thumbnail = SharedRes.images.destination_thumbnail,
            title = "Bromo Mountain",
            description = "The mighty Rinjani mountain of Gunung Rinjani is a massive volcano which towers over the island of Lombok. A climb to the top is one of the most exhilarating experiences you can have in Indonesia. At 3,726 meters tall, Gunung Rinjani is the second highest mountain in Indonesia...",
            rating = 4.7f,
            location = "Lombok, Indonesia",
            price = "$48",
            type = "Person",
            image = arrayListOf(
                SharedRes.images.destination1,
                SharedRes.images.destination2,
                SharedRes.images.destination3,
                SharedRes.images.destination4
            )
        )
    )
    add(
        Destination(
            id = 1,
            thumbnail = SharedRes.images.destination_thumbnail,
            title = "Rinjani Mountain",
            description = "The mighty Rinjani mountain of Gunung Rinjani is a massive volcano which towers over the island of Lombok. A climb to the top is one of the most exhilarating experiences you can have in Indonesia. At 3,726 meters tall, Gunung Rinjani is the second highest mountain in Indonesia...",
            rating = 4.7f,
            location = "Lombok, Indonesia",
            price = "$48",
            type = "Person",
            image = arrayListOf(
                SharedRes.images.destination1,
                SharedRes.images.destination2,
                SharedRes.images.destination3,
                SharedRes.images.destination4
            )
        )
    )
    add(
        Destination(
            id = 1,
            thumbnail = SharedRes.images.destination_thumbnail,
            title = "Rinjani Mountain",
            description = "The mighty Rinjani mountain of Gunung Rinjani is a massive volcano which towers over the island of Lombok. A climb to the top is one of the most exhilarating experiences you can have in Indonesia. At 3,726 meters tall, Gunung Rinjani is the second highest mountain in Indonesia...",
            rating = 4.7f,
            location = "Lombok, Indonesia",
            price = "$48",
            type = "Person",
            image = arrayListOf(
                SharedRes.images.destination1,
                SharedRes.images.destination2,
                SharedRes.images.destination3,
                SharedRes.images.destination4
            )
        )
    )
}
