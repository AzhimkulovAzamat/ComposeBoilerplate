import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.plugin.use.PluginDependenciesSpec

fun DependencyHandler.implementationObject(dependencyObject: Any) {
    for (property in dependencyObject::class.java.declaredFields) {
        val propertyValue = property.get(dependencyObject).toString()
        val specialImplementation =
            property.annotations.find { it is SpecificImplementation } as? SpecificImplementation
        if (propertyValue.startsWith(dependencyObject::class.java.name)) {
            continue
        }
        specialImplementation?.let {
            it.types.forEach { type ->
                type.invoke(this, propertyValue)
            }
        } ?: kotlin.run {
            implementation(propertyValue)
        }
    }
}

fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

fun DependencyHandler.api(dependencyNotation: Any): Dependency? =
    add("api", dependencyNotation)


fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)


fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? =
    add("debugImplementation", dependencyNotation)


fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)


fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)