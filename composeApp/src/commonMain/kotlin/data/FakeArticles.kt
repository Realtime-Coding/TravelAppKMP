package data

import model.Article
import model.Destination
import model.Paragraph

object FakeArticles {
    val destinations = listOf(
        Destination(
            id = 1,
            thumbnail = "https://plus.unsplash.com/premium_photo-1670148434900-5f0af77ba500?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8c3BsYXNofGVufDB8fDB8fHww",
            title = "Mount Bromo",
            description = "An active volcano and one of Indonesia's most iconic natural landmarks. Known for its dramatic sunrise views and lunar landscapes.",
            rating = 4.7f,
            location = "East Java, Indonesia",
            price = "1300",
            type = "Volcano",
            category = FakeCategories.categories[0],
            image = listOf(
                "https://plus.unsplash.com/premium_photo-1670148434900-5f0af77ba500?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8c3BsYXNofGVufDB8fDB8fHww",
                "https://images.unsplash.com/photo-1503435980610-a51f3ddfee50?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8Zm9yZXN0fGVufDB8fDB8fHww",
                "https://images.unsplash.com/photo-1476231682828-37e571bc172f?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8Zm9yZXN0fGVufDB8fDB8fHww"
            ),
            dates = listOf("Year-round"),
            meetingPoints = listOf("Mount Bromo Entrance"),
            facilities = listOf("Guide Services", "Parking", "Local Restaurants"),
            via = "Probolinggo",
            estimation = "2-3 hours hike"
        ),
        Destination(
            id = 2,
            thumbnail = "https://images.unsplash.com/photo-1525431836161-e40d6846e656?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8c3BsYXNofGVufDB8fDB8fHww",
            title = "Semeru",
            description = "The highest peak in Java, offering challenging hikes and breathtaking views.",
            rating = 4.8f,
            location = "East Java, Indonesia",
            price = "1900",
            type = "Volcano",
            category = FakeCategories.categories[1],
            image = listOf(
                "https://images.unsplash.com/photo-1525431836161-e40d6846e656?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8c3BsYXNofGVufDB8fDB8fHww",
                "https://plus.unsplash.com/premium_photo-1664300792059-863ccfe55932?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Zm9yZXN0fGVufDB8fDB8fHww",
                "https://images.unsplash.com/photo-1477601263568-180e2c6d046e?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8c25vd3xlbnwwfHwwfHx8MA%3D%3D"
            ),
            dates = listOf("Year-round"),
            meetingPoints = listOf("Tumpang Village"),
            facilities = listOf("Camping Sites", "Guide Services"),
            via = "Tumpang",
            estimation = "3-4 days trek"
        ),
        Destination(
            id = 3,
            thumbnail = "https://media.istockphoto.com/id/1954840203/photo/businessman-holding-green-scrap-paper-ball-with-world-map-and-environment-icon-such-as-carbon.webp?b=1&s=612x612&w=0&k=20&c=RH3KRhXeEnJxEM838wb716lPQlQnUtLW4BDq1_8E5v0=",
            title = "Nusa Penida",
            description = "A stunning island known for its cliff views and beautiful beaches, offering a tranquil retreat from Bali's tourist spots.",
            rating = 4.5f,
            location = "Bali, Indonesia",
            price = "1100",
            type = "Island",
            category = FakeCategories.categories[2],
            image = listOf(
                "https://media.istockphoto.com/id/1954840203/photo/businessman-holding-green-scrap-paper-ball-with-world-map-and-environment-icon-such-as-carbon.webp?b=1&s=612x612&w=0&k=20&c=RH3KRhXeEnJxEM838wb716lPQlQnUtLW4BDq1_8E5v0=",
                "https://images.unsplash.com/photo-1507041957456-9c397ce39c97?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8Zm9yZXN0fGVufDB8fDB8fHww",
                "https://media.istockphoto.com/id/2086523944/photo/footprints-of-friendship.jpg?s=612x612&w=0&k=20&c=n0KO7DMwFsD504jykw8uTmVuSoP8ddaR6F27zYbsJuc="
            ),
            dates = listOf("Year-round"),
            meetingPoints = listOf("Sanur Harbor"),
            facilities = listOf("Snorkeling Gear", "Local Guides"),
            via = "Sanur",
            estimation = "1 day visit"
        ),
        Destination(
            id = 4,
            thumbnail = "https://media.istockphoto.com/id/1474101168/photo/drone-view-on-rocks-and-canoes-floating-on-turquoise-water-in-the-halong-bay-vietnam.webp?b=1&s=612x612&w=0&k=20&c=61AIF3YY7ZaJZPw8LzLIdwAfcnDyZgkb3ZoHEoN5t1g=",
            title = "Nusa Lembongan",
            description = "A beautiful island offering snorkeling and relaxation opportunities with a laid-back atmosphere.",
            rating = 4.6f,
            location = "Bali, Indonesia",
            price = "1000",
            type = "Island",
            category = FakeCategories.categories[3],
            image = listOf(
                "https://media.istockphoto.com/id/1474101168/photo/drone-view-on-rocks-and-canoes-floating-on-turquoise-water-in-the-halong-bay-vietnam.webp?b=1&s=612x612&w=0&k=20&c=61AIF3YY7ZaJZPw8LzLIdwAfcnDyZgkb3ZoHEoN5t1g=",
                "https://images.unsplash.com/photo-1503435980610-a51f3ddfee50?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8Zm9yZXN0fGVufDB8fDB8fHww",
                "https://images.unsplash.com/photo-1469474968028-56623f02e42e?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fG5hdHVyZXxlbnwwfHwwfHx8MA%3D%3D",
                "https://media.istockphoto.com/id/1437124828/photo/car-tyre-on-a-snowy-road-in-winter.webp?b=1&s=612x612&w=0&k=20&c=G0zXf-oZWU5AAuUDYfh-WS9uWKHpBmKQOmMWLRVEftQ="
            ),
            dates = listOf("Year-round"),
            meetingPoints = listOf("Jungut Batu Harbor"),
            facilities = listOf("Snorkeling Gear", "Beachfront Accommodations"),
            via = "Sanur",
            estimation = "2 days stay"
        ),
        Destination(
            id = 5,
            thumbnail = "https://images.unsplash.com/photo-1469474968028-56623f02e42e?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fG5hdHVyZXxlbnwwfHwwfHx8MA%3D%3D",
            title = "Orangutan Rehabilitation",
            description = "A conservation center dedicated to the rehabilitation and preservation of orangutans in Kalimantan.",
            rating = 4.9f,
            location = "Kalimantan, Indonesia",
            price = "800",
            type = "Wildlife Sanctuary",
            category = FakeCategories.categories[4],
            image = listOf(
                "https://images.unsplash.com/photo-1507041957456-9c397ce39c97?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8Zm9yZXN0fGVufDB8fDB8fHww",
                "https://media.istockphoto.com/id/2086523944/photo/footprints-of-friendship.jpg?s=612x612&w=0&k=20&c=n0KO7DMwFsD504jykw8uTmVuSoP8ddaR6F27zYbsJuc=",
                "https://images.unsplash.com/photo-1503435980610-a51f3ddfee50?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8Zm9yZXN0fGVufDB8fDB8fHww",
                ),
            dates = listOf("Year-round"),
            meetingPoints = listOf("Pangkalan Bun"),
            facilities = listOf("Guided Tours", "Educational Workshops"),
            via = "Pangkalan Bun",
            estimation = "Half-day to full-day tour"
        ),
        Destination(
            id = 6,
            thumbnail = "https://plus.unsplash.com/premium_photo-1673603988651-99f79e4ae7d3?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTd8fG5hdHVyZXxlbnwwfHwwfHx8MA%3D%3D",
            title = "Rainforest Expeditions",
            description = "Explore the lush rainforests of Kalimantan with guided tours that offer insights into the rich biodiversity of the region.",
            rating = 4.7f,
            location = "Kalimantan, Indonesia",
            price = "600",
            type = "Rainforest",
            category = FakeCategories.categories[3],
            image = listOf(
                "https://images.unsplash.com/photo-1525431836161-e40d6846e656?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8c3BsYXNofGVufDB8fDB8fHww",
                "https://plus.unsplash.com/premium_photo-1664300792059-863ccfe55932?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Zm9yZXN0fGVufDB8fDB8fHww",
                "https://images.unsplash.com/photo-1477601263568-180e2c6d046e?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8c25vd3xlbnwwfHwwfHx8MA%3D%3D",
                "https://images.unsplash.com/photo-1503435980610-a51f3ddfee50?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8Zm9yZXN0fGVufDB8fDB8fHww",
                "https://images.unsplash.com/photo-1469474968028-56623f02e42e?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fG5hdHVyZXxlbnwwfHwwfHx8MA%3D%3D"
            ),            dates = listOf("Year-round"),
            meetingPoints = listOf("Banjarmasin"),
            facilities = listOf("Guided Tours", "Accommodation"),
            via = "Banjarmasin",
            estimation = "Full-day to multi-day tours"
        )
    )

    val moreArticles = listOf(
        Article(
            id = "342446",
            title = "Adventure Awaits in Sumatra",
            subTitle = "Explore the Untamed Beauty of Sumatra",
            location = "Sumatra, Indonesia",
            thumbnail = "https://images.unsplash.com/photo-1562887520-54d41b6270f1?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
            authorName = "Michael",
            publishedDate = "12 Mar 2024",
            type = "Article",
            description = "Sumatra is a land of adventure and natural beauty. From dense jungles to stunning lakes, discover the best outdoor activities and breathtaking landscapes of this incredible island. With its lush rainforests, towering volcanoes, and vibrant cultures, Sumatra offers a diverse range of experiences for the adventurous traveler. The island’s rich biodiversity and unique landscapes make it a prime destination for nature enthusiasts and thrill-seekers alike.",
            readAlso = null,
            paragraphs = listOf(
                Paragraph(
                    title = "Lake Toba",
                    description = "Lake Toba is a massive volcanic lake surrounded by beautiful scenery. It's an ideal spot for relaxing and exploring the rich culture of the Batak people. The lake, formed by a supervolcanic eruption, is not only one of the largest lakes in the world but also a site of profound cultural significance. Visitors can enjoy tranquil boat rides, explore traditional Batak villages, and experience the natural beauty of this remarkable location.",
                    image = "https://images.unsplash.com/photo-1555308744-6b3f7bb8a9a4?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
                    destination = null
                ),
                Paragraph(
                    title = "Bukit Lawang",
                    description = "Bukit Lawang is a gateway to the Gunung Leuser National Park, famous for its orangutan conservation efforts. Trek through the rainforest and spot these incredible creatures in their natural habitat. The park is one of the largest protected areas in Sumatra, offering a sanctuary for orangutans and other wildlife. The trekking experiences provide a unique opportunity to witness the rainforest ecosystem and engage in conservation efforts.",
                    image = "https://images.unsplash.com/photo-1580667511587-b1b4581869b5?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
                    destination = null
                )
            ),
            moreArticles = listOf()
        ),
        Article(
            id = "342447",
            title = "The Wonders of Komodo Island",
            subTitle = "Discover the Unique Flora and Fauna of Komodo",
            location = "Komodo Island, Indonesia",
            thumbnail = "https://images.unsplash.com/photo-1507659356603-49a86d94d22d?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
            authorName = "Emma",
            publishedDate = "25 Mar 2024",
            type = "Article",
            description = "Komodo Island is home to the famous Komodo dragons and offers some of the most stunning underwater experiences in Indonesia. Explore the unique wildlife and marine life that make this island a must-visit. The island's rugged terrain and diverse marine environments provide excellent opportunities for adventure and wildlife observation. With its combination of unique fauna and beautiful dive sites, Komodo Island is a top destination for nature lovers and thrill-seekers.",
            readAlso = null,
            paragraphs = listOf(
                Paragraph(
                    title = "Komodo Dragons",
                    description = "Encounter the Komodo dragons, the largest lizards in the world, in their natural habitat. Learn about their behavior and conservation efforts. These formidable reptiles are known for their impressive size and strength, and observing them in the wild provides insight into their predatory skills and ecological role. Conservation efforts on the island focus on protecting these iconic creatures and their habitat from various threats.",
                    image = "https://images.unsplash.com/photo-1564246690-c24c8d722f0c?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
                    destination = null
                ),
                Paragraph(
                    title = "Snorkeling and Diving",
                    description = "Komodo Island's surrounding waters are perfect for snorkeling and diving. Explore vibrant coral reefs and diverse marine life in crystal-clear waters. The marine biodiversity in this region includes colorful coral gardens, schools of tropical fish, and the occasional sighting of manta rays and sharks. The underwater experiences complement the island's terrestrial attractions, making it a complete adventure destination.",
                    image = "https://images.unsplash.com/photo-1597820864699-029fb438e8a1?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
                    destination = null
                )
            ),
            moreArticles = listOf()
        ),
        Article(
            id = "342448",
            title = "Exploring the Heart of Kalimantan",
            subTitle = "A Journey Through Kalimantan's Natural Wonders",
            location = "Kalimantan, Indonesia",
            thumbnail = "https://images.unsplash.com/photo-1555043672-3b68a2fd5829?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
            authorName = "Olivia",
            publishedDate = "30 Apr 2024",
            type = "Article",
            description = "Kalimantan, the Indonesian part of Borneo, offers a rich array of natural wonders and wildlife experiences. Discover the rainforests, rivers, and unique species that call this island home. Kalimantan’s diverse landscapes, including its vast rainforests and winding rivers, provide a habitat for a variety of wildlife, including endangered species. Visitors can enjoy river cruises, jungle treks, and cultural experiences that highlight the region’s ecological and cultural significance.",
            readAlso = null,
            paragraphs = listOf(
                Paragraph(
                    title = "Tanjung Puting National Park",
                    description = "Tanjung Puting is known for its orangutan rehabilitation center and pristine rainforest. Take a river cruise to observe wildlife in their natural habitat. The park is a crucial site for orangutan conservation, and the river cruises offer a chance to see these great apes up close. The lush environment and diverse wildlife make it a prime destination for eco-tourism.",
                    image = "https://images.unsplash.com/photo-1572330699742-8b29565e549d?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
                    destination = null
                ),
                Paragraph(
                    title = "Banjarmasin Floating Market",
                    description = "Experience the vibrant floating markets of Banjarmasin, where local traders sell fresh produce and goods from their boats. It's a unique cultural experience. The floating market is a bustling hub of activity, offering a glimpse into traditional trading practices and local life. Visitors can sample local foods, purchase crafts, and enjoy the lively atmosphere of the market.",
                    image = "https://images.unsplash.com/photo-1561868361-8a6243f12264?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
                    destination = null
                )
            ),
            moreArticles = listOf()
        ),
        Article(
            id = "342449",
            title = "Uncovering the Mysteries of Flores",
            subTitle = "Explore the Diverse Landscapes and Cultures of Flores",
            location = "Flores, Indonesia",
            thumbnail = "https://images.unsplash.com/photo-1541439829580-bd8238f53564?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
            authorName = "Sophia",
            publishedDate = "10 May 2024",
            type = "Article",
            description = "Flores offers a blend of unique landscapes and rich cultural experiences. From volcanic craters to traditional villages, discover what makes Flores a hidden gem in Indonesia. The island's diverse terrain includes stunning volcanic formations, traditional cultures, and beautiful coastal areas. Flores is a destination that provides both natural beauty and cultural depth, making it an ideal spot for those seeking an off-the-beaten-path adventure.",
            readAlso = null,
            paragraphs = listOf(
                Paragraph(
                    title = "Kelimutu Volcano",
                    description = "Kelimutu Volcano is renowned for its three colorful crater lakes. Witness the stunning color changes and learn about the volcanic activity that created them. The lakes, known for their vibrant colors that change due to volcanic gases and mineral deposits, are a striking natural phenomenon. The area around the volcano offers hiking opportunities and breathtaking views of the surrounding landscape.",
                    image = "https://images.unsplash.com/photo-1561601125-dbd89fd87e6a?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
                    destination = null
                ),
                Paragraph(
                    title = "Traditional Villages",
                    description = "Explore the traditional villages of Flores, where you can learn about local customs, crafts, and the unique architecture of the region. The villages provide an authentic look into the cultural practices and daily lives of the local people. Visitors can engage with artisans, participate in traditional ceremonies, and appreciate the distinctive architectural styles of the region.",
                    image = "https://images.unsplash.com/photo-1565829609-20ec7f6c2d35?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
                    destination = null
                )
            ),
            moreArticles = listOf()
        ),
        Article(
            id = "342450",
            title = "The Enchantment of Java’s Hidden Temples",
            subTitle = "Discover Lesser-Known Temples and Historical Sites in Java",
            location = "Java, Indonesia",
            thumbnail = "https://images.unsplash.com/photo-1566954355-c8b29b3f8f6e?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
            authorName = "Liam",
            publishedDate = "20 Jun 2024",
            type = "Article",
            description = "Java is home to many remarkable temples beyond the well-known ones. Explore these hidden gems and delve into the rich historical and cultural heritage of the island. The island features a variety of ancient sites that offer insight into Java's past, showcasing unique architectural styles and historical significance. Discovering these lesser-known temples provides a deeper understanding of Java's cultural and religious history.",
            readAlso = null,
            paragraphs = listOf(
                Paragraph(
                    title = "Candi Cetho",
                    description = "Candi Cetho is a lesser-known temple with beautiful mountain views. Its unique architecture and serene surroundings make it a hidden gem. The temple's design reflects a blend of Hindu and Buddhist influences, and its elevated location offers panoramic views of the surrounding landscape. The peaceful atmosphere and historical context of Candi Cetho provide a memorable experience for visitors seeking tranquility and cultural enrichment.",
                    image = "https://images.unsplash.com/photo-1572617597510-0a8488c10f87?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
                    destination = null
                ),
                Paragraph(
                    title = "Candi Sukuh",
                    description = "Candi Sukuh is known for its distinctive pyramid shape and intricate carvings. It's a fascinating site with a unique historical significance. The temple's design and carvings are unlike those of other Javanese temples, featuring elements that hint at both Hindu and Javanese spiritual traditions. The site’s remote location and architectural features make it an intriguing destination for history and architecture enthusiasts.",
                    image = "https://images.unsplash.com/photo-1589699645700-54c43d06d2eb?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
                    destination = null
                )
            ),
            moreArticles = listOf()
        )
    )

    val articles = listOf(
        Article(
            id = "342432",
            title = "Here it is, the Seven Summits in East Java!",
            subTitle = "Discover the Majestic Peaks of East Java",
            location = "East Java, Indonesia",
            thumbnail = "https://images.unsplash.com/photo-1500595046743-cd271d694d30?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1474&q=80",
            authorName = "Adam",
            publishedDate = "8 Dec 2022",
            type = "Article",
            description = "East Java, an enchanting province in Indonesia, boasts an impressive array of mountains known as the Seven Summits. Among them, Mount Semeru stands out as the highest peak, reaching an elevation of 3,676 meters. This majestic volcano is not only the tallest but also a significant landmark in the Bromo Tengger Semeru National Park. Climbing Semeru offers breathtaking views and an unforgettable experience. Raung, another of the Seven Summits, rises to 3,332 meters and is renowned for its rugged terrain and active volcanic nature. This challenging climb is for the adventurous at heart. Mount Arjuno, with its 3,339 meters, provides several routes, including the popular ones from Lawang and Tretes. Butak Mountain, slightly lower at 2,868 meters, is known for its scenic beauty and relatively easier hiking trails. Finally, Welirang, at 3,156 meters, is famed for its sulfur deposits and unique geological features. Exploring these peaks not only offers physical challenges but also a deep connection with East Java’s natural beauty and cultural significance.",
            readAlso = null,
            paragraphs = arrayListOf(
                Paragraph(
                    title = "Semeru Mountain (3676 mdpl)",
                    description = "Mount Semeru is the highest mountain in East Java with an altitude of 3,676 meters above sea level. The peak is named Mahameru and the crater Jonggring Saloko. It offers several climbing routes and is part of the Bromo Tengger Semeru National Park. The climb is challenging but rewarding, with stunning views of the surrounding landscapes and volcanic terrain. It is a popular destination for both seasoned climbers and nature enthusiasts. The park itself is known for its rich biodiversity, including various species of flora and fauna. As you ascend, you’ll encounter diverse ecosystems ranging from tropical forests to alpine meadows. The summit provides a panoramic view that is truly mesmerizing, especially at sunrise. Climbing Semeru is an adventure that combines physical challenge with natural beauty.",
                    image = "https://images.unsplash.com/photo-1500595046743-cd271d694d30?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1474&q=80",
                    destination = destinations[0]
                ),
                Paragraph(
                    title = "Raung Mountain (3332 mdpl)",
                    description = "Mount Raung is an active volcano with an elevation of 3,332 meters. It features rugged terrains and a challenging climbing experience. The ascent is demanding due to the steep inclines and volcanic rock formations. The summit offers a unique view of the surrounding landscape, including other volcanic peaks and lush green valleys. The volcano's activity can also be observed from a safe distance, providing an added thrill for climbers. Raung's rugged beauty and active status make it a fascinating destination for adventurous travelers. The climb requires proper preparation and acclimatization due to the high altitude and harsh conditions. Despite the challenges, the views from the top are incredibly rewarding, offering a sense of accomplishment and connection with the natural world.",
                    image = "https://images.unsplash.com/photo-1682695795255-b236b1f1267d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80",
                    destination = destinations[1]
                ),
                Paragraph(
                    title = "Butak Mountain (2868 mdpl)",
                    description = "Mount Butak, with an elevation of 2,868 meters, offers a different experience compared to the higher peaks of East Java. It is known for its relatively easier hiking trails, making it accessible to a wider range of trekkers. The mountain provides scenic views of the surrounding areas and is a great spot for those looking to enjoy a less strenuous climb. The trails wind through lush forests and open meadows, offering a peaceful retreat from the more challenging climbs. The summit provides a panoramic view of the East Java landscape, including other mountains and volcanic formations. Butak Mountain is ideal for day hikes and is a great introduction to the beauty of East Java’s mountainous terrain.",
                    image = "https://images.unsplash.com/photo-1455348734739-11d7726c3c80?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1548&q=80",
                    destination = null
                ),
                Paragraph(
                    title = "Welirang Mountain (3156 mdpl)",
                    description = "Mount Welirang, reaching 3,156 meters, is famous for its sulfur deposits and volcanic activity. The mountain's unique geological features include fumaroles and sulfur vents, providing a fascinating landscape for visitors. The climb to the summit involves navigating through rugged terrain and volcanic rock, making it a more challenging hike. However, the views and the opportunity to observe volcanic phenomena make it a worthwhile endeavor. The surrounding area is rich in biodiversity, with various plant and animal species adapted to the volcanic environment. The ascent offers a glimpse into the dynamic processes shaping the Earth's surface. Welirang is a significant peak in East Java's volcanic landscape, combining natural beauty with geological intrigue.",
                    image = "https://images.unsplash.com/photo-1473221902860-45c5abc981a7?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1548&q=80",
                    destination = destinations[4]
                )
            ),
            moreArticles = moreArticles
        ),
        Article(
            id = "342433",
            title = "The Ancient Temples of Yogyakarta",
            subTitle = "Exploring the Historical Wonders of Central Java",
            location = "Yogyakarta, Indonesia",
            thumbnail = "https://images.unsplash.com/photo-1506748686214e9df14f9?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
            authorName = "Lisa",
            publishedDate = "15 Jan 2023",
            type = "Article",
            description = "Yogyakarta, a city rich in history and culture, is home to some of Indonesia's most significant ancient temples. The Borobudur Temple, a UNESCO World Heritage site, is the largest Buddhist temple in the world. Built in the 9th century, this magnificent structure features over 500 Buddha statues and intricate carvings that depict Buddhist cosmology. The temple's grandeur is complemented by its serene surroundings, making it a popular destination for both spiritual seekers and history enthusiasts. Nearby, the Prambanan Temple stands as a testament to Hindu architectural prowess. This complex, dating back to the 9th century as well, is renowned for its towering spires and elaborate carvings dedicated to the Trimurti: Brahma, Vishnu, and Shiva. The interplay of Hindu and Buddhist influences in these temples reflects the rich cultural tapestry of ancient Java. Visitors to Yogyakarta can explore these awe-inspiring sites, gaining insights into Indonesia's diverse religious heritage and architectural brilliance.",
            readAlso = null,
            paragraphs = arrayListOf(
                Paragraph(
                    title = "Borobudur Temple",
                    description = "Borobudur Temple is a marvel of ancient architecture and artistry, considered one of the greatest Buddhist monuments in the world. Built during the reign of the Sailendra Dynasty, it features nine stacked platforms topped by a central dome. The temple's base is adorned with reliefs depicting various Jataka tales, while the upper levels present a series of stupas that symbolize enlightenment. Visitors can walk around the temple, observing the intricate carvings and enjoying the panoramic views of the surrounding landscape. The temple's location amidst lush greenery and volcanic mountains adds to its mystical aura. As one of Indonesia’s most visited tourist attractions, Borobudur also plays a significant role in the local community’s cultural and spiritual life. The temple is a focal point for major Buddhist celebrations and attracts pilgrims from around the world.",
                    image = "https://images.unsplash.com/photo-1506748686214e9df14f9?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
                    destination = destinations[3]
                ),
                Paragraph(
                    title = "Prambanan Temple",
                    description = "Prambanan Temple is an exquisite example of Hindu temple architecture in Indonesia, built during the reign of the Sanjaya Dynasty. The temple complex is dedicated to the Trimurti and comprises a series of towering spires surrounded by smaller shrines. The central temple is dedicated to Shiva, flanked by temples dedicated to Vishnu and Brahma. The intricate carvings on the walls depict scenes from the Ramayana and the Bhagavata Purana, providing a glimpse into Hindu mythology and religious practices. The grandeur of Prambanan Temple is complemented by its well-maintained gardens and the scenic backdrop of Mount Merapi. The temple's design and its historical significance make it a prominent destination for those interested in the cultural and religious heritage of Java. The complex also hosts various cultural events and performances, adding to the vibrant atmosphere of the site.",
                    image = "https://images.unsplash.com/photo-1562697596-6e4389a092fc?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
                    destination = destinations[1]
                ),
                Paragraph(
                    title = "Ratu Boko Palace",
                    description = "The Ratu Boko Palace, located near Yogyakarta, is an ancient site with historical and archaeological significance. The palace complex dates back to the 8th century and is believed to have served as a royal residence and administrative center. The ruins include several large gates, terraces, and a series of stone structures that provide insight into the architectural styles and urban planning of the time. The palace's elevated position offers stunning views of the surrounding landscape, including the nearby temples of Borobudur and Prambanan. Exploring the Ratu Boko site provides a deeper understanding of Java's royal history and the grandeur of ancient Javanese civilization. The serene atmosphere and historical ambiance make it a popular spot for visitors interested in the rich heritage of Yogyakarta.",
                    image = "https://images.unsplash.com/photo-1588161494412-dfb5ae3b0421?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
                    destination = destinations[3]
                )
            ),
            moreArticles = moreArticles
        ),
        Article(
            id = "342434",
            title = "Komodo Dragons: Giants of the Reptile World",
            subTitle = "A Closer Look at the World's Largest Lizards",
            location = "Komodo Island, Indonesia",
            thumbnail = "https://images.unsplash.com/photo-1564512818-7cde1d7f0f6a?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
            authorName = "David",
            publishedDate = "20 Feb 2023",
            type = "Article",
            description = "Komodo Island, part of the Indonesian archipelago, is renowned for being the natural habitat of the Komodo dragon, the largest living lizard on Earth. These formidable reptiles can grow up to 3 meters in length and weigh as much as 70 kilograms. Their powerful build and scavenging habits make them top predators in their environment. The Komodo dragons primarily feed on large prey, including deer and wild boar, and their impressive hunting skills are complemented by their keen sense of smell. The island's unique ecosystem supports a diverse range of wildlife, and the dragons play a crucial role in maintaining ecological balance. Visiting Komodo Island provides an opportunity to observe these extraordinary creatures up close while also exploring the island’s rugged landscapes and pristine beaches. Guided tours ensure that visitors can safely appreciate the dragons' natural behavior and learn about ongoing conservation efforts aimed at protecting these incredible animals.",
            readAlso = null,
            paragraphs = arrayListOf(
                Paragraph(
                    title = "Komodo Dragon Habitat",
                    description = "Komodo dragons inhabit several islands in Indonesia, including Komodo Island, Rinca Island, and a few smaller islands within the Komodo National Park. These lizards thrive in a diverse range of habitats, from dry savannas to tropical forests. Their adaptation to such environments has made them resilient and formidable predators. The unique geology and climate of these islands contribute to the Komodo dragon's survival, providing them with ample food sources and suitable living conditions. The islands are part of a conservation area that aims to protect the habitat of these dragons and the other wildlife that shares their ecosystem. Visiting these islands offers a rare glimpse into the lives of these ancient reptiles and the opportunity to witness their behavior in the wild. The park's commitment to conservation efforts helps ensure the survival of the Komodo dragons and the preservation of their natural habitat.",
                    image = "https://images.unsplash.com/photo-1532574526758-b6017267514d?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
                    destination = destinations[5]
                ),
                Paragraph(
                    title = "Guided Tours",
                    description = "To fully experience Komodo Island and observe the Komodo dragons safely, guided tours are highly recommended. These tours are led by experienced local guides who are knowledgeable about the dragons' behavior, the island's ecology, and conservation practices. The guides ensure that visitors follow safety protocols while providing educational insights into the lives of these magnificent reptiles. During the tour, visitors may also encounter other wildlife species such as water buffaloes and various bird species. The tours often include treks through the island’s diverse landscapes, including volcanic hills and beautiful beaches. The guides are trained to handle interactions with the dragons carefully, ensuring that both visitors and animals are safe. By participating in these guided tours, visitors contribute to the ongoing conservation efforts and gain a deeper understanding of the natural world and the importance of preserving it.",
                    image = "https://images.unsplash.com/photo-1564512818-7cde1d7f0f6a?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
                    destination = destinations[2]
                )
            ),
            moreArticles = moreArticles
        ),
        Article(
            id = "342435",
            title = "The Majestic Komodo Dragons",
            subTitle = "Encountering the World's Largest Lizard",
            location = "Komodo Island, Indonesia",
            thumbnail = "https://images.unsplash.com/photo-1525975964178-7c10c2282a4e?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
            authorName = "John",
            publishedDate = "5 Mar 2023",
            type = "Article",
            description = "Komodo Island is home to the famous Komodo dragons, the largest lizards in the world. A visit to this island offers an unforgettable wildlife experience.",
            readAlso = null,
            paragraphs = arrayListOf(
                Paragraph(
                    title = "Komodo Dragon Habitat",
                    description = "Komodo dragons are found in their natural habitat on Komodo Island, Rinca Island, and a few other smaller islands. They are known for their size, strength, and unique appearance.",
                    image = "https://images.unsplash.com/photo-1532574526758-b6017267514d?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
                    destination = destinations[5]
                ),
                Paragraph(
                    title = "Guided Tours",
                    description = "Explore Komodo Island with guided tours to safely observe these giant reptiles and learn about their behavior and conservation efforts.",
                    image = "https://images.unsplash.com/photo-1564512818-7cde1d7f0f6a?ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1500&q=80",
                    destination = destinations[0]
                )
            ),
            moreArticles = moreArticles
        )
    )

}

