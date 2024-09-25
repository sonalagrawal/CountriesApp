package com.walmart.countriesapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// Interface defining the methods for fetching country data
interface CountryRepository {
    // Endpoint for fetching country data.
    @GET(COUNTRIES_ENDPOINT)
    suspend fun getCountries(): List<Country>

    companion object {
        // URL for fetching country data
        private const val COUNTRIES_ENDPOINT = "peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json"
    }
}

// Object responsible for creating a Retrofit instance
object RetrofitInstance {
    // Base URL for the API requests
    private const val BASE_URL = "https://gist.githubusercontent.com/"

    // Lazy initialization of the Retrofit API instance
    val api: CountryRepository by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)  // Set the base URL for the API
            .addConverterFactory(GsonConverterFactory.create()) // Add Gson converter for JSON parsing
            .build() // Build the Retrofit instance
            .create(CountryRepository::class.java) // Create an instance of the CountryRepository interface
    }
}
