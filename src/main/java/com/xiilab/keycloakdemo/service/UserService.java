package com.xiilab.keycloakdemo.service;

import com.xiilab.keycloakdemo.dto.UserDTO;
import com.xiilab.keycloakdemo.repository.KeycloakRepository;
import lombok.RequiredArgsConstructor;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;

@Service
@RequiredArgsConstructor
public class UserService {
    private final KeycloakRepository keycloakRepository;
    @Cacheable(value = "UserRepresentation", key = "#username", cacheManager = "userCacheManager")
    public UserRepresentation getUser(String username) {
        UserRepresentation user = keycloakRepository.getUser(username);
        return user;
    }
    @CacheEvict(value = "UserRepresentation", key = "#userDTO.username", cacheManager = "userCacheManager")
    public Response createUser(UserDTO userDTO) {
        UserRepresentation userRepresentation = userDTO.createUserRepresentation();
        return keycloakRepository.createUser(userRepresentation);
    }
}
