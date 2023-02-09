package com.poc.payloads.request;

import com.poc.entity.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;


@Data
public class SignupRequest {

    @NotNull
    @Email
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(min = 8, max = 20, message = "Password Should Be Minimum 8 Characters")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\\\\\S+$).{8,20}$")
    private String password;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+ [a-zA-Z]+$")
    private String username;

    @NotNull
    private String country;

    @NotNull
    private String state;

    @NotNull
    private String district;

    @NotNull
    @Pattern(regexp = "^[1-9] {1} [0-9] {2}\\s {0,1} [0-9] {3}$")
    private int pinCode;

    @NotNull
    @Pattern(regexp = "^\\d{4}\\s\\d{4}\\s\\d{4}$")
    private String aadhaarCard;

    @NotNull
    @Pattern(regexp = "[A-Za-z]{5}\\d{4}[A-Za-z]{1}$")
    private String panCard;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]{2,}")
    private String city;

    @NotNull
    @Pattern(regexp = "^\\+?[0-9-]+$")
    private  String mobileNo;
    private Set<String> role;

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

}
