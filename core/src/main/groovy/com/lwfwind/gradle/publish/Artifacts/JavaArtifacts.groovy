package com.lwfwind.gradle.publish.Artifacts

import org.gradle.api.Project
import org.gradle.api.tasks.bundling.Jar

class JavaArtifacts implements Artifacts {

    def all(Project project) {
        [sourcesJar(project), javadocJar(project)]
    }

    def sourcesJar(Project project) {
        project.task('mavenSourcesJar', type: Jar) {
            classifier = 'sources'
            from project.sourceSets.main.allSource
        }
    }

    def javadocJar(Project project) {
        project.task('mavenJavadocJar', type: Jar) {
            classifier = 'javadoc'
            from project.javadoc.destinationDir
        }
    }

    def from(Project project) {
        project.components.java
    }

}
