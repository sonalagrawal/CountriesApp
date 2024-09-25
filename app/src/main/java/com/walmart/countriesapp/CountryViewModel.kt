package com.walmart.countriesapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import android.util.Log

class CountryViewModel(private val countryRepository: CountryRepository) : ViewModel() {
    // LiveData for holding the list of countries
    private val _countriesLiveData = MutableLiveData<CountriesResult>()
    val countriesLiveData: LiveData<CountriesResult> = _countriesLiveData

    // Function to fetch countries from the API
    fun fetchCountries() {
        _countriesLiveData.value = CountriesResult.Loading // Set loading state
        viewModelScope.launch {
            try {
                // Fetch countries and update LiveData
                val countries = countryRepository.getCountries()
                _countriesLiveData.value = CountriesResult.Success(countries)
            } catch (e: Exception) {
                // Log the error and post the error message
                Log.e("CountryViewModel", "Failed to load countries: ${e.message}", e)
                _countriesLiveData.value = CountriesResult.Error("Failed to load profile ${e.message}")
            }
        }
    }
}
