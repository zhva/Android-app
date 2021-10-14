plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "fhs.mmt.nma.umbrella"
        minSdk = 21
        targetSdk = 31
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables { useSupportLibrary = true }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.orNull
    }

}

dependencies {

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity.compose)

    implementation(libs.compose.material.material)
    implementation(libs.compose.material.icons)
    implementation(libs.compose.ui.ui)
    implementation(libs.compose.ui.tooling)

    implementation(libs.androidx.navigation.compose)


    implementation(libs.accompanist.pager.pager)
    implementation(libs.accompanist.pager.indicators)
    implementation(libs.accompanist.navigation.material)

    implementation(libs.coil.compose)

    implementation(libs.okhttp.okhttp)
    implementation(libs.okhttp.logger)
    implementation(libs.retrofit.retrofit)
    implementation(libs.retrofit.converter.moshi)
    implementation(libs.moshi.kotlin)
    implementation(libs.moshi.adapters)

}