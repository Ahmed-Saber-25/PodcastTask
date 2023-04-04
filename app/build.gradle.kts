import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
}
@Suppress("UnstableApiUsage") android {
    namespace = Android.applicationId
    compileSdk = Versions.COMPILE_SDK

    signingConfigs {
        getByName("debug") {

        }
        create("release") {

        }
    }

    defaultConfig {
        applicationId = Android.applicationId
        minSdk = Versions.MIN_SDK_VERSION
        targetSdk = Versions.TARGET_SDK_VERSION
        versionCode = Versions.VERSION_CODE
        versionName = Versions.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    val key: String = gradleLocalProperties(rootDir).getProperty("key")

    buildTypes {
        getByName("release") {
            buildConfigField("String", "key", key)
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
            isDebuggable = false
        }
        getByName("debug") {
            buildConfigField("String", "key", key)
            signingConfig = signingConfigs.getByName("debug")
            isDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:${Versions.KOTLIN}")
    implementation("androidx.appcompat:appcompat:${Versions.ANDROIDX_APP_COMPAT}")
    implementation("com.google.android.material:material:${Versions.MATERIAL}")
    //Activity KTX
    implementation("androidx.activity:activity-ktx:${Versions.ACTIVITY_KTX}")
    implementation("androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}")
    testImplementation("junit:junit:${Versions.JUNIT}")
    androidTestImplementation("androidx.test.ext:junit:${Versions.ANDROIDX_JUNIT}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}")
    //nanigation
    implementation("androidx.navigation:navigation-fragment-ktx:${Versions.NAV_VERSION}")
    implementation("androidx.navigation:navigation-ui-ktx:${Versions.NAV_VERSION}")
    //hilt
    implementation("com.google.dagger:hilt-android:${Versions.HILT_VERSION}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.HILT_VERSION}")
    //ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_VERSION}")
    //LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_VERSION}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_VERSION}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.LIFECYCLE_VERSION}")
    implementation("androidx.lifecycle:lifecycle-common-java8:${Versions.LIFECYCLE_VERSION}")
    // Annotation processor
    kapt("androidx.lifecycle:lifecycle-compiler:${Versions.LIFECYCLE_VERSION}")
    implementation("com.intuit.sdp:sdp-android:${Versions.SDP_ANDROID}")
    implementation("com.intuit.ssp:ssp-android:${Versions.SDP_ANDROID}")
    //Toasty
    implementation("com.github.GrenderG:Toasty:${Versions.TOASTY}")
    //Glide
    implementation("com.github.bumptech.glide:glide:${Versions.GLIDE}")
    annotationProcessor("com.github.bumptech.glide:compiler:${Versions.GLIDE}")
    //blur
    implementation("jp.wasabeef:blurry:${Versions.BLURRY}")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.google.code.gson:gson:2.10.1")
    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    //Client
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.1")
    //OkHttp Interceptor
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.1")
    //Gson

}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}