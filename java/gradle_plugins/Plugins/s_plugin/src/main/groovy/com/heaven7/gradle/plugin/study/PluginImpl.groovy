package com.heaven7.gradle.plugin.study;

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * gradle 插件教程
 * http://blog.csdn.net/sbsujjbcy/article/details/50782830/
 * http://blog.csdn.net/liuhongwei123888/article/details/50541759
 */
public class PluginImpl implements Plugin<Project> {

    /**
     * 等待sample项目引用当前插件后， 可通过gradle命令:
     *       gradle customTask.
     *       gradle testTask.    执行命令
     * @param project
     */
    void apply(Project project) {
        //传递参数
        project.extensions.create('pluginExt', PluginExtension)
        project.pluginExt.extensions.create('nestExt', PluginNestExtension)
        project.task('customTask', type: CustomTask)

        project.gradle.addListener(new TimeListener())
        project.task('testTask') << {
            println "Hello gradle plugin"
        }
    }
}
/**
 pluginExt {
 param1 = 'app param1'
 param2 = 'app param2'
 nestExt{
 nestParam1='app nestParam1'
 nestParam2='app nestParam2'

 }
 }
 */