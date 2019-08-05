package com.eddie.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class eddie implements Plugin<Project> {

    @Override
    void apply(Project project) {
        def extensions = project.extensions.create('eddie', EddieExtension)
        project.afterEvaluate {
            println "hello world ${extensions.name}"
        }
        project.task('print', {
            // 配置未来执行的任务
            doLast {
                println '哈哈哈哈'
            }
        })
    }
}