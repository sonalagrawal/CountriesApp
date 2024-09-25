package com.walmart.countriesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.walmart.countriesapp.ui.CountryViewModelFactory

// MainActivity class that serves as the entry point of the application
class MainActivity : ComponentActivity() {
    // ViewModel to manage UI-related data in a lifecycle-conscious way
    private val countryViewModel: CountryViewModel by viewModels {
        CountryViewModelFactory(RetrofitInstance.api)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fetch the list of countries from the ViewModel
        countryViewModel.fetchCountries()

        // Find the RecyclerView by its ID from the layout
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        // Set the layout manager for the RecyclerView to arrange items in a vertical list
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe the countries LiveData from the ViewModel
        countryViewModel.countriesLiveData.observe(this) { state ->
            when (state) {
                is CountriesResult.Loading -> {
                    println("Show Progress bar")
                    // Show a loading indicator
                    // Example: progressBar.visibility = View.VISIBLE
                }

                is CountriesResult.Success -> {
                    // When the countries data changes, set the adapter for the RecyclerView
                    recyclerView.adapter = CountryAdapter(state.countries)
                }

                is CountriesResult.Error -> {
                    println(" Error in fetching user profile")
                    // Hide loading indicator and show an error message
                }

                else -> {}
            }
        }
    }
}
