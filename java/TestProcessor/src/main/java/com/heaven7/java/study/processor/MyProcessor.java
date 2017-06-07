package com.heaven7.java.study.processor;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * 步骤： build jar
 * .java 源代码生成器 github. TypeSpec
 */
@SupportedAnnotationTypes({"com.heaven7.java.study.processor.PrintMe"})
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class MyProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
        Messager messager = processingEnv.getMessager();
        for (TypeElement te : annotations) {
            for (Element e : env.getElementsAnnotatedWith(te)) {
                messager.printMessage(Diagnostic.Kind.NOTE, "type： " +  e.asType());
                messager.printMessage(Diagnostic.Kind.NOTE, "type： " +  e.getAnnotationMirrors());
                messager.printMessage(Diagnostic.Kind.NOTE, "type： " +  e.getEnclosedElements());
                messager.printMessage(Diagnostic.Kind.NOTE, "type： " +  e.getEnclosingElement());
                messager.printMessage(Diagnostic.Kind.NOTE, "type： " +  e.getKind());
                messager.printMessage(Diagnostic.Kind.NOTE, "Printing: " + e.toString());
            }
        }
        return true;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}