package com.playaround.playaroundapi.controller;

import com.playaround.playaroundapi.bo.UserPA;
import com.playaround.playaroundapi.models.*;
import com.playaround.playaroundapi.services.UserService;
import com.playaround.playaroundapi.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
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
    UserPaDetailResponse getUser(@PathVariable String name){
        return new UserPaDetailResponse(this.userService.getUser(name));
    }

    @GetMapping("/userInfo")
    UserPaDetailResponse getUserWithToken(@RequestHeader(name="token") String token){
        return new UserPaDetailResponse(this.userService.getUserbyId(jwtTokenUtil.extractUserId(token)));
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
        u = this.userService.createUser(u);
        return ResponseEntity.ok(new SigninResponse(u.getId(),u.getUsername()));
    }


    @RequestMapping(value = "/updateProfile",method = RequestMethod.POST)
    public ResponseEntity<?> updateProfile(@RequestHeader(name="token") String token, @RequestBody UpdateUserInfoRequest user) throws Exception{
        UserPA u= this.userService.getUserbyId(jwtTokenUtil.extractUserId(token));
        u.setBio(user.getBio());
        u.setBirthDate(user.getBirthDate());
        u.setImageUrl(user.getImageUrl());
        u.setLocation(user.getLocation());
        this.userService.updateUser(u);
        return ResponseEntity.ok(new SigninResponse(u.getId(),u.getUsername()));
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

    @RequestMapping(value = "/addToFav", method = RequestMethod.POST)
    void addToFavoriteGames(@RequestHeader(name = "token") String token, @RequestBody FavoriteGamesRequest request){
        UserPA u = this.userService.getUserbyId(jwtTokenUtil.extractUserId(token));

        this.userService.addGameToFavorites(u, request.getGameId());
        this.userService.updateUser(u);

    }

    @RequestMapping(value = "/removeFromFav", method = RequestMethod.POST)
    void removeFromFavoriteGames(@RequestHeader(name = "token") String token, @RequestBody FavoriteGamesRequest request){
        UserPA u = this.userService.getUserbyId(jwtTokenUtil.extractUserId(token));

        this.userService.removeGameFromFavorites(u, request.getGameId());
    }

    @RequestMapping(value = "/getAllFavoriteGames", method = RequestMethod.GET)
    List<String> getAllFavoriteGames(@RequestHeader(name = "token") String token){
        UserPA u = this.userService.getUserbyId(jwtTokenUtil.extractUserId(token));

        return this.userService.getAllFavoriteGames(u);
    }




}
