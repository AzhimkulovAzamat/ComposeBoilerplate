object DependenciesVersions {
    const val COMPOSE_BOM = "2023.03.00"
    const val CONSTRAINTLAYOUT_VERSION = "1.0.1"
    const val RUNTIME_LIVEDATA_VERSION = "1.5.1"
    const val ACTIVITY_COMPOSE_VERSION = "1.7.2"

    const val KOTLIN_VERSION = "1.12.0"
    const val LIFECYCLE_RUNTIME_VERSION = "2.6.2"
    const val JUNIT_VERSION = "1.1.5"
    const val ESPRESSO_CORE_VERSION = "3.5.1"
}

object ApplicationDependencies {
    object Testing {
        @SpecificImplementation(ImplementationType.ANDROID_TEST_IMPLEMENTATION)
        const val JUNIT = "androidx.test.ext:junit:${DependenciesVersions.JUNIT_VERSION}"
        @SpecificImplementation(ImplementationType.ANDROID_TEST_IMPLEMENTATION)
        const val ESPRESSO_CORE =
            "androidx.test.espresso:espresso-core:${DependenciesVersions.ESPRESSO_CORE_VERSION}"
    }

    object Kotlin {
        const val CORE = "androidx.core:core-ktx:${DependenciesVersions.KOTLIN_VERSION}"
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