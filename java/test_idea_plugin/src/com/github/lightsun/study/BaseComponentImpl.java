package com.github.lightsun.study;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.BaseComponent;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.util.messages.MessageBusConnection;

/**
 * Created by heaven7 on 2017/10/21.
 */
public class BaseComponentImpl implements BaseComponent {
    //MessageBus messageBus;
    final MessageBusConnection messageBus = ProjectManager
            .getInstance()
            .getDefaultProject()
            .getMessageBus()
            .connect();

    public BaseComponentImpl() {
        final ModuleImpl c = ApplicationManager.getApplication().getComponent(ModuleImpl.class);
       // ApplicationManager.getApplication().runWriteAction();
        //ApplicationManager.getApplication().getExtensions()
       /* messageBus = ApplicationManager
                .getApplication()
                .getMessageBus();*/
        ProjectManager.getInstance().getDefaultProject().getMessageBus().connect();
    }

    @Override
    public void initComponent() {
       // VirtualFileManager.getInstance().findFileByUrl()
        messageBus.subscribe(VirtualFileManager.VFS_CHANGES);
    }

    @Override
    public void disposeComponent() {
        messageBus.disconnect();
    }
}
