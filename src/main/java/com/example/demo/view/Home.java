package com.example.demo.view;

import com.example.demo.layout.BasicLayout;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;

import javax.annotation.PostConstruct;

@Route(value = "", layout = BasicLayout.class)
public class Home extends AbstractView {

  @PostConstruct
  private void buildUI() {
    add(new Label("Hello from Home"));
  }

  @Override
  public String pageTitle() {
    return "Home page";
  }
}
