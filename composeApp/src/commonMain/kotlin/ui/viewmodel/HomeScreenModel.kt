package ui.viewmodel

import cafe.adriel.voyager.core.model.ScreenModel
import data.FakeCart
import data.FakeCategories
import data.FakeDestinations
import data.FakeFavorites
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import model.Category
import model.Destination

class HomeScreenModel : ScreenModel {
    private val _destinations = MutableStateFlow(FakeDestinations.destinations)
    val destinations: StateFlow<ArrayList<Destination>> = _destinations.asStateFlow()

    private val _categories = MutableStateFlow(FakeCategories.categories)
    val categories: StateFlow<ArrayList<Category>> = _categories.asStateFlow()

    private val _favorites = MutableStateFlow(FakeFavorites.favorites)
    val favorites: StateFlow<MutableList<Destination>> = _favorites.asStateFlow()

    private val _cartItems = MutableStateFlow(FakeCart.cartItems)
    val cartItems: StateFlow<MutableList<Destination>> = _cartItems.asStateFlow()

    private val _bottomNavBarVisible = MutableStateFlow(true)
    val bottomNavBarVisible: StateFlow<Boolean> = _bottomNavBarVisible.asStateFlow()

    private val _navigateToGemini = MutableStateFlow<Pair<Boolean, Destination?>>(Pair(false, null))
    val navigateToGemini: StateFlow<Pair<Boolean, Destination?>> = _navigateToGemini.asStateFlow()


    fun setBottomNavBarVisible(value: Boolean) {
        _bottomNavBarVisible.update { value }
    }

    fun checkFavorite(destination: Destination) = FakeFavorites.favorites.any { it == destination }

    fun checkCartItem(destination: Destination) = FakeCart.cartItems.any { it == destination }


    fun addFavorite(destination: Destination) {
        FakeFavorites.favorites.add(destination)
    }

    fun removeFavorite(destination: Destination){
        if (checkFavorite(destination)) {
            FakeFavorites.favorites.remove(destination)
        }
    }

    fun addToCart(destination: Destination) {
        FakeCart.cartItems.add(destination)
    }

    fun removeFromCart(destination: Destination){
        if (checkCartItem(destination)) {
            FakeCart.cartItems.remove(destination)
        }
    }

    fun navigateToGimini(value: Pair<Boolean, Destination?>) {
        _navigateToGemini.value = value
    }

}