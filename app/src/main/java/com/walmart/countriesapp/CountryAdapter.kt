package com.walmart.countriesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter class to bind country data to the RecyclerView
class CountryAdapter(private val countries: List<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    // ViewHolder class to hold references to the views for each item
    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // TextViews to display the country's name, region, code, and capital
        val countryNameAndRegion: TextView = itemView.findViewById(R.id.text_country_region)
        val countryCode: TextView = itemView.findViewById(R.id.text_country_code)
        val countryCapital: TextView = itemView.findViewById(R.id.text_country_capital)
    }

    // Creates a new ViewHolder when there are no existing ViewHolders available
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        // Inflate the layout for an individual country item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        // Return a new ViewHolder instance containing the inflated view
        return CountryViewHolder(view)
    }

    // Binds data to the views in the ViewHolder for a specific position
    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        // Get the country data for the current position
        val country = countries[position]

        // Use context resources to format the string for displaying country name and region
        holder.countryNameAndRegion.text = holder.itemView.context.getString(R.string.country_name_region_format, country.name, country.region)

        // Set the country code and capital in their respective TextViews
        holder.countryCode.text = country.code
        holder.countryCapital.text = country.capital
    }

    // Returns the total number of items in the data set held by the adapter
    override fun getItemCount(): Int = countries.size
}
