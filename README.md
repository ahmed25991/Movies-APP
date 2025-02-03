# 🎬 MovieApp - TMDB Movie Explorer

[![Android](https://img.shields.io/badge/Platform-Android-green)](https://developer.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-blue)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-UI%20Toolkit-purple)](https://developer.android.com/jetpack/compose)
[![Hilt](https://img.shields.io/badge/Hilt-Dagger--Hilt-blue)](https://developer.android.com/training/dependency-injection/hilt-android)
[![MVVM](https://img.shields.io/badge/Architecture-MVVM-red)](https://developer.android.com/jetpack/guide)

## 📌 Overview
**MovieApp** is a modern Android application that displays movies and their details using **The Movie Database (TMDB) API**. The project follows **best practices** for Android development, leveraging:
- **MVVM Architecture**
- **Kotlin Coroutines & Flow** for asynchronous tasks
- **Retrofit** for API calls
- **Hilt (Dagger-Hilt)** for dependency injection
- **Jetpack Compose** for UI

---

## 🎥 Features
✅ Fetch and display **Now Playing** movies  
✅ Show detailed movie information  
✅ Search movies by title  
✅ Offline caching with **Room Database**  
✅ Dependency injection using **Hilt**  
✅ Modern **Jetpack Compose UI**

---

## 🛠 Tech Stack
| Component | Library |
|-----------|---------|
| UI | **Jetpack Compose** |
| Architecture | **MVVM (Model-View-ViewModel)** |
| API Client | **Retrofit 2 + Gson** |
| Dependency Injection | **Hilt (Dagger-Hilt)** |
| Async Handling | **Kotlin Coroutines + Flow** |
| Local Storage | **Room Database** |
| Navigation | **Jetpack Navigation Component** |
| Image Loading | **Coil** |

---

## 📸 Screenshots
| Movie List                          | Movie Details                             |
|-------------------------------------|-------------------------------------------|
| ![Movie List](screenshots/home.png) | ![Movie Details](screenshots/details.png) |

---

## 🚀 Getting Started

### 🔑 Prerequisites
- Android Studio **Giraffe or newer**
- Kotlin **1.9+**
- **TMDB API Key** (Get one from [TMDB](https://www.themoviedb.org/))

### 🔧 Setup TMDB API Key
To run the project, add your TMDB API key in `local.properties`:

```properties
API_KEY=your_tmdb_api_key
ACCESS_TOKEN=your_tmdb_access_token
BASE_URL=https://api.themoviedb.org/3/
