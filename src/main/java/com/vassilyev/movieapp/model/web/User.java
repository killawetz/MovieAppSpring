package com.vassilyev.movieapp.model.web;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "t_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, message = "Логин должен быть меньше 2-х знаков")
    @NotBlank
    private String username;

    @Size(min = 2, message = "Пароль должен быть меньше 2-х знаков")
    private String password;

    @ManyToMany
    private Set<Utype> utypes;

    public User() {}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return utypes;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUtypes(Set<Utype> utypes) {
        this.utypes = utypes;
    }

    public Long getId() {
        return id;
    }

    public Set<Utype> getUtypes() {
        return utypes;
    }
}
