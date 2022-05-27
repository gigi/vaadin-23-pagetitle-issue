package com.example.demo.view;

import com.example.demo.layout.BasicLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.PostConstruct;

@Route(value = "dynamic-title-page", layout = BasicLayout.class)
public class PageWithDynamicTitle extends AbstractView implements HasDynamicTitle {

  @PostConstruct
  private void buildUI() {
    add(new Label("Hello from PageWithDynamicTitle"));
  }

  @Override
  public String pageTitle() {
    return "Shaded title";
  }

  @Override
  public String getPageTitle() {
    return "Dynamic title proper override";
  }
}
