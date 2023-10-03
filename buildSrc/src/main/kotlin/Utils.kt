import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.kotlin
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec


@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class SpecificImplementation(
    vararg val types: ImplementationType = arrayOf(
        ImplementationType.IMPLEMENTATION
    )
)

enum class ImplementationType {
    IMPLEMENTATION,
    PLATFORM_IMPLEMENTATION,
    ANDROID_TEST_IMPLEMENTATION,
    TEST_IMPLEMENTATION,
    PLATFORM_ANDROID_TEST_IMPLEMENTATION,
    DEBUG_IMPLEMENTATION, KAPT;

    fun invoke(handler: DependencyHandler, dependency: Any) {
        when (this) {
            IMPLEMENTATION -> handler.implementation(dependency)
            PLATFORM_IMPLEMENTATION -> handler.implementation(handler.platform(dependency))
            ANDROID_TEST_IMPLEMENTATION -> handler.androidTestImplementation(dependency)
            TEST_IMPLEMENTATION -> handler.testImplementation(dependency)
            PLATFORM_ANDROID_TEST_IMPLEMENTATION -> handler.androidTestImplementation(
                handler.platform(
                    dependency
                )
            )

            DEBUG_IMPLEMENTATION -> handler.debugImplementation(dependency)
            KAPT -> handler.kapt(dependency)
        }
    }
}

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class PluginSettings(val version: String, val apply: Boolean = false)

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class SpecificPlugin(
    val types: PluginType = PluginType.ID
)

enum class PluginType {
    ID,
    KOTLIN;

    fun invoke(handler: PluginDependenciesSpec, dependency: String): PluginDependencySpec {
        return when(this) {
            ID -> handler.id(dependency)
            KOTLIN -> handler.kotlin(dependency)
        }
    }
}