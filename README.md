#  Travel APP (Kotlin Multiplatform Mobile)

Travel App is a simple **mobile application** built to demonstrate the use of
_**Kotlin Multiplatform Mobile**_ for developing _Android and iOS_ applications
using **Jetpack Compose** 🚀.

## ![](https://img.shields.io/badge/Android-black.svg?style=for-the-badge&logo=android) ![](https://img.shields.io/badge/iOS-black.svg?style=for-the-badge&logo=apple)  


<img width="90%" alt="Cover-Travel-App-KMM" src="https://github.com/Realtime-Coding/TravelAppKMM/assets/21146457/50aa5ea2-8c2e-4f6c-919d-a9cb8d68b649">

### 📱 Preview

Currently, the app looks like this on the both platforms:

#### ▶️ Android & Android

https://github.com/Realtime-Coding/TravelAppKMP/assets/21146457/d8dc7372-4780-4145-a959-b223a819d321

---

## Built with 

- [Kotlin](kotlinlang.org): Programming language
- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html): For building multi-platform applications in the single codebase.
- [Jetpack/JetBrains Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/): For a shared UI between multi-platforms i.e. Android and iOS in this project.
- [Moko Resources](https://github.com/icerockdev/moko-resources): This is a Kotlin MultiPlatform library (and Gradle plugin) that provides access to the resources on macOS, iOS, Android the JVM and JS/Browser with the support of the default system localization.
-  [Compose Image Loader](https://github.com/qdsfdhvh/compose-imageloader): Compose Image library for Kotlin Multiplatform.


## TODOs

### ✅ Completed
- [x] Home screen UI.
- [x] Destination Detail screen UI.
- [x] Favorite Detail screen UI.
- [x] Coil(Image loading from Url).
- [x] Bottom Navigation Menu.
- [x] Compose resources e-g images, strings and fonts.
- [x] Voyager (Navigation).

### 🚧 Work in progress

- [ ] Cart Screen Design.
- [ ] Profile Screen Design.
- [ ] Room setup for adding favorites.
- [ ] Switch for dark/light theme.
- [ ] Shifting content to github repo then fetch details through ktor client library.
- [ ] MVVM Implementation
- [ ] Testing

## Project structure 

This Compose Multiplatform project includes three modules:

### [`composeApp`](/shared)
This is a Kotlin module that contains the common UI/logic for both Android and iOS applications, the code you share between platforms.
This shared module is also where you write your Compose Multiplatform code. In `composeApp/src/commonMain/kotlin/App.kt`, you can find the shared root `@Composable` function for your app.
It uses Gradle as the build system. You can add dependencies and change settings in `composeApp/build.gradle.kts`. The shared module builds into an Android library and an iOS framework.

### [`androidApp`](/androidApp)
This is a Kotlin module that builds into an Android application. It uses Gradle as the build system. The `androidApp` module depends on and uses the shared module as a regular Android library.

### [`iosApp`](/iosApp)
This is an Xcode project that builds into an iOS application. It depends on and uses the shared module as a CocoaPods dependency.


## Setting up project 👨🏻‍💻

- Refer to the ***"Setting up environment"*** section of [this repository](https://github.com/JetBrains/compose-multiplatform-ios-android-template/main/README.md) 
for knowing the setup guidelines
- After validating requirements as per the above guide, clone this repository.
- Open this project in Android Studio Electric Eel or newer version.
- Build project 🔨 and see if everything is working fine.
- Run App
  - Select "androidApp" as run configuration and you'll be able to run the Android app.
  - Select "iosApp" as run configuration and you'll be able to run the iOS app _(XCode can also be used to run the app)_.

---

## Contribute

If you want to contribute to this library, you're always welcome!

## Acknowledgements 

- [Philipp Lackner - How to Share Resources in KMM (Strings, Images, etc.)](https://www.youtube.com/watch?v=xtWzpLtCuY0):
  For understanding Share resources
- [Abdul Basit - TravelApp-KMP](https://github.com/SEAbdulbasit/TravelApp-KMP/): For gradle understanding and custom navigation.
- [Fimga Design By Michelle Setiyanti](https://www.figma.com/community/file/1155051579579231831): For cloning the design into compose.

## Want to create Project in KMM? Step by Step Documentations
Notion file: [Documentations](https://shahzadafridi.notion.site/KMM-Journey-b1c86a41733c4b53bd459c8d10fb0a45?pvs=4)
