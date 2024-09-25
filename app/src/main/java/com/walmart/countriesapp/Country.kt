package com.walmart.countriesapp
/**
 * Data class representing a country.
 *
 * @property capital The capital city of the country.
 * @property code The ISO code of the country.
 * @property name The name of the country.
 * @property region The geographical region the country belongs to.
 */
data class Country(
    val capital: String,
    val code: String,
    val name: String,
    val region: String,
)
