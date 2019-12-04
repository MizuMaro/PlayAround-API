package com.playaround.playaroundapi.controller;

import com.playaround.playaroundapi.bo.UserPA;
import com.playaround.playaroundapi.models.AuthenticationRequest;
import com.playaround.playaroundapi.models.AuthenticationResponse;
import com.playaround.playaroundapi.models.SigninRequest;
import com.playaround.playaroundapi.services.UserService;
import com.playaround.playaroundapi.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    Iterable<UserPA> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @GetMapping("/{name}")
    UserPA getUser(@PathVariable String name){
        return this.userService.getUser(name);
    }

    @DeleteMapping("/{name}")
    void deleteTrainer(@PathVariable String name){
        this.userService.deleteUser(name);
    }

    @PostMapping
    UserPA createTrainer(@RequestBody UserPA user){
        return this.userService.createUser(user);
    }


    @RequestMapping(value = "/signin",method = RequestMethod.POST)
    public ResponseEntity<?> signUp(@RequestBody SigninRequest user) throws Exception{
        UserPA u= new UserPA(user.getEmail(),user.getUsername(),user.getPassword());
        this.userService.createUser(u);
        return ResponseEntity.ok(u.getUsername());
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthentificationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserPA userDetail = userService.getUser(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetail);
        return ResponseEntity.ok(new AuthenticationResponse(jwt, userDetail));
    }



}
