package com.donelleharris.metropolitanmuseumapi.controllers;

import com.donelleharris.metropolitanmuseumapi.models.User;
import com.donelleharris.metropolitanmuseumapi.repositories.ArtRepository;
import com.donelleharris.metropolitanmuseumapi.repositories.ArtistRepository;
import com.donelleharris.metropolitanmuseumapi.repositories.UserRepository;
import com.donelleharris.metropolitanmuseumapi.repositories.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserRepository userDao;
    private final ArtistRepository artistDao;
    private final ArtRepository artDao;
    private final UsersRepository users;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao,
                          ArtistRepository artistDao,
                          ArtRepository artDao,
                          UsersRepository users,
                          PasswordEncoder passwordEncoder
    ) {
        this.userDao = userDao;
        this.artistDao = artistDao;
        this.artDao = artDao;
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/logout")
    public String logout(){
        //remove session user
        return "redirect:/index";
    }

    public String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/register")
    public String saveUser(@Valid User user,
                           Errors validation,
                           Model model,
                           @ModelAttribute User newUser,
                           @RequestParam(name = "photo_url") String photo_url
    ){
        if(validation.hasErrors() || (!newUser.getPassword().equals(newUser.getPassword_confirm()))){
            model.addAttribute("errors", validation);
            model.addAttribute("user", user);
            return "users/register";
        } else {
            if (newUser.getPassword().equals(newUser.getPassword_confirm())) {
                String hash = passwordEncoder.encode(newUser.getPassword());
                newUser.setPassword(hash);
                newUser.setPassword_confirm(hash);
            }
            users.save(newUser);
            return "redirect:/login";
        }
    }

    @GetMapping("/profile")
    public String getProfile(Model model) {
        return "users/profile";
    }
}
