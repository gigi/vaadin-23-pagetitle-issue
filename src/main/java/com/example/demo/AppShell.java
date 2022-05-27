package com.example.demo;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.AppShellSettings;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;

/**
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 */
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
public class AppShell implements AppShellConfigurator {
    @Override
    public void configurePage(AppShellSettings settings) {
        AppShellConfigurator.super.configurePage(settings);
        settings.setPageTitle("Default title from the AppShell");
    }
}
