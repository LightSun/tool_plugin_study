1�� ��������Ŀ(android or not). ����module (s_plugin). ɾ��module(s_plugin)�³�build.gradle�������ļ���
    
     ɾ��module(s_plugin) �¡�build.gradle�ļ������ݡ������������

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

2, ����src/main/groovyĿ¼.  ����src/resources/META-INF/gradle-pluginsĿ¼
   ��groovy���½��Լ��İ�����Ȼ��д���.(������PluginImpl). 

3�� д�����src/resources/META-INF/gradle-plugins Ŀ¼�¡��½�properties�ļ�����úͰ���һ�£�
 ps: ������com.heaven7.gradle.plugin.study.properties.
   �ڸ��ļ�����Ӳ��ʵ��: implementation-class=com.heaven7.gradle.plugin.study.PluginImpl
     

3. ���Ҫ����������maven. ��module��buidl file�����

//����.��ú�src/resources/META-INF/gradle-plugins ��properties�ļ�һ��
group='com.heaven7.gradle.plugin.study'  
version='1.0.0'

uploadArchives {
    repositories {
        mavenDeployer {
            repository(url: uri('../../repo'))
        }
    }
}
 ֮��moduleĿ¼�¡�ִ�� gradle uploadArchives .������repoĿ¼�����maven�ļ���

4, root build.gradle ���øò��
  buildscript {
    repositories {
        jcenter()
        //������jcenter.���Ҫ����jcenter.��Ҫ������jcenter. 
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

5, sample module����
apply plugin: 'com.heaven7.gradle.plugin.study'

    