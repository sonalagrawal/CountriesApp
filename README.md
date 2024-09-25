# CountriesApp

## Overview

CountriesApp is an Android application that fetches and displays a list of countries in a user-friendly format. The data is retrieved from a public JSON endpoint and presented in a RecyclerView, allowing users to scroll through the entire list of countries. Each entry showcases the country's name, region, code, and capital.

## Features
- Fetches a list of countries in JSON format from the following URL:
  [Countries JSON Data](https://gist.githubusercontent.com/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json)
- Displays each country's information in a structured layout including fields "name", "region" "code" and "capital".
- Supports device rotation and handles errors and edge cases gracefully.

## Installation

**1.** Clone the repository:
 git clone <repository-url>
 cd CountriesApp
 
**2.** Open the project in Android Studio.

**3.** Build and run the application on an Android device or emulator.


## Implementation Details

* **Data Fetching:** Utilizes Kotlin Coroutines for asynchronous network calls.
* **UI:** A RecyclerView is used to display the list of countries.
* **Error Handling:** Robust error handling is implemented to manage network failures and data parsing issues.
* **Architecture:** Follows clean architecture principles to ensure separation of concerns and maintainability.

## Design Patterns

* MVVM (Model-View-ViewModel) pattern is employed for better UI handling and data management.
* Repository pattern is used to abstract data sources and provide a clean API for data access.
  
## Limitations

* This application does not use Jetpack Compose or Dagger, adhering to the specified requirements.
  
## Contribution

Contributions are welcome! If you have suggestions or improvements, please create a pull request or open an issue.
