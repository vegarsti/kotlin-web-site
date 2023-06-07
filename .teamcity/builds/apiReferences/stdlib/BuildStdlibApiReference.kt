package builds.apiReferences.stdlib

import builds.apiReferences.kotlinx.coroutines.KotlinxCoroutinesBuildApiReference
import jetbrains.buildServer.configs.kotlin.AbsoluteId
import jetbrains.buildServer.configs.kotlin.BuildType
import jetbrains.buildServer.configs.kotlin.FailureAction
import jetbrains.buildServer.configs.kotlin.ReuseBuilds

object BuildStdlibApiReference : BuildType({
  name = "Stdlib Api reference"

  artifactRules = "latest-version.zip"

  params {
    param("%apiTemplatesBranch%", "ktl-696-dokka-stdlib")
    param("revers.deps.*.templatesBranch", "%templatesBranch%")
  }

  dependencies {
    dependency(AbsoluteId("Kotlin_KotlinRelease_1820_LibraryReferenceLatestDocs")) {
      snapshot {
        reuseBuilds = ReuseBuilds.NO
        onDependencyFailure = FailureAction.FAIL_TO_START
      }
      artifacts {
        artifactRules = "latest-version.zip"
      }
    }
  }
})