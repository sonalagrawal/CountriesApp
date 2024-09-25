package com.walmart.countriesapp

/**
 * Sealed class representing the result of a data operation.
 */
sealed class CountriesResult {
    /** Represents a loading state when data is being fetched. */
    data object Loading : CountriesResult()

    /**
     * Represents a successful data retrieval.
     *
     * @property countries The list of countries retrieved.
     */
    data class Success(val countries: List<Country>) : CountriesResult()

    /**
     * Represents an error that occurred during data retrieval.
     *
     * @property message The error message describing the issue.
     */
    data class Error(val message: String) : CountriesResult()
}
