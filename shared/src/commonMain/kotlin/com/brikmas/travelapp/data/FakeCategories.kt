package com.brikmas.travelapp.data

import com.brikmas.travelapp.SharedRes
import com.brikmas.travelapp.model.Category

object FakeCategories {

    val categories = arrayListOf<Category>().apply {
        add(Category(0, "All", SharedRes.images.star))
        add(Category(1, "Mountain", SharedRes.images.category1))
        add(Category(2, "Waterfall", SharedRes.images.category2))
        add(Category(3, "River", SharedRes.images.category3))
        add(Category(4, "Lake", SharedRes.images.category4))
    }

}
