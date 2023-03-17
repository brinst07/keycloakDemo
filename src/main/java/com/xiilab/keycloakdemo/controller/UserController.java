package com.xiilab.keycloakdemo.controller;

import com.xiilab.keycloakdemo.dto.UserDTO;
import com.xiilab.keycloakdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getLoginUser(@AuthenticationPrincipal UserDTO userDTO) {
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping("{username}")
    public ResponseEntity<UserRepresentation> getUserByUserName(@PathVariable String username) {
        return new ResponseEntity<>(userService.getUser(username), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Response> createUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.OK);
    }
}
