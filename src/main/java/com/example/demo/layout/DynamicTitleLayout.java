package com.example.demo.layout;

import com.example.demo.service.AppDefaultsProvider;
import com.example.demo.service.TenantProvider;
import com.example.demo.view.CustomPage;
import com.example.demo.view.Home;
import com.example.demo.view.PageWithDynamicTitle;
import com.example.demo.view.PageWithDynamicTitleLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;

@Tag("app-layout")
public class DynamicTitleLayout extends Component implements RouterLayout, HasDynamicTitle {

  private final Element container;
  private final TenantProvider tenantProvider;
  private final AppDefaultsProvider appDefaultsProvider;

  public DynamicTitleLayout(TenantProvider tenantProvider, AppDefaultsProvider provider) {
    this.appDefaultsProvider = provider;
    this.tenantProvider = tenantProvider;

    Component menu =
        new HorizontalLayout(
            new RouterLink("Home with basic layout", Home.class),
            new RouterLink("Custom page with basic layout", CustomPage.class),
            new RouterLink("Page with dynamic title", PageWithDynamicTitle.class),
            new RouterLink("Page with dynamic title layout", PageWithDynamicTitleLayout.class));

    VerticalLayout container = new VerticalLayout(menu);

    this.container = container.getElement();
  }

  @Override
  public Element getElement() {
    return container;
  }

  @Override
  public String getPageTitle() {
    return "Dynamic title from Router Layout";
  }
}
