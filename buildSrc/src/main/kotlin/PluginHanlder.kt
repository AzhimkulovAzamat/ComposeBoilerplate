import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.version
import org.gradle.plugin.use.PluginDependenciesSpec

fun PluginDependenciesSpec.applyPluginObject(pluginObject: Any) {
    for (property in pluginObject::class.java.declaredFields) {
        val propertyValue = property.get(pluginObject).toString()
        val pluginSettings =
            property.annotations.find { it is PluginSettings } as? PluginSettings
        val pluginType = property.annotations.find { it is SpecificPlugin } as? SpecificPlugin ?: SpecificPlugin()
         if (propertyValue.startsWith(pluginObject::class.java.name)) {
            continue
        }
        pluginSettings?.let {
            pluginType.types.invoke(this, propertyValue) version it.version apply it.apply
        } ?: kotlin.run {
            pluginType.types.invoke(this, propertyValue)
        }
    }
}