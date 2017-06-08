package com.heaven7.java.study.processor;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SupportedAnnotationTypes("PluggableAPT.ToBeTested")//可以用"*"表示支持所有Annotations
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class MyAnnotationProcessor extends AbstractProcessor {
    private void note(String msg) {
        processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, msg);
    }

    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //annotations的值是通过@SupportedAnnotationTypes声明的且目标源代码拥有的所有Annotations
        note("---------------- "+ getClass().getName()+" start ()------------------");
        for (TypeElement te : annotations) {
            note("annotation:" + te.toString());
        }
        Set<? extends Element> elements = roundEnv.getRootElements();//获取源代码的映射对象
        for (Element e : elements) {
            //获取源代码对象的成员
            List<? extends Element> enclosedElems = e.getEnclosedElements();
            //留下方法成员,过滤掉其他成员
            List<? extends ExecutableElement> ees = ElementFilter.methodsIn(enclosedElems);
            for (ExecutableElement ee : ees) {
                note("--ExecutableElement name is " + ee.getSimpleName()); //often is method name
                List<? extends AnnotationMirror> as = ee.getAnnotationMirrors();//获取方法的Annotations
                note("--as=" + as);
                note("---------------- AnnotationMirror >>> start ()------------------");
                for (AnnotationMirror am : as) {
                    //获取Annotation的值
                    Map<? extends ExecutableElement, ? extends AnnotationValue> map = am.getElementValues();
                    Set<? extends ExecutableElement> ks = map.keySet();
                    for (ExecutableElement k : ks) {//打印Annotation的每个值
                        AnnotationValue av = map.get(k);
                        note("----" + ee.getSimpleName() + "." + k.getSimpleName() + "=" + av.getValue());
                    }
                }
                note("---------------- AnnotationMirror >>> end ()------------------");
            }
        }
        return false;
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ToBeTested {
    String owner() default "Chinajash";

    String group();
}