1， 创建新项目(android or not). 创建module (s_plugin). 删除module(s_plugin)下除build.gradle的所有文件。
    
     删除module(s_plugin) 下。build.gradle文件的内容。并且添加内容

apply plugin: 'groovy'
apply plugin: 'maven'

dependencies {
    compile gradleApi()
    compile localGroovy()
}

repositories {
    mavenCentral()
    jcenter()
}

2, 创建src/main/groovy目录.  创建src/resources/META-INF/gradle-plugins目录
   在groovy下新建自己的包名。然后写插件.(这里是PluginImpl). 

3， 写完后在src/resources/META-INF/gradle-plugins 目录下。新建properties文件（最好和包名一致）
 ps: 这里是com.heaven7.gradle.plugin.study.properties.
   在该文件中添加插件实现: implementation-class=com.heaven7.gradle.plugin.study.PluginImpl
     

3. 如果要发布到本地maven. 在module的buidl file下添加

//包名.最好和src/resources/META-INF/gradle-plugins 下properties文件一致
group='com.heaven7.gradle.plugin.study'  
version='1.0.0'

uploadArchives {
    repositories {
        mavenDeployer {
            repository(url: uri('../../repo'))
        }
    }
}
 之后到module目录下。执行 gradle uploadArchives .会声明repo目录和相关maven文件。

4, root build.gradle 引用该插件
  buildscript {
    repositories {
        jcenter()
        //可以是jcenter.如果要引用jcenter.需要发布到jcenter. 
        maven {
            url uri('../repo')
        }
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.3.3'

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files    
        classpath 'com.heaven7.gradle.plugin.study:s_plugin:1.0.0'
    }
}

5, sample module引用
apply plugin: 'com.heaven7.gradle.plugin.study'

    