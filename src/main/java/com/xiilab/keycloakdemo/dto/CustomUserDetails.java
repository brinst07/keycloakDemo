package com.xiilab.keycloakdemo.dto;

import com.xiilab.keycloakdemo.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;
@Getter
@Builder
public class CustomUserDetails implements UserDetails, OAuth2User {
    private User user;
    private Map<String,Object> attribute;

    /* 일반 로그인 생성자 */
    public CustomUserDetails(User user) {
        this.user = user;
    }

    /* OAuth2 로그인 사용자 */
    public CustomUserDetails(User user, Map<String, Object> attributes) {
        this.user = user;
        this.attribute = attributes;
    }

    @Override
    public String getName() {
        return this.user.getUsername();
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.attribute;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.user.getAuthorities();
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.user.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.user.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.user.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return this.user.isEnabled();
    }
}
