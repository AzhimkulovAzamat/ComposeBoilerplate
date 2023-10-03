plugins {
    applyPluginObject(Plugin.Presentaion)
    applyPluginObject(Plugin.Android)
}

android {
    namespace = Namespaces.app
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.APPLICATION_ID
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = BuildDependenciesVersions.TEST_INSTRUMENTATION_RUNNER_ID
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = BuildDependenciesVersions.SOURCE_COMPATIBILITY_VERSION
        targetCompatibility = BuildDependenciesVersions.TARGET_COMPATIBILITY_VERSION
    }
    kotlinOptions {
        jvmTarget = BuildDependenciesVersions.JVM_TARGET
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = BuildDependenciesVersions.KOTLIN_COMPILER_EXTENSION_VERSION
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))

    implementationObject(ApplicationDependencies.Kotlin)
    implementationObject(ApplicationDependencies.LifeCycle)
    implementationObject(ApplicationDependencies.Compose)
    implementationObject(ApplicationDependencies.Testing.Android)
    implementationObject(ApplicationDependencies.Hilt.Android)
}

kapt {
    correctErrorTypes = true
}