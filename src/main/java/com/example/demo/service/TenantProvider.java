package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class TenantProvider {
  public String getTenant() {
    return "Test tenant";
  }
}
