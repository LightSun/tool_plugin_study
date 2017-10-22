

//idea插件开发的一些介绍
http://www.360doc.com/content/14/1107/13/16650130_423318501.shtml

idea 3大组件： applicationComponent， projectComponent， moduleComponent
        这3种实现类无需手动注册

获取组件： final ModuleImpl c = ApplicationManager.getApplication().getComponent(ModuleImpl.class);


extensionPoints
 Extensions.getExtensions("xxx_id")

 //获取psi注解
 PsiClass psiClass = ...;
 PsiModifierList psiModifierList = psiClass.getModifierList();
 PsiAnnotation[] annotations = psiModifierList.getAnnotations();

//idea api 官方文档
https://www.jetbrains.org/intellij/sdk/docs/faq.html
//psi doc
https://www.jetbrains.org/intellij/sdk/docs/basics/architectural_overview/psi_files.html
