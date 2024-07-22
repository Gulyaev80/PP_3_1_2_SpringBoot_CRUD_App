package com.gulyaev.PP_3_1_2_SpringBoot_CRUD_App.controller;

import com.gulyaev.PP_3_1_2_SpringBoot_CRUD_App.model.User;
import com.gulyaev.PP_3_1_2_SpringBoot_CRUD_App.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String withdrawAllUsers(Model model) {
        List<User> users = userService.withdrawAllUsers();
        model.addAttribute("users", users);
        return "user/allUsers";
    }

    @GetMapping("/new")
    public String createUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/creatUser";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/creatUser";
        }

        userService.saveUser(user);
        return "redirect:/user";
    }

    @GetMapping("/edit")
    public String editUserForm(@RequestParam("id") Long id, Model model) {
        Optional<User> userById = userService.findByUserId(id);

        if (userById.isPresent()) {
            model.addAttribute("user", userById.get());
            return "user/editUser";
        } else {
            return "redirect:/user";
        }
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/editUser";
        }

        userService.updateUser(user);
        return "redirect:/user";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteByUser(id);
        return "redirect:/user";
    }

}
