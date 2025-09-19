import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

group = libs.versions.wasmApp.group.get()
version = libs.versions.wasmApp.version.get()

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/WasmApp"))