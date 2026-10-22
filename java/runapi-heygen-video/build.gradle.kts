plugins {
  `java-library`
  `maven-publish`
}

extra["runapiSlug"] = "heygen-video"

description = "RunAPI HeyGen Video Java SDK for HeyGen Video workflows."

java {
  withSourcesJar()
  withJavadocJar()
}

dependencies {
  api("ai.runapi:runapi-core:0.10.0")

  testImplementation(platform("org.junit:junit-bom:5.10.3"))
  testImplementation("org.junit.jupiter:junit-jupiter")
}

publishing {
  publications {
    create<MavenPublication>("mavenJava") {
      from(components["java"])
      artifactId = "runapi-heygen-video"
      pom {
        name = "RunAPI HeyGen Video Java SDK"
        description = "RunAPI HeyGen Video Java SDK for HeyGen Video workflows."
        url = "https://runapi.ai/models/heygen-video"
        licenses {
          license {
            name = "Apache License, Version 2.0"
            url = "https://www.apache.org/licenses/LICENSE-2.0"
          }
        }
        developers {
          developer {
            id = "runapi"
            name = "RunAPI"
            email = "contact@runapi.ai"
          }
        }
        scm {
          url = "https://github.com/runapi-ai/heygen-video-sdk"
          connection = "scm:git:https://github.com/runapi-ai/heygen-video-sdk.git"
          developerConnection = "scm:git:ssh://git@github.com/runapi-ai/heygen-video-sdk.git"
        }
      }
    }
  }
}
