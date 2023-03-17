package com.xiilab.keycloakdemo.dto;

import lombok.Builder;
import lombok.Getter;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;

@Getter
@Builder
public class UserDTO {
    private String username;
    private String password;
    private UserRole userRole;

    public UserRepresentation createUserRepresentation() {
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setEnabled(true);
        userRepresentation.setUsername(username);
        userRepresentation.setCredentials(List.of(createUserCredentialRepresentation()));
        return userRepresentation;
    }

    public CredentialRepresentation createUserCredentialRepresentation() {
        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setTemporary(false);
        credentialRepresentation.setType("password");
        credentialRepresentation.setValue(password);
        return credentialRepresentation;
    }
}
