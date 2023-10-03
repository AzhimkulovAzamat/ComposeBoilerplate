import org.gradle.api.JavaVersion

object BuildDependenciesVersions {
    const val JVM_TARGET = "17"
    const val KOTLIN_COMPILER_EXTENSION_VERSION = "1.4.3"

    val SOURCE_COMPATIBILITY_VERSION = JavaVersion.VERSION_17
    val TARGET_COMPATIBILITY_VERSION = JavaVersion.VERSION_17

    const val TEST_INSTRUMENTATION_RUNNER_ID = "androidx.test.runner.AndroidJUnitRunner"
}

object DependenciesVersions {
    const val COMPOSE_BOM = "2023.03.00"
    const val CONSTRAINTLAYOUT_VERSION = "1.0.1"
    const val RUNTIME_LIVEDATA_VERSION = "1.5.1"
    const val ACTIVITY_COMPOSE_VERSION = "1.7.2"

    const val KOTLIN_VERSION = "1.12.0"
    const val LIFECYCLE_RUNTIME_VERSION = "2.6.2"
    const val JUNIT_VERSION = "1.1.5"
    const val ESPRESSO_CORE_VERSION = "3.5.1"

    const val RETROFIT_VERSION = "2.9.0"
    const val OKHTTP_VERSION = "4.11.0"

    const val HILT_VERSION = "2.44"
}

object ApplicationDependencies {
    object Network {
        const val RETROFIT =
            "com.squareup.retrofit2:retrofit:${DependenciesVersions.RETROFIT_VERSION}"
        const val GSON_CONVERTER =
            "com.squareup.retrofit2:converter-gson:${DependenciesVersions.RETROFIT_VERSION}"
        const val RETROFIT_LOGGING =
            "com.squareup.okhttp3:logging-interceptor:${DependenciesVersions.OKHTTP_VERSION}"
        const val OKHTTP = "com.squareup.okhttp3:okhttp:${DependenciesVersions.OKHTTP_VERSION}"
        const val jsoup = "org.jsoup:jsoup:1.16.1"
    }

    object Room {

    }

    object Hilt {
        object KotlinOnly {
            const val JAVA_INJECT = "javax.inject:javax.inject:1"
        }

        object Android {
            const val DAGGER = "com.google.dagger:hilt-android:${DependenciesVersions.HILT_VERSION}"

            @SpecificImplementation(ImplementationType.KAPT)
            const val COMPILER =
                "com.google.dagger:hilt-compiler:${DependenciesVersions.HILT_VERSION}"
        }
    }

    object Coroutines {
        const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3"
    }

    object Testing {
        object Android {
            @SpecificImplementation(ImplementationType.ANDROID_TEST_IMPLEMENTATION)
            const val JUNIT = "androidx.test.ext:junit:${DependenciesVersions.JUNIT_VERSION}"

            @SpecificImplementation(ImplementationType.ANDROID_TEST_IMPLEMENTATION)
            const val ESPRESSO_CORE =
                "androidx.test.espresso:espresso-core:${DependenciesVersions.ESPRESSO_CORE_VERSION}"
        }

        object Data {
            @SpecificImplementation(ImplementationType.TEST_IMPLEMENTATION)
            const val JUNIT = "junit:junit:4.13.2"
        }
    }

    object Kotlin {
        const val CORE = "androidx.core:core-ktx:${DependenciesVersions.KOTLIN_VERSION}"
    }

    object LifeCycle {
        const val LIFECYCLE_RUNTIME =
            "androidx.lifecycle:lifecycle-runtime-ktx:${DependenciesVersions.LIFECYCLE_RUNTIME_VERSION}"
    }

    object Compose {
        const val ACTIVITY_COMPOSE =
            "androidx.activity:activity-compose:${DependenciesVersions.ACTIVITY_COMPOSE_VERSION}"

        @SpecificImplementation(
            ImplementationType.PLATFORM_IMPLEMENTATION,
            ImplementationType.PLATFORM_ANDROID_TEST_IMPLEMENTATION
        )
        const val BOM = "androidx.compose:compose-bom:${DependenciesVersions.COMPOSE_BOM}"
        const val UI = "androidx.compose.ui:ui"
        const val UI_GRAPHICS = "androidx.compose.ui:ui-graphics"
        const val PREVIEW_TOOL = "androidx.compose.ui:ui-tooling-preview"
        const val MATERIAL3 = "androidx.compose.material3:material3"
        const val CONSTRAINTLAYOUT_COMPOSE =
            "androidx.constraintlayout:constraintlayout-compose:${DependenciesVersions.CONSTRAINTLAYOUT_VERSION}"
        const val RUNTIME_LIVEDATA =
            "androidx.compose.runtime:runtime-livedata:${DependenciesVersions.RUNTIME_LIVEDATA_VERSION}"

        @SpecificImplementation(ImplementationType.ANDROID_TEST_IMPLEMENTATION)
        const val UI_TEST = "androidx.compose.ui:ui-test-junit4"

        @SpecificImplementation(ImplementationType.DEBUG_IMPLEMENTATION)
        const val UI_TOOLING = "androidx.compose.ui:ui-tooling"

        @SpecificImplementation(ImplementationType.DEBUG_IMPLEMENTATION)
        const val UI_TEST_MANIFEST = "androidx.compose.ui:ui-test-manifest"
    }
}

object Plugin {
    object
    Android {
        const val ANDROID = "org.jetbrains.kotlin.android"
        @SpecificPlugin(PluginType.KOTLIN)
        const val KAPT = "kapt"
        const val HILT_ANDROID = "com.google.dagger.hilt.android"
    }

    object Domain {
        const val JAVA_LIBRARY = "java-library"
        const val KOTLIN_JVM = "org.jetbrains.kotlin.jvm"
    }

    object Presentaion {
        const val APPLICATION = "com.android.application"
    }

    object Data {
        const val ANDROID_LIBRARY = "com.android.library"
    }

    object ProjectsRequired {
        @PluginSettings("8.1.1")
        const val APPLICATION = "com.android.application"

        @PluginSettings("1.8.10")
        const val ANDROID = "org.jetbrains.kotlin.android"

        @PluginSettings("1.8.10")
        const val KOTLIN_JVM = "org.jetbrains.kotlin.jvm"

        @PluginSettings("8.1.1")
        const val ANDROID_LIBRARY = "com.android.library"

        @PluginSettings(DependenciesVersions.HILT_VERSION)
        const val HILT_ANDROID = "com.google.dagger.hilt.android"
    }
}