package demo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import demo.spring.bean.User;
import demo.spring.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ModelAndView displayUser() {
        ModelAndView model = new ModelAndView("user/users");
        model.addObject("users", this.userService.findAll());
        return model;
    }
    
    @GetMapping("/user/{identifier}")
    public ModelAndView displayUser(@PathVariable Long identifier) {
        ModelAndView model = new ModelAndView("user/edit");
        model.addObject("user", this.userService.findById(identifier));
        return model;
    }

    @GetMapping("/user/initForm")
    public ModelAndView initForm() {
        ModelAndView model = new ModelAndView("user/edit", "user", new User());
        return model;
    }

    @PostMapping(path = "/user")
    public ModelAndView createUser(@ModelAttribute User user) {
        this.userService.addUser(user);
        return new ModelAndView("redirect:/user");
    }

    @GetMapping("/user/delete/{identifier}")
    public ModelAndView deleteUser(@PathVariable Long identifier) {
        this.userService.deleteUser(identifier);
        return new ModelAndView("redirect:/user");
    }

    @DeleteMapping("/user/search")
    public ModelAndView searchUser(@RequestParam String name) {
        // Implementation
        return new ModelAndView("user/users");
    }

}
