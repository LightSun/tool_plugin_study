package com.heaven7.java.study.processor;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.tools.Diagnostic;
import java.util.Arrays;
import java.util.Set;

/**
 * 步骤： build jar
 * .java 源代码生成器 github. TypeSpec
 */
@SupportedAnnotationTypes({"com.heaven7.java.study.processor.PrintMe", "com.heaven7.java.study.processor.ShouldProxy"})
@SupportedSourceVersion(SourceVersion.RELEASE_6)
//@SupportedOptions() //supportedOptions用来表示所支持的附加选项
public class MyProcessor extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        /**
         * 在init()中我们获得如下引用：

         Elements：一个用来处理Element的工具类；
         Types：一个用来处理TypeMirror的工具类；
         Filer：正如这个名字所示，使用Filer你可以创建文件；
         */
        super.init(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
        Messager messager = processingEnv.getMessager();
        for (TypeElement te : annotations) {
            //TypeElement 代表 注解的元素.这里有@PrintMe
            messager.printMessage(Diagnostic.Kind.WARNING, "TypeElement： " +  te.getClass().getName()); //com.sun.tools.javac.code.Symbol$ClassSymbol
            messager.printMessage(Diagnostic.Kind.WARNING, "getNestingKind()： " +  te.getNestingKind());
            messager.printMessage(Diagnostic.Kind.WARNING, "getInterfaces()： " +  te.getInterfaces());
            messager.printMessage(Diagnostic.Kind.WARNING, "getSuperclass()： " +  te.getSuperclass());
            messager.printMessage(Diagnostic.Kind.WARNING, "getTypeParameters()： " +  te.getTypeParameters());
            messager.printMessage(Diagnostic.Kind.WARNING, "getQualifiedName()： " +  te.getQualifiedName());
            for (Element e : env.getElementsAnnotatedWith(te)) {
                messager.printMessage(Diagnostic.Kind.NOTE, "Element： " +  e.getClass().getName());

                messager.printMessage(Diagnostic.Kind.NOTE, "asType()： " +  e.asType());
                messager.printMessage(Diagnostic.Kind.NOTE, "getAnnotationMirrors()： " +  e.getAnnotationMirrors());//@com.heaven7.java.study.processor.PrintMe
                messager.printMessage(Diagnostic.Kind.NOTE, "getEnclosedElements()： " +  e.getEnclosedElements());//得到所有的filed,method.

                /**
                 * 得到使用注解的类名的前缀
                 *  pulltorefresh.android.heaven7.com.pulltorefesh.sample.PullToRefreshTestActivity ->pulltorefresh.android.heaven7.com.pulltorefesh.sample
                 */
                messager.printMessage(Diagnostic.Kind.NOTE, "getEnclosingElement()： " +  e.getEnclosingElement());
                messager.printMessage(Diagnostic.Kind.NOTE, "getKind()： " +  e.getKind()); //CLASS
                messager.printMessage(Diagnostic.Kind.NOTE, "Printing: " + e.toString());//完整的类，类，名
            }
        }
       // processingEnv.getFiler().createSourceFile("heaven7", )

        return true;
    }

    @Override
    public Iterable<? extends Completion> getCompletions(Element element, AnnotationMirror annotation, ExecutableElement member, String userText) {
        Messager msg = processingEnv.getMessager();
        msg.printMessage(Diagnostic.Kind.NOTE, "--------------- start getCompletions() --------------------");
        msg.printMessage(Diagnostic.Kind.NOTE, "Element： " +  element);
        msg.printMessage(Diagnostic.Kind.NOTE, "annotation： " +  annotation);
        msg.printMessage(Diagnostic.Kind.NOTE, "ExecutableElement： " +  member);
        msg.printMessage(Diagnostic.Kind.NOTE, "userText： " +  userText);
        msg.printMessage(Diagnostic.Kind.NOTE, "--------------- end getCompletions() --------------------");
       // return super.getCompletions(element, annotation, member, userText);

        return Arrays.asList(Completions.of("key_test", "test message"));
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}