package com.heaven7.java.dynamic.compile;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 动态的生成了一个代理类Dealer.java ,然后动态的编译这个类,最后调用这个类的方法.
 */
public class DynamicCompileTest {

    public static void main(String[] args) throws Exception {
       final String pkgName = "com.heaven7.java.dynamic.compile";

        String rt = "\r\n";
        String source = "package com.heaven7.java.dynamic.compile;" + "" + rt
                + "public class Dealer implements Store" + rt + "{" + rt + "private Store s;" + rt +
                "public Dealer(Store s)" + rt + " {" + "  this.s = s;" + rt
                + " }" + rt +

                " public void sell()" + " {" + rt
                + "  System.out.println(\"price markup....\");" + rt
                + "  s.sell();" + " }" + rt +
                "}";

        String fileName = System.getProperty("user.dir")//获取到项目的根路径
                + "/src/main/java/com/heaven7/java/dynamic/compile/Dealer.java";
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(source);
        fw.flush();
        fw.close();//这里只是产生一个JAVA文件,简单的IO操作

        // compile下面开始编译这个Store.java
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null,
                null, null);
        Iterable units = fileMgr.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null,
                units);
        t.call();
        fileMgr.close();

        // load into memory and create an instance
        URL[] urls = new URL[]{new URL("file:/"
                + System.getProperty("user.dir") + "/src/main/java")};
        URLClassLoader ul = new URLClassLoader(urls);
        Class c = ul.loadClass(pkgName + ".Dealer");
        System.out.println(c);

//客户端调用

        Constructor ctr = c.getConstructor(Store.class);
        Store s = (Store) ctr.newInstance(new Supermarket());//这里看到,这个我们这个代理类必须实现Store的原因
        s.sell();
    }
}