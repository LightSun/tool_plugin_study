package com.github.lightsun.study;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.search.GlobalSearchScope;

public class InspectionPsiUtil {

    public static VirtualFile fqnToSourceFile (Project i_project,
                                               String i_class) {
        String fqn = i_class.endsWith (".java")
                ? i_class.replaceFirst (".java", "")
                : i_class;

        final PsiClass psiClass = createPsiClass(fqn, i_project);
        if (null == psiClass) {
            return null;
        }
        final PsiModifierList list = psiClass.getModifierList();
        final PsiAnnotation[] annotations = list.getAnnotations();
        for (PsiAnnotation pa: annotations){
           // pa.findAttributeValue("").getText()
        }
        PsiElement psiClassSource = psiClass.getNavigationElement ();
// to avoid viewing the decompiled class
        PsiFile psiFile = psiClassSource.getContainingFile ();

        return psiFile.getVirtualFile ();
    }

    //TODO important
    public static PsiClass createPsiClass(String qualifiedName, Project project) {
        final JavaPsiFacade psiFacade = JavaPsiFacade.getInstance(project);
        final GlobalSearchScope searchScope = GlobalSearchScope.allScope(project);
        return psiFacade.findClass(qualifiedName, searchScope); 
    } 
 
    public static boolean isAbstactClass(PsiClass aClass) { 
        if (aClass == null || aClass.getModifierList() == null) { 
            return false; 
        } 
 
        return aClass.getModifierList().hasModifierProperty("abstract"); 
    } 
 
    public static boolean isStaticMethod(PsiMethod method) {
        return hasMethodModifier(method, "static"); 
    } 
 
    public static boolean isPublicMethod(PsiMethod method) { 
        return hasMethodModifier(method, "public"); 
    } 
 
    private static boolean hasMethodModifier(PsiMethod method, String aStatic) { 
        return method != null && 
                method.getModifierList().hasModifierProperty(aStatic); 
    } 
 
}
