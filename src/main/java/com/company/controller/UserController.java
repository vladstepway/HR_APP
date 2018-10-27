package com.company.controller;

import com.company.model.User;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable int id, ModelMap userModel) {
        userModel.addAttribute("user", userService.getUser(id));
        return "user/userInfo";
    }

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public String getUsers(ModelMap userModel) {
        userModel.addAttribute("user", userService.getAllUsers());
        return "user/allUsers";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public String addPage(Model model) {
        model.addAttribute("user", new User());
        return "user/addUser";
    }

    @RequestMapping(value = "/user/add.do", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult bindingResult,
                          Model userModel) {
        if (bindingResult.hasErrors()) {
            return "user/addUser";
        }
        userModel.addAttribute("user", user);
        userModel.addAttribute("order", "ASC");
        int resp = userService.addUser(user);
        if (resp > 0) {
            userModel.addAttribute("msg", "User with id : " + resp + " added successfully.");
            userModel.addAttribute("user", userService.getAllUsers());
            return "user/allUsers";
        } else {
            userModel.addAttribute("msg", "User addition failed.");
           return "user/addUser";
        }
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") int id, ModelMap userModel) {
        int resp = userService.deleteUser(id);
        userModel.addAttribute("user", userService.getAllUsers());
        if (resp > 0) {
            userModel.addAttribute("msg", "User with id : " + id + " deleted successfully.");
        } else {
            userModel.addAttribute("msg", "User with id : " + id + " deletion failed.");
        }
        return "user/allUsers";
    }
    @RequestMapping(value = "/users/sorting/{order}/sortBy/surname", method = RequestMethod.GET)
    public String sortUserSurname(@PathVariable("order") String order, ModelMap userModel) {
        if(order.equals("ASC")) {
            userModel.addAttribute("user", userService.getSortedUsersBySurname());
            userModel.addAttribute("order", "DESC");
        }
        else {
            userModel.addAttribute("user", userService.getSortedUsersDESCsurname());
            userModel.addAttribute("order", "ASC");
        }
        return "user/allUsers";
    }
    @RequestMapping(value = "/users/sorting/{order}/sortBy/name", method = RequestMethod.GET)
    public String sortUserName(@PathVariable("order") String order, ModelMap userModel) {
        if(order.equals("ASC")) {
            userModel.addAttribute("user", userService.getSortedUsersByName());
            userModel.addAttribute("order", "DESC");

        }
        else {
            userModel.addAttribute("user", userService.getSortedUsersDESCname());
            userModel.addAttribute("order", "ASC");
        }
        return "user/allUsers";
    }
    @RequestMapping(value = "/users/sorting/{order}/sortBy/id", method = RequestMethod.GET)
    public String sortUserId(@PathVariable("order") String order, ModelMap userModel) {
        if(order.equals("ASC")) {
            userModel.addAttribute("user", userService.getSortedUsersByID());
            userModel.addAttribute("order", "DESC");

        }
        else {
            userModel.addAttribute("user", userService.getSortedUsersDESCid());
            userModel.addAttribute("order", "ASC");
        }
        return "user/allUsers";
    }

    @RequestMapping(value = "/user/update/{id}", method = RequestMethod.GET)
    public String updatePage(@PathVariable("id") int id, ModelMap userModel) {
        userModel.addAttribute("id", id);
        userModel.addAttribute("user", userService.getUser(id));
        return "user/updateUser";
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult bindingResult,
                             Model userModel) {
        if (bindingResult.hasErrors()) {
            return "user/updateUser";
        }
        userModel.addAttribute("user", user);

        int resp = userService.updateUser(user);
        userModel.addAttribute("id", user.getId());
        if (resp > 0) {
            userModel.addAttribute("msg", "User with id : " + user.getId() + " updated successfully.");
            userModel.addAttribute("user", userService.getAllUsers());
            return "user/allUsers";
        } else {
            userModel.addAttribute("msg", "User with id : " + user.getId() + " update failed.");
            userModel.addAttribute("user", userService.getUser(user.getId()));
            return "user/updateUser";
        }
    }

    @ModelAttribute("order")
    public String getOrder() {
        return "ASC";
    }
}