plugins {
    applyPluginObject(Plugin.Domain)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementationObject(ApplicationDependencies.Coroutines)
    implementationObject(ApplicationDependencies.Hilt.KotlinOnly)
}