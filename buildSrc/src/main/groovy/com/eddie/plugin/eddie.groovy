package com.eddie.plugin
import org.gradle.api.Plugin
import org.gradle.api.Project

class eddie implements Plugin<Project>{

    @Override
    void apply(Project project) {
        project.afterEvaluate {
            println 'hello world'
        }
    }
}