package com.example.userdata.userdataapi.controller;

import com.example.userdata.userdataapi.entity.User;
import com.example.userdata.userdataapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;


@Controller
public class UserController implements WebMvcConfigurer {

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listUsers(Model model){

        model.addAttribute("user",userService.getAllUsers());
        return "users";
    }


    @GetMapping("/user/new")
    public String createUserForm(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "create_user";
    }

    @PostMapping("/users")
    public String saveUser(@Valid User user, Errors errors, Model model){
    if (errors.hasErrors()){
        return "create_user";
    }else{
        model.addAttribute(user);
        userService.saveUser(user);
        return "redirect:/users";
    }

    }

    /*
        @PostMapping("/users")
        public String saveUser(@ModelAttribute("user") User user){
            userService.saveUser(user);
            return "redirect:/users";
        }



        @GetMapping("/user/new")
        public String createUserForm( Model model){
                User user = new User();
                model.addAttribute("user",user);
                return "create_user";
        }



        @PostMapping("/users")
        public String saveUser( @Valid @ModelAttribute("user")  BindingResult error ) {
            User user = new User();
            if(error.hasErrors()){
                return "create_user";
            }
            else{
                userService.saveUser(user);
                return "redirect:/users";
            }

        }


     */
    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable Integer id,Model model){
        model.addAttribute("user",userService.getUserById(id));
        return "edit_user";
    }

    @PostMapping("/users/{id}")
    public String updateUser(@PathVariable Integer id, @ModelAttribute("user") User user, Model model){

        User extistingUser = userService.getUserById(id);
        extistingUser.setId(id);
        extistingUser.setName(user.getName());
        extistingUser.setEmail(user.getEmail());
        extistingUser.setMobile(user.getMobile());

        userService.saveUser(extistingUser);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public String deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
