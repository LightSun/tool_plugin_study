package com.github.lightsun.study;

import com.intellij.openapi.application.ApplicationListener;
import org.jetbrains.annotations.NotNull;

/**
 * Created by heaven7 on 2017/10/21.
 */
public class ApplicationListenerImpl implements ApplicationListener {
    @Override
    public boolean canExitApplication() {
        return false;
    }

    @Override
    public void applicationExiting() {

    }

    @Override
    public void beforeWriteActionStart(@NotNull Object o) {

    }

    @Override
    public void writeActionStarted(@NotNull Object o) {

    }

    @Override
    public void writeActionFinished(@NotNull Object o) {

    }

    @Override
    public void afterWriteActionFinished(@NotNull Object o) {

    }
}
