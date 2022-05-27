package com.example.demo.view;

import com.example.demo.layout.BasicLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;

import javax.annotation.PostConstruct;

@Route(value = "custom", layout = BasicLayout.class)
public class CustomPage extends AbstractView {
  @PostConstruct
  private void buildUI() {
    add(new Label("Hello from CustomPage"));
  }

  @Override
  public String pageTitle() {
    return "Custom page";
  }
}
