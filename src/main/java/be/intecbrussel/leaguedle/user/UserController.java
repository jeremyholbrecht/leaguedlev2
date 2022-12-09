package be.intecbrussel.leaguedle.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public String allUsers(Model model){
        for (User user: userService.allUsers()){
            System.out.println(user);
        }
        model.addAttribute("users", userService.allUsers());
        return "users";
    }

}
