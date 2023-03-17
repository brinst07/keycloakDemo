package com.xiilab.keycloakdemo.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.RealmRepresentation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class KeycloakInitializerRunner implements CommandLineRunner {
    private final Keycloak keycloak;
    @Override
    public void run(String... args) throws Exception {
        log.info("Initializing 'keycloakDemo' realm in Keycloak ....");

        Optional<RealmRepresentation> keycloakDemo = keycloak.realms()
                .findAll()
                .stream()
                .filter(realm -> realm.getRealm().equals("keycloakDemo"))
                .findAny();
        RealmRepresentation realmRepresentation = new RealmRepresentation();
        realmRepresentation.setRegistrationAllowed(true);
        log.info("keycloakDemo realm ready YN : {}", keycloakDemo.isPresent());
    }
}
