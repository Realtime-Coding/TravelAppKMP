package ui.viewmodel

import androidx.lifecycle.ViewModel
import data.FakeCategories
import data.FakeDestinations
import data.FakeFavorites
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import model.Category
import model.Destination

class HomeViewModel : ViewModel() {
    private val _destinations = MutableStateFlow(FakeDestinations.destinations)
    val destinations: StateFlow<ArrayList<Destination>> = _destinations.asStateFlow()

    private val _categories = MutableStateFlow(FakeCategories.categories)
    val categories: StateFlow<ArrayList<Category>> = _categories.asStateFlow()

    private val _favorites = MutableStateFlow(FakeFavorites.favorites)
    val favorites: StateFlow<MutableList<Destination>> = _favorites.asStateFlow()

    private val _bottomNavBarVisible = MutableStateFlow(true)
    val bottomNavBarVisible: StateFlow<Boolean> = _bottomNavBarVisible.asStateFlow()

    fun setBottomNavBarVisible(value: Boolean) {
        _bottomNavBarVisible.update { value }
    }

    fun checkFavorite(destination: Destination) = FakeFavorites.favorites.any { it == destination }

    fun addFavorite(destination: Destination) {
        FakeFavorites.favorites.add(destination)
    }

    fun removeFavorite(destination: Destination){
        if (checkFavorite(destination)) {
            FakeFavorites.favorites.remove(destination)
        }
    }


}