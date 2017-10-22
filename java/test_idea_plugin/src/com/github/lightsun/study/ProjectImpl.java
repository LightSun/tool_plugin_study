package com.github.lightsun.study;

import com.intellij.ide.scratch.ScratchRootType;
import com.intellij.lang.java.JavaLanguage;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.fileTypes.StdFileTypes;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.util.messages.MessageBusConnection;

/**
 * Created by heaven7 on 2017/10/21.
 */
public class ProjectImpl extends BaseComponentImpl implements ProjectComponent{

    final MessageBusConnection messageBus = ProjectManager
            .getInstance()
            .getDefaultProject()
            .getMessageBus()
            .connect();

    @Override
    public void initComponent() {
         //VirtualFileManager.getInstance().addVirtualFileListener
        //VirtualFileManager.getInstance().addVirtualFileManagerListener();
        messageBus.subscribe(VirtualFileManager.VFS_CHANGES);
        FileTypeManager.getInstance().associateExtension(StdFileTypes.XML, "ccc");
        final Project project = ProjectManager.getInstance().getDefaultProject();
        ScratchRootType.getInstance().createScratchFile(
                project,
               "xxx.java",
               JavaLanguage.INSTANCE, "");
       /* final PsiFile psiFileFromText = PsiFileFactory
                .getInstance(project)
                .createFileFromText("newSnippet." + fileExtension,
                        psiFile.getVirtualFile().getFileType(), selectedText);
        Document newDocument = PsiDocumentManager.getInstance(project).getDocument(psiFileFromText);*/
    }


    @Override
    public void disposeComponent() {
        messageBus.disconnect();
    }

    @Override
    public void projectClosed() {

    }
    @Override
    public void projectOpened() {
    }
}
