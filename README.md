# Ultimate News

![Ultimate News](https://img.shields.io/badge/version-1.0-blue.svg)
![Ultimate News](https://img.shields.io/badge/platform-Android-green.svg)
![Ultimate News](https://img.shields.io/badge/architecture-Clean%20Architecture-brightgreen.svg)
![Ultimate News](https://img.shields.io/badge/compose-Jetpack%20Compose-orange.svg)
![Ultimate News](https://img.shields.io/badge/DI-Hilt-yellow.svg)

Welcome to **Ultimate News**, an Android application built with a clean architecture approach using Jetpack Compose. This app fetches news articles from the News API and displays them in a user-friendly interface.

## Features

- **Jetpack Compose**: Modern toolkit for building native UI.
- **Clean Architecture**: Separation of concerns, making the app modular, scalable, and maintainable.
- **Dependency Injection**: Hilt for managing dependencies.
- **Paging**: Efficient loading of large data sets.
- **Room Database**: Local data persistence.
- **Retrofit**: For network requests.
- **Coil**: Image loading library.

## Getting Started

### Prerequisites

Ensure you have the following installed:

- Android Studio Dolphin | 2021.3.1 or later
- JDK 11 or higher

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/ahmedsiddique01/UltimateNews.git
    ```
2. Open the project in Android Studio.
3. Sync the project with Gradle files.
4. Run the application on an emulator or a physical device.

### Configuration

The app uses the News API. You can set up different API keys for different build flavors:

```gradle
productFlavors {
    dev {
        dimension = "version"
        buildConfigField("String", "BASE_URL", "\"https://newsapi.org/v2/\"")
        buildConfigField("String", "API_KEY", "\"your_dev_api_key_here\"")
    }
    prod {
        dimension = "version"
        buildConfigField("String", "BASE_URL", "\"https://newsapi.org/v2/\"")
        buildConfigField("String", "API_KEY", "\"your_prod_api_key_here\"")
    }
}
```

Replace `your_dev_api_key_here` and `your_prod_api_key_here` with your actual API keys.

## Project Structure

The project follows Clean Architecture principles:

- **domain**: Business logic and use cases.
- **data**: Repository implementations, data sources, and models.
- **presentation**: ViewModels, Composables, and UI-related classes.
## Dependencies

- **Jetpack Compose**: Modern UI toolkit.
- **Hilt**: Dependency Injection.
- **Retrofit**: Networking library.
- **Room**: Database library.
- **Paging**: For handling large lists of data.
- **Coil**: Image loading.

## Contributing

Contributions are welcome! Please fork this repository and submit a pull request with your changes.

1. Fork it
2. Create your feature branch (`git checkout -b feature/YourFeature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin feature/YourFeature`)
5. Create a new Pull Request

## Acknowledgements

- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [News API](https://newsapi.org/)
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)

---

Feel free to replace placeholder URLs and add any additional information or sections as needed.
