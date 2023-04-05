buildscript{
    repositories{
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
    dependencies{
        classpath("com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_VERSION}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAV_VERSION}")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT_VERSION}")
    }
}
tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}
