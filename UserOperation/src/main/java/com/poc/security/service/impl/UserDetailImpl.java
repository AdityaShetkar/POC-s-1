package com.poc.security.service.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.poc.entity.Role;
import com.poc.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailImpl implements UserDetails {

    private static final long serialVersionUID = 1L;

    private User user;
    
    private Long id;

    private String userName;

    private  String email;

    @JsonIgnore
    private String password;

    private String country;
    private String state;
    private String district;
    private int pinCode;
    private String aadhaarCard;
    private String panCard;
    private String city;
    private  String mobileNo;
    private Set<Role> roles;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailImpl(Long id, String username, String email, String password, String city, String country, String district, int pinCode, String aadhaarCard, String panCard, String mobileNo, String state, Set<Role> roles, List<GrantedAuthority> authorities) {

        this.id = id;
        this.email = email;
        this.password = password;
        this.userName = username;
        this.city = city;
        this.country = country;
        this.district = district;
        this.pinCode = pinCode;
        this.aadhaarCard = aadhaarCard;
        this.panCard = panCard;
        this.mobileNo = mobileNo;
        this.state = state;
        this.roles = roles;
        this.authorities = authorities;

    }

    public static UserDetailImpl build(User user){
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());



        return new UserDetailImpl(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getCity(),
                user.getCountry(),
                user.getDistrict(),
                user.getPinCode(),
                user.getAadhaarCard(),
                user.getPanCard(),
                user.getMobileNo(),
                user.getState(),
                user.getRoles(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailImpl user = (UserDetailImpl) o;
        return Objects.equals(id, user.id);

    }
}
