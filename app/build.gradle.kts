import java.util.Properties
import java.io.FileInputStream


val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")

if (localPropertiesFile.exists()) {
    localProperties.load(FileInputStream(localPropertiesFile))
} else {
    println("local.properties not found!")
}

val apiKey = localProperties.getProperty("OPENWEATHER_API_KEY") ?: ""

plugins {
    alias(libs.plugins.android.application)
}


android {
    namespace = "com.example.weatherapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.weatherapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "OPENWEATHER_API_KEY", "\"$apiKey\"")
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
        buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Retrofit & converter
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

// OkHttp
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor.v4120)

// Lifecycle (MVVM)
    implementation(libs.androidx.lifecycle.runtime.ktx.v262)
    implementation(libs.androidx.lifecycle.viewmodel.ktx.v262)
    implementation(libs.androidx.lifecycle.livedata.ktx.v262)

// Gson
    implementation(libs.gson.v2101)


// Activity + ViewModel KTX
    implementation(libs.androidx.activity.ktx.v180)

// BlurView
      implementation(libs.blurview.vversion206)

    // WeatherView (mưa/tuyết)
  //   implementation(libs.weatherview)


// Glide
    implementation(libs.glide.v4151)

}

