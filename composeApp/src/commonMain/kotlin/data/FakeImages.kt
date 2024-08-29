package data

import kotlin.random.Random

object FakeImages {
        fun randomThumbnailUrl(random: Int = 3) = thumbnailsUrls.shuffled(Random).take(random).first()
        fun randomImageUrl(random: Int = 3) = imageUrls.shuffled(Random).take(random).first()
        fun randomImageUrls(random: Int = 4) = imageUrls.shuffled(Random).take(random)

        val thumbnailsUrls = listOf(
            "https://plus.unsplash.com/premium_photo-1670148434900-5f0af77ba500?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8c3BsYXNofGVufDB8fDB8fHww",
            "https://images.unsplash.com/photo-1525431836161-e40d6846e656?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8c3BsYXNofGVufDB8fDB8fHww",
            "https://media.istockphoto.com/id/1954840203/photo/businessman-holding-green-scrap-paper-ball-with-world-map-and-environment-icon-such-as-carbon.webp?b=1&s=612x612&w=0&k=20&c=RH3KRhXeEnJxEM838wb716lPQlQnUtLW4BDq1_8E5v0=",
            "https://media.istockphoto.com/id/1474101168/photo/drone-view-on-rocks-and-canoes-floating-on-turquoise-water-in-the-halong-bay-vietnam.webp?b=1&s=612x612&w=0&k=20&c=61AIF3YY7ZaJZPw8LzLIdwAfcnDyZgkb3ZoHEoN5t1g=",
            "https://images.unsplash.com/photo-1469474968028-56623f02e42e?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fG5hdHVyZXxlbnwwfHwwfHx8MA%3D%3D",
            "https://plus.unsplash.com/premium_photo-1673603988651-99f79e4ae7d3?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTd8fG5hdHVyZXxlbnwwfHwwfHx8MA%3D%3D",
            "https://images.unsplash.com/photo-1519865885898-a54a6f2c7eea?q=80&w=3458&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1682685794761-c8e7b2347702?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80",
            "https://images.unsplash.com/photo-1500595046743-cd271d694d30?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1474&q=80",
            "https://images.unsplash.com/photo-1682687220198-88e9bdea9931?ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80",
            "https://images.unsplash.com/photo-1682685797365-6f57bbebffed?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDJ8RnpvM3p1T0hONnd8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1683009427041-d810728a7cb6?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDN8RnpvM3p1T0hONnd8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1682686580391-615b1f28e5ee?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDZ8RnpvM3p1T0hONnd8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1707343843437-caacff5cfa74?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDF8RnpvM3p1T0hONnd8fGVufDB8fHx8fA%3D%3D",
            "https://plus.unsplash.com/premium_photo-1669640020567-ef5248fbd116?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDl8RnpvM3p1T0hONnd8fGVufDB8fHx8fA%3D%3D",
            "https://plus.unsplash.com/premium_photo-1720188548716-9de4d2911fff?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDR8RnpvM3p1T0hONnd8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1682687219640-b3f11f4b7234?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDExfEZ6bzN6dU9ITjZ3fHxlbnwwfHx8fHw%3D",
            "https://images.unsplash.com/photo-1682687981630-cefe9cd73072?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDEwfEZ6bzN6dU9ITjZ3fHxlbnwwfHx8fHw%3D",
            "https://images.unsplash.com/photo-1682686580922-2e594f8bdaa7?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDd8RnpvM3p1T0hONnd8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1723532422505-e8ded8bf148b?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDEzfEZ6bzN6dU9ITjZ3fHxlbnwwfHx8fHw%3D",
            "https://images.unsplash.com/photo-1676104813416-693d204f76c6?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDE0fEZ6bzN6dU9ITjZ3fHxlbnwwfHx8fHw%3D",
            "https://images.unsplash.com/photo-1724449284243-28a44fe5f3ab?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDE3fEZ6bzN6dU9ITjZ3fHxlbnwwfHx8fHw%3D",
            "https://plus.unsplash.com/premium_photo-1724596851792-189dd8ebf3c3?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDE1fEZ6bzN6dU9ITjZ3fHxlbnwwfHx8fHw%3D",
            "https://images.unsplash.com/photo-1724406134629-15dd96ed6039?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDE4fEZ6bzN6dU9ITjZ3fHxlbnwwfHx8fHw%3D",
        )
        val mountBromoImages = arrayOf(
            "https://plus.unsplash.com/premium_photo-1670148434900-5f0af77ba500?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8c3BsYXNofGVufDB8fDB8fHww",
            "https://images.unsplash.com/photo-1503435980610-a51f3ddfee50?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8Zm9yZXN0fGVufDB8fDB8fHww",
            "https://images.unsplash.com/photo-1476231682828-37e571bc172f?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8Zm9yZXN0fGVufDB8fDB8fHww"
        )

        val semeruImages = arrayOf(
            "https://images.unsplash.com/photo-1525431836161-e40d6846e656?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8c3BsYXNofGVufDB8fDB8fHww",
            "https://plus.unsplash.com/premium_photo-1664300792059-863ccfe55932?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Zm9yZXN0fGVufDB8fDB8fHww",
            "https://images.unsplash.com/photo-1477601263568-180e2c6d046e?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8c25vd3xlbnwwfHwwfHx8MA%3D%3D"
        )

        val nusaPenidaImages = arrayOf(
            "https://media.istockphoto.com/id/1954840203/photo/businessman-holding-green-scrap-paper-ball-with-world-map-and-environment-icon-such-as-carbon.webp?b=1&s=612x612&w=0&k=20&c=RH3KRhXeEnJxEM838wb716lPQlQnUtLW4BDq1_8E5v0=",
            "https://images.unsplash.com/photo-1507041957456-9c397ce39c97?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8Zm9yZXN0fGVufDB8fDB8fHww",
            "https://media.istockphoto.com/id/2086523944/photo/footprints-of-friendship.jpg?s=612x612&w=0&k=20&c=n0KO7DMwFsD504jykw8uTmVuSoP8ddaR6F27zYbsJuc="
        )

        val nusaLembonganImages = arrayOf(
            "https://media.istockphoto.com/id/1474101168/photo/drone-view-on-rocks-and-canoes-floating-on-turquoise-water-in-the-halong-bay-vietnam.webp?b=1&s=612x612&w=0&k=20&c=61AIF3YY7ZaJZPw8LzLIdwAfcnDyZgkb3ZoHEoN5t1g=",
            "https://images.unsplash.com/photo-1503435980610-a51f3ddfee50?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8Zm9yZXN0fGVufDB8fDB8fHww",
            "https://images.unsplash.com/photo-1469474968028-56623f02e42e?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fG5hdHVyZXxlbnwwfHwwfHx8MA%3D%3D",
            "https://media.istockphoto.com/id/1437124828/photo/car-tyre-on-a-snowy-road-in-winter.webp?b=1&s=612x612&w=0&k=20&c=G0zXf-oZWU5AAuUDYfh-WS9uWKHpBmKQOmMWLRVEftQ="
        )

        val orangutanRehabilitationImages = arrayOf(
            "https://images.unsplash.com/photo-1507041957456-9c397ce39c97?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8Zm9yZXN0fGVufDB8fDB8fHww",
            "https://media.istockphoto.com/id/2086523944/photo/footprints-of-friendship.jpg?s=612x612&w=0&k=20&c=n0KO7DMwFsD504jykw8uTmVuSoP8ddaR6F27zYbsJuc=",
            "https://images.unsplash.com/photo-1503435980610-a51f3ddfee50?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8Zm9yZXN0fGVufDB8fDB8fHww"
        )

        val rainforestExpeditionsImages = arrayOf(
            "https://images.unsplash.com/photo-1525431836161-e40d6846e656?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8c3BsYXNofGVufDB8fDB8fHww",
            "https://plus.unsplash.com/premium_photo-1664300792059-863ccfe55932?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Zm9yZXN0fGVufDB8fDB8fHww",
            "https://images.unsplash.com/photo-1477601263568-180e2c6d046e?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8c25vd3xlbnwwfHwwfHx8MA%3D%3D",
            "https://images.unsplash.com/photo-1503435980610-a51f3ddfee50?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8Zm9yZXN0fGVufDB8fDB8fHww",
            "https://images.unsplash.com/photo-1469474968028-56623f02e42e?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fG5hdHVyZXxlbnwwfHwwfHx8MA%3D%3D"
        )

        val imageUrls = listOf(
            "https://plus.unsplash.com/premium_photo-1674228288323-3bfbae70ad45?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1587&q=80",
            "https://images.unsplash.com/photo-1689714321677-a914620d6b76?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1600&q=80",
            "https://images.unsplash.com/photo-1612253166766-c88431cdadee?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1587&q=80",
            "https://images.unsplash.com/photo-1533305120462-aed774147024?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80",
            "https://images.unsplash.com/photo-1690315854810-dfeb1c763c27?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80",
            "https://images.unsplash.com/photo-1690205073996-7fde74f5fd56?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80",
            "https://images.unsplash.com/photo-1682687221175-fd40bbafe6ca?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDF8fHxlbnwwfHx8fHw%3D&auto=format&fit=crop&w=900&q=60",
            "https://images.unsplash.com/photo-1455348734739-11d7726c3c80?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1548&q=80",
            "https://images.unsplash.com/photo-1473221902860-45c5abc981a7?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1548&q=80",
            "https://www.linkpicture.com/q/vladimir-haltakov-PMfuunAfF2w-unsplash.jpg",
            "https://images.unsplash.com/photo-1682686580024-580519d4b2d2?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDExfHx8ZW58MHx8fHx8&auto=format&fit=crop&w=900&q=60",
            "https://images.unsplash.com/photo-1682686578289-cf9c8c472c9b?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80",
            "https://images.unsplash.com/photo-1682695794816-7b9da18ed470?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80",
            "https://images.unsplash.com/photo-1682695795255-b236b1f1267d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80",
            "https://images.unsplash.com/photo-1723309552998-785d257747d1?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDIwfEZ6bzN6dU9ITjZ3fHxlbnwwfHx8fHw%3D",
            "https://images.unsplash.com/photo-1723126004556-4ecfcbab3908?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDIyfEZ6bzN6dU9ITjZ3fHxlbnwwfHx8fHw%3D",
            "https://images.unsplash.com/photo-1723920521478-06afc140103b?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDE5fEZ6bzN6dU9ITjZ3fHxlbnwwfHx8fHw%3D",
            "https://images.unsplash.com/photo-1718287888958-efa8b9c8375a?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDI3fEZ6bzN6dU9ITjZ3fHxlbnwwfHx8fHw%3D",
            "https://images.unsplash.com/photo-1724075683150-365324dfe146?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDI4fEZ6bzN6dU9ITjZ3fHxlbnwwfHx8fHw%3D",
            "https://images.unsplash.com/photo-1724322727370-da4b1fcd8fc0?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDMyfEZ6bzN6dU9ITjZ3fHxlbnwwfHx8fHw%3D",
            "https://images.unsplash.com/photo-1724301421722-50e65d9ab395?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDI2fEZ6bzN6dU9ITjZ3fHxlbnwwfHx8fHw%3D",
            "https://images.unsplash.com/photo-1724287772442-913a1f2dc0e0?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDM2fEZ6bzN6dU9ITjZ3fHxlbnwwfHx8fHw%3D",
            "https://images.unsplash.com/photo-1661697619862-2e603e40ed30?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDM4fEZ6bzN6dU9ITjZ3fHxlbnwwfHx8fHw%3D",
            "https://images.unsplash.com/photo-1724256884872-866750ebb123?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDM0fEZ6bzN6dU9ITjZ3fHxlbnwwfHx8fHw%3D",
            "https://images.unsplash.com/photo-1717267735436-0ac88b6d2035?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8Nnx8fGVufDB8fHx8fA%3D%3D",
            "https://plus.unsplash.com/premium_photo-1686116332206-cd9f68ef78bc?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8OHx8fGVufDB8fHx8fA%3D%3D",
            "https://images.unsplash.com/photo-1717321302149-3c6c9c76de67?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8MTF8fHxlbnwwfHx8fHw%3D",
            "https://images.unsplash.com/photo-1717105885274-cdd03a56f69c?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8MTV8fHxlbnwwfHx8fHw%3D",
            "https://plus.unsplash.com/premium_photo-1675531020486-1a8bd1b1c7f2?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8MjB8fHxlbnwwfHx8fHw%3D",
            "https://images.unsplash.com/photo-1715353500115-51fce92308d5?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8MTl8fHxlbnwwfHx8fHw%3D"
        ) + semeruImages + mountBromoImages + nusaLembonganImages + nusaPenidaImages + orangutanRehabilitationImages + rainforestExpeditionsImages

}