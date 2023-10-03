plugins {
    applyPluginObject(Plugin.Data)
    applyPluginObject(Plugin.Android)
}

android {
    namespace = "net.breez.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    buildFeatures {
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":domain"))
    implementationObject(ApplicationDependencies.Kotlin)
    implementationObject(ApplicationDependencies.Coroutines)
    implementationObject(ApplicationDependencies.Testing.Android)
    implementationObject(ApplicationDependencies.Testing.Data)
    implementationObject(ApplicationDependencies.Network)
    implementationObject(ApplicationDependencies.Room)
    implementationObject(ApplicationDependencies.Hilt.Android)
}