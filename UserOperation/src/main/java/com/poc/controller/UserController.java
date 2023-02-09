package com.poc.controller;


import com.poc.entity.ERole;
import com.poc.entity.Role;
import com.poc.entity.User;
import com.poc.payloads.request.LoginRequest;
import com.poc.payloads.request.SignupRequest;
import com.poc.payloads.response.JwtResponse;
import com.poc.payloads.response.MessageResponse;
import com.poc.repo.RoleRepo;
import com.poc.repo.UserRepo;
import com.poc.security.jwt.JwtUtils;
import com.poc.security.service.impl.UserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v2")
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder encoder;


    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        System.out.println("Checking");
        if (userRepo.existsByUsername(signupRequest.getUsername())){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already exist!"));
        }

        if (userRepo.existsByEmail(signupRequest.getEmail())){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email ia already exist"));
        }

        System.out.println("Account creation start");
        //Creating New Account
        User user = new User(signupRequest.getUsername(),signupRequest.getEmail(), encoder.encode(signupRequest.getPassword()));


        Set<String> strRoles = signupRequest.getRole();

        user.setEmail(signupRequest.getEmail());
        user.setPassword(encoder.encode(signupRequest.getPassword()));
        user.setUsername(signupRequest.getUsername());
        user.setCountry(signupRequest.getCountry());
        user.setState(signupRequest.getState());
        user.setDistrict(signupRequest.getDistrict());
        user.setPinCode(signupRequest.getPinCode());
        user.setAadhaarCard(signupRequest.getAadhaarCard());
        user.setPanCard(signupRequest.getPanCard());
        user.setCity(signupRequest.getCity());
        user.setMobileNo(signupRequest.getMobileNo());


        Set<Role> roles = new HashSet<>();

        if (strRoles == null){
            Role userRole = roleRepo.findByName(ERole.ROLE_USER)
                    .orElseThrow(()-> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role ->{
                switch (role){
                    case "admin":
                        Role adminRole = roleRepo.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(()-> new RuntimeException("Error: Role not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepo.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(()-> new RuntimeException("Error: Role not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepo.findByName(ERole.ROLE_USER)
                                .orElseThrow(()-> new RuntimeException("Error: Role not found."));
                        roles.add(userRole);
                }
            });
        }
        System.out.println("Save in progress");

        user.setRoles(roles);
        userRepo.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully..!"));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailImpl userDetails = (UserDetailImpl) authentication.getPrincipal();

        String jwt = jwtUtils.generateJwtToken(userDetails);

        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));

    }

    @PostMapping("/uploadfiles")
    public ResponseEntity<?> uploadFiles(@RequestParam("myFiles") MultipartFile[] multipartFiles) throws IOException{
        for (MultipartFile multipartFile : multipartFiles){
            multipartFile.transferTo(new File("" + multipartFile.getOriginalFilename()));
        }
        return ResponseEntity.ok(new MessageResponse("File Uploaded Successfully"));
    }

}
