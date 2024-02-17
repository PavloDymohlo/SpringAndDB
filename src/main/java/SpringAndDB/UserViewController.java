package SpringAndDB;

import SpringAndDB.User;
import SpringAndDB.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserViewController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ModelAndView getUsersPage() {
        ModelAndView modelAndView = new ModelAndView("users_list");
        List<User> userList = userService.getAllUsers();
        modelAndView.addObject("users", userList);
        return modelAndView;
    }

}