package com.example.demo.layout;

import com.example.demo.event.PageChangedEvent;
import com.example.demo.service.AppDefaultsProvider;
import com.example.demo.service.TenantProvider;
import com.example.demo.view.CustomPage;
import com.example.demo.view.CustomTitle;
import com.example.demo.view.Home;
import com.example.demo.view.PageWithDynamicTitle;
import com.example.demo.view.PageWithDynamicTitleLayout;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.RouterLink;

@PreserveOnRefresh
public class BasicLayout extends AppLayout {

  private final TenantProvider tenantProvider;
  private final AppDefaultsProvider appDefaultsProvider;

  public BasicLayout(TenantProvider tenantProvider, AppDefaultsProvider provider) {
    this.appDefaultsProvider = provider;
    this.tenantProvider = tenantProvider;

    Component menu =
        new HorizontalLayout(
            new RouterLink("Home with basic layout", Home.class),
            new RouterLink("Custom page with basic layout", CustomPage.class),
            new RouterLink("Page with dynamic title", PageWithDynamicTitle.class),
            new RouterLink("Page with dynamic title layout", PageWithDynamicTitleLayout.class));

    addToNavbar(menu);
  }

  @Override
  protected void onAttach(AttachEvent attachEvent) {
    super.onAttach(attachEvent);
    ComponentUtil.addListener(attachEvent.getUI(), PageChangedEvent.class, this::onPageChanged);
  }

  private void onPageChanged(PageChangedEvent event) {
    String title = constructTitle(event.page());
    event.locationChangeEvent().getUI().getPage().setTitle(title);
  }

  private String constructTitle(CustomTitle page) {
    return String.format(
        "%s | %s | %s",
        page.pageTitle(), tenantProvider.getTenant(), appDefaultsProvider.getAppName());
  }
}
