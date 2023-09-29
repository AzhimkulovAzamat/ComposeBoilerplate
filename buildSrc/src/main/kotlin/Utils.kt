import org.gradle.api.artifacts.dsl.DependencyHandler


@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class SpecificImplementation(vararg val types: ImplementationType = arrayOf(ImplementationType.IMPLEMENTATION))

enum class ImplementationType {
    IMPLEMENTATION,
    PLATFORM_IMPLEMENTATION,
    ANDROID_TEST_IMPLEMENTATION,
    PLATFORM_ANDROID_TEST_IMPLEMENTATION,
    DEBUG_IMPLEMENTATION;

    fun invoke(handler: DependencyHandler, dependency: Any) {
        when(this) {
            IMPLEMENTATION -> handler.implementation(dependency)
            PLATFORM_IMPLEMENTATION -> handler.implementation(handler.platform(dependency))
            ANDROID_TEST_IMPLEMENTATION -> handler.androidTestImplementation(dependency)
            PLATFORM_ANDROID_TEST_IMPLEMENTATION -> handler.androidTestImplementation(handler.platform(dependency))
            DEBUG_IMPLEMENTATION -> handler.debugImplementation(dependency)
        }
    }
}