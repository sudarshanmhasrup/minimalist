import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.wasmApp.group.get()
version = libs.versions.wasmApp.version.get()

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    sourceSets {
       wasmJsMain.dependencies {
           implementation(libs.compose.multiplatform.ui)
       }
    }
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/WasmApp"))