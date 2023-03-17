package com.xiilab.keycloakdemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DemoController {
    @PreAuthorize("hasRole('MANAGER')")
    @GetMapping("/admin")
    public String getAdmin() {
        return "admin";
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String getUser() {
        return "user";
    }
    @GetMapping("/anyone")
    public String getAnyone() {
        return "anyone";
    }
}
