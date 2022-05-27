package com.example.demo.view;

import com.example.demo.event.PageChangedEvent;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;

/** The main view contains a button and a click listener. */
public abstract class AbstractView extends VerticalLayout
    implements AfterNavigationObserver, CustomTitle {

  public AbstractView() {
    add(new Label("Hello from parent view without dependencies"));
  }

  @Override
  public void afterNavigation(AfterNavigationEvent event) {
    ComponentUtil.fireEvent(
        event.getLocationChangeEvent().getUI(),
        new PageChangedEvent(this, event.getLocationChangeEvent()));
  }
}
