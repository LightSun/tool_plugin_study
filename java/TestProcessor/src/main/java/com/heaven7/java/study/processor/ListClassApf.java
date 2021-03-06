/*
package com.heaven7.java.study.processor;

import java.util.Arrays;
import java.util.Collection;
import com.sun.mirror.apt.*;
import com.sun.mirror.declaration.*;
import com.sun.mirror.type.*;
import com.sun.mirror.util.*;

import java.util.Collection;
import java.util.Set;
import java.util.Arrays;

import static java.util.Collections.*;
import static com.sun.mirror.util.DeclarationVisitors.*;

import static java.util.Collections.unmodifiableCollection;

//apt is remove in jdk1.9 . and replaced by 'Pluggable Annotation Processing API'.
*/
/*
 * This class is used to run an annotation processor that lists class
 * names.  The functionality of the processor is analogous to the
 * ListClass doclet in the Doclet Overview.
 *//*

public class ListClassApf implements AnnotationProcessorFactory {
    // Process any set of annotations
    private static final Collection<String> supportedAnnotations
        = unmodifiableCollection(Arrays.asList("*"));

    // No supported options
    private static final Collection<String> supportedOptions = emptySet();

    public Collection<String> supportedAnnotationTypes() {
        return supportedAnnotations;
    }

    public Collection<String> supportedOptions() {
        return supportedOptions;
    }

    public AnnotationProcessor getProcessorFor(
            Set<AnnotationTypeDeclaration> atds,
            AnnotationProcessorEnvironment env) {
        return new ListClassAp(env);
    }

    private static class ListClassAp implements AnnotationProcessor {
        private final AnnotationProcessorEnvironment env;
        ListClassAp(AnnotationProcessorEnvironment env) {
            this.env = env;
        }

        public void process() {
            for (TypeDeclaration typeDecl : env.getSpecifiedTypeDeclarations())
		typeDecl.accept(getDeclarationScanner(new ListClassVisitor(),
						      NO_OP));
        }

	private static class ListClassVisitor extends SimpleDeclarationVisitor {
	    public void visitClassDeclaration(ClassDeclaration d) {
		System.out.println(d.getQualifiedName());
	    }
	}
    }
}*/
