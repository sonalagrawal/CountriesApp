package com.walmart.countriesapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.walmart.countriesapp.CountryRepository
import com.walmart.countriesapp.CountryViewModel

class CountryViewModelFactory(
    private val countryRepository: CountryRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CountryViewModel(countryRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
