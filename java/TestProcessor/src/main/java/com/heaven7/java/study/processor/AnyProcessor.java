package com.heaven7.java.study.processor;

import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;

/**
 * Created by heaven7 on 2017/6/8 0008.
 */
@SupportedAnnotationTypes("*")//可以用"*"表示支持所有Annotations
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class AnyProcessor extends MyAnnotationProcessor{

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}
