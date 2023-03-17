package com.xiilab.keycloakdemo.repository;

import com.xiilab.keycloakdemo.config.KeycloakAdminConfig;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Repository;

import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class KeycloakRepository {
    private final KeycloakAdminConfig keycloakAdminConfig;

    private Keycloak getAdminConfig() {
        return keycloakAdminConfig.keycloakAdmin();
    }

    public UserRepresentation getUser(String userName) {
        return getAdminConfig()
                .realm("keycloakDemo")
                .users()
                .search(userName)
                .get(0);
    }

    public Response createUser(UserRepresentation userRepresentation) {
        return getAdminConfig()
                .realm("keycloakDemo")
                .users()
                .create(userRepresentation);
    }
}
