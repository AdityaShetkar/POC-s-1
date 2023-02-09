package com.neo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private int id;

    @NotBlank(message = "Field should not be Empty..!")
    @Size(min = 3, max = 20, message = "Name should be 3 - 20 characters")
    @Pattern(regexp = "/^[a-zA-Z]+$/")
    private String name;

    @NotBlank(message = "Field should not be Empty..!")
    @Size(min = 2, max = 12, message = "Name should be 3 - 20 characters")
    @Pattern(regexp = "/^[a-zA-Z]+$/")
    private String city;

    @NotBlank(message = "Field should not be Empty..!")
    @Pattern(regexp = "/[0-9]/")
    private long roll_no;

    @NotBlank(message = "Field should not be Empty..!")
    @Email
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @NotBlank(message = "Field should not be Empty..!")
    @Size(min = 10, max = 10, message = "PAN should be 10 characters")
    @Pattern(regexp = "/[A-Z]{5}[0-9]{4}[A-Z]{1}/")
    private String pan;

    @NotBlank(message = "Field should not be Empty..!")
    @Size(min = 12, max = 12, message = "PAN should be 12 characters")
    @Pattern(regexp = "/^[2-9]{1}[0-9]{3}\\s{1}[0-9]{4}\\s{1}[0-9]{4}$/")
    private String aadhar_card;
}
