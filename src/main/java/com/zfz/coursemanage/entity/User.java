package com.zfz.coursemanage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfz.coursemanage.entity.enums.RoleEnum;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class User implements UserDetails {
    private String username;
    private String name;
    @JsonIgnore
    private String password;
    private RoleEnum role;

    public User(String name,String username, String password, RoleEnum role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
    }

    public User() {
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.toString()));
        return authorities;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
