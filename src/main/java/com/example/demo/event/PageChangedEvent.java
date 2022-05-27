package com.example.demo.event;

import com.example.demo.view.CustomTitle;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.router.LocationChangeEvent;

public class PageChangedEvent extends ComponentEvent<Component> {

  private final LocationChangeEvent locationChangeEvent;
  private final CustomTitle page;

  public PageChangedEvent(CustomTitle page, LocationChangeEvent locationChangeEvent) {
    super((Component) page, false);
    this.page = page;
    this.locationChangeEvent = locationChangeEvent;
  }

  public CustomTitle page() {
    return page;
  }

  public LocationChangeEvent locationChangeEvent() {
    return locationChangeEvent;
  }
}
