plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("com.datadoghq.dd-sdk-android-gradle-plugin")
  kotlin("kapt")
  id("com.google.dagger.hilt.android")
}

android {
  namespace = "team.uptech.playground"
  compileSdk = 34

  defaultConfig {
    applicationId = "team.uptech.playground"
    minSdk = 24
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
      signingConfig = signingConfigs.getByName("debug")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    isCoreLibraryDesugaringEnabled = true
  }
  kotlinOptions {
    jvmTarget = "17"
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.11"
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {
  val room_version = "2.5.2"
  implementation("androidx.room:room-runtime:$room_version")
  annotationProcessor("androidx.room:room-compiler:$room_version")

  // To use Kotlin annotation processing tool (kapt)
  kapt("androidx.room:room-compiler:$room_version")

  implementation("androidx.room:room-ktx:$room_version")

  implementation("androidx.core:core-ktx:1.12.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
  implementation("androidx.activity:activity-compose:1.8.2")
  implementation(platform("androidx.compose:compose-bom:2024.02.02"))
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.ui:ui-graphics")
  implementation("androidx.compose.ui:ui-tooling-preview")
  implementation("androidx.compose.material3:material3")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
  androidTestImplementation(platform("androidx.compose:compose-bom:2024.02.02"))
  androidTestImplementation("androidx.compose.ui:ui-test-junit4")
  debugImplementation("androidx.compose.ui:ui-tooling")
  debugImplementation("androidx.compose.ui:ui-test-manifest")
  implementation("com.datadoghq:dd-sdk-android-rum:2.4.0")
  implementation("com.datadoghq:dd-sdk-android-logs:2.4.0")
  implementation("com.jakewharton.timber:timber:5.0.1")

  coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.4")

  implementation("com.google.dagger:hilt-android:2.49")
  kapt("com.google.dagger:hilt-android-compiler:2.49")
  implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
  implementation("androidx.navigation:navigation-compose:2.7.7")
  implementation("io.github.theapache64:rebugger:1.0.0-rc02")
}

// Allow references to generated code
kapt {
  correctErrorTypes = true
}