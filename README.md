# Stockbit Example App
is an application used to view crypto data

## Architecture
As of now, this project use MVVM for it's presentation layer pattern

### Project Structure
```
com.stockbit.hiring     # Root Package
    .
    ├── common          # Base class
    │   └── base
    │                   
    ├── common_test     # Test Class
    │
    ├── data            # Data layer
    │   ├── local       # Room Database
    │   ├── remote      # Network api services
    │   ├── repository  # Repository by feature
    │   └── model       # Singular model for all layer
    │                       # Should be separated into each respective layer 
    │                       # (i.e Network response, DB Entity, UI model)
    │
    ├── navigation      # Module used to navigate across modules
    |
    ├── buildSrc        # Module used to write all dependencies
    |                   
    └── app             # Application class
```

### Dependency Injection
DI already implemented using `koin`