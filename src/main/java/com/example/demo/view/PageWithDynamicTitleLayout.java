package com.example.demo.view;

import com.example.demo.layout.DynamicTitleLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;

import javax.annotation.PostConstruct;

@Route(value = "dynamic-title-layout", layout = DynamicTitleLayout.class)
public class PageWithDynamicTitleLayout extends Div {
  @PostConstruct
  private void buildUI() {
    add(new Label("Hello from PageWithDynamicTitleLayout"));
  }
}
