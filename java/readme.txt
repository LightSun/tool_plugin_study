
see http://www.cnblogs.com/avenwu/p/4173899.html


一般编译时注解自动生成代码，通过extends AbstractProcessor.
然后通过META-INF/services 注册processor然后。jvm会编译时处理。


自动生成代码的工具库google - auto 
       省去了手动注册processor的步骤.

module compile依赖：
          compile 'com.google.auto:auto-common:0.6'
          compile 'com.google.auto.service:auto-service:1.0-rc2'
          compile 'com.squareup:javapoet:1.7.0'
然后在你的processor上注解 AutoService

google高质量的api库
Google Guava

android字节码插件注入处理：
    http://blog.csdn.net/sbsujjbcy/article/details/50839263

android transform (字节码注入)
http://tools.android.com/tech-docs/new-build-system/transform-api

====================
TestProcessor 是编译时插件。idea项目


