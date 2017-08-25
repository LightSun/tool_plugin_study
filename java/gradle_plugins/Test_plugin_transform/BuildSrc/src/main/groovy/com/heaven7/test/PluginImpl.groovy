package com.heaven7.test;

import com.android.build.gradle.AppExtension;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * Created by hp on 2016/4/8.
 */
public class PluginImpl implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.logger.error "================自定义插件成功！=========="
        def android = project.extensions.findByType(AppExtension)
        android.registerTransform(new PreDexTransform(project))

        handleSelfExtension(project);
    }

    static void handleSelfExtension(Project project) {
        project.extensions.create('hc', HCExtension);
        project.extensions.create('address', Address);


        project.task('readExtension').doLast{
            def address=project['address']

            project.logger.info project['hc'].myName
            project.logger.info address.province+" "+address.city

        }
    }
}