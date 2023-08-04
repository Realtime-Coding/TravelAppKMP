package com.brikmas.travelapp.data

import com.brikmas.travelapp.model.Destination

object FakeFavorites {
    val favorites = mutableListOf<Destination>()

    fun checkFavorite(destination: Destination) = favorites.any { it == destination }
    fun addFavorite(destination: Destination) {
        favorites.add(destination)
    }

    fun removeFavorite(destination: Destination){
        if (checkFavorite(destination)) {
            favorites.remove(destination)
        }
    }
}